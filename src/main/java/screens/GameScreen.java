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
import Objects.Player;
import gameLogic.Box2DCreator;
import gameLogic.CameraHandler;
import gameLogic.GameContactListener;
import gameLogic.GravityHandler;
import gameLogic.InputHandler;
import inf112.skeleton.app.PlatformGame;
import scenes.Hud;

public class GameScreen implements Screen {
	private PlatformGame game;
	private OrthographicCamera gamecam;
	private Viewport gamePort;
	private Hud hud;
	
	private TmxMapLoader maploader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	
	private String consoleOutput;
	
	//Box2d variabler
	private World world;
	private Box2DDebugRenderer b2dr;
	private Box2DCreator mapGen;
	private Player player1;
	
	//GameLogic
	private InputHandler input;
	private GravityHandler gravity;
	private CameraHandler camera;
	


	public GameScreen(PlatformGame game) {
		this.game = game;
		Gdx.graphics.setResizable(true);
		
		gamecam = new OrthographicCamera();
		gamePort = new FitViewport(PlatformGame.V_Width / PlatformGame.PPM, PlatformGame.V_Height / PlatformGame.PPM, gamecam);
		hud = new Hud(game.batch);
		
		maploader = new TmxMapLoader();
		map = maploader.load("src/main/resources/assets/LabMap/LabMap1.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1 / PlatformGame.PPM);
		gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
		
		//Box2D
		world = new World(new Vector2(0, (float) -9.81), false);
		b2dr = new Box2DDebugRenderer();
		mapGen = new Box2DCreator(world, map);
		player1 = mapGen.player1;
		world.setContactListener(new GameContactListener());

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
		if (player1.Box2DBody.getPosition().x > 1260 / PlatformGame.PPM && player1.Box2DBody.getPosition().y < 64 / PlatformGame.PPM) {
			consoleOutput = "Level Complete, press enter to continue";
			hud.update(gravity, consoleOutput);
			if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) game.setScreen(new MainMenuScreen(game));

			
			/*Testcase for completing a level, 
			 * in this case reaching the nuclear colored square at the far right of the map takes you back to the main menu
			 * The idea being that each map will have a predefined area the player must reach to complete that map
			 * */
		} else if (!player1.isAlive()) {
			consoleOutput = "Player Died, press enter to continue";
			hud.update(gravity, consoleOutput);
			if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) game.setScreen(new MainMenuScreen(game));
		}else
		
		input.input(deltaTime, player1, world, gravity);
		gravity.update(player1);
		world.step(1/60f, 6, 2);
		
		player1.update(deltaTime,gravity);
		for(Actor o : mapGen.mapObjects) {
			o.update(deltaTime,gravity);
		}
		
		
		gamecam = camera.Update(gamecam, player1, gravity);
		hud.update(gravity, consoleOutput);
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
        
        
        //Texture render
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        player1.draw(game.batch);
        for(Actor o : mapGen.mapObjects) {
			o.draw(game.batch);
		}
        game.batch.end();
        hud.stage.draw();
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
