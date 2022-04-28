package screens;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import Objects.Actor;
import Objects.Alien;
import Objects.Cube;
import Objects.Player;
import SpaceY.PlatformGame;
import gameLogic.Box2DCreator;
import gameLogic.CameraHandler;
import gameLogic.GameContactListener;
import gameLogic.GravityHandler;
import gameLogic.InputHandler;

public class Multiplayer implements Screen {
	private PlatformGame game;
	private OrthographicCamera gamecam;
	private Viewport gamePort;
	
	private TmxMapLoader maploader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	
	//Box2d variabler
	private World world;
	private Box2DDebugRenderer b2dr;
	private Box2DCreator mapGen;
	private Player player1;
	private Player player2;
	
	//GameLogic
	public InputHandler input;
	public GravityHandler gravity;
	private CameraHandler camera;
	
	
	public Multiplayer(PlatformGame game) {
		this.game = game;
		Gdx.graphics.setResizable(true);
		
		gamecam = new OrthographicCamera();
		gamePort = new FitViewport(PlatformGame.V_Width / PlatformGame.PPM, PlatformGame.V_Height / PlatformGame.PPM, gamecam);
		
		maploader = new TmxMapLoader();
		map = maploader.load("src/main/resources/assets/LabMap/Multiplayer.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1 / PlatformGame.PPM);
		world = new World(new Vector2(0, (float) -9.81), false);
		b2dr = new Box2DDebugRenderer();
		mapGen = new Box2DCreator(world, map);
		world.setContactListener(new GameContactListener());
		player1 = mapGen.player1;
		player2 = mapGen.player2;

		//GameLogic
		input = new InputHandler();
		gravity = new GravityHandler();
		camera = new CameraHandler(player1);
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void update(float deltaTime) {
		//Cases for å skjekke om en av spillerne har vunnet
		if (!player1.isAlive()){
		}
		if (!player2.isAlive()){
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) game.setScreen(new MainMenuScreen(game));
			
		input.input(deltaTime, player1, player2, world, gravity);
		world.step(1/60f, 6, 2);
		
		player1.update(deltaTime,gravity,mapGen.mapObjects);
		player1.checkMaxSpeed();
		player2.update(deltaTime,gravity,mapGen.mapObjects);
		player2.checkMaxSpeed();
		for(Actor o : mapGen.mapObjects) {
			o.update(deltaTime,gravity,mapGen.mapObjects);
			o.checkMaxSpeed();
		}
		
		
		
		gamecam = camera.Update(gamecam, player1, player2, gravity);
		gamecam.update();
		renderer.setView(gamecam);
	}
	
	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        renderer.render();
        
        //Viser linjer rundt Box2D render, skal fjernes når spillet er ferdig
        b2dr.render(world, gamecam.combined);
        
        
   
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        for(Actor o : mapGen.mapObjects) {
			o.draw(game.batch);
		}
        player1.draw(game.batch);
        player2.draw(game.batch);
        game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		gamePort.update(width,height);
		gamecam.update();
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	//Litt usikker på nøyaktig hva som skal og ikke skal disposes
	public void dispose() {
		map.dispose();
		renderer.dispose();
		world.dispose();
		b2dr.dispose();	
	}
}
