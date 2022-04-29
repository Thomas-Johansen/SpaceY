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
import Objects.Text;
import SpaceY.PlatformGame;
import gameLogic.Box2DCreator;
import gameLogic.CameraHandler;
import gameLogic.GameContactListener;
import gameLogic.GravityHandler;
import gameLogic.InputHandler;
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
	private int currentLevel;
	
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
		currentLevel = 1;

		//Box2D
		switchLevel(currentLevel);
	}
	
	public void switchLevel(int level) {
		maploader = new TmxMapLoader();
		map = maploader.load("src/main/resources/assets/LabMap/LabMap" + level + ".tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1 / PlatformGame.PPM);
		world = new World(new Vector2(0, (float) -9.81), false);
		b2dr = new Box2DDebugRenderer();
		mapGen = new Box2DCreator(world, map);
		player1 = mapGen.player1;
		
		//GameLogic
		input = new InputHandler();
		gravity = new GravityHandler();
		camera = new CameraHandler(player1);
		world.setContactListener(new GameContactListener());
	}
	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void update(float deltaTime) { 
		if (player1.hasWon) {
			consoleOutput = "Level Complete, press enter to continue";
			hud.update(gravity, consoleOutput);
			if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) switchLevel(currentLevel + 1);
		} else if (!player1.isAlive()) {
			consoleOutput = "Player Died, press enter to continue";
			hud.update(gravity, consoleOutput);
			if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) switchLevel(currentLevel);
		}else if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) game.setScreen(new MainMenuScreen(game));
		 else {
		if (input.levelChanged) {
			currentLevel = input.level;
			switchLevel(input.level);
			
		} 
			 
		input.input(deltaTime, player1, world, gravity);
		gravity.update(player1);
		world.step(1/60f, 6, 2);
		
		player1.update(deltaTime,gravity, mapGen.mapObjects);
		player1.checkMaxSpeed();
		for(Actor o : mapGen.mapObjects) {
			o.update(deltaTime,gravity,mapGen.mapObjects);
			o.checkMaxSpeed();
		}
		
		//Updates text output
		consoleOutput = "";
		for (Text text : mapGen.textObjects) {
			if (text.isActive) consoleOutput = text.text;
		}
		
		
		gamecam = camera.Update(gamecam, player1, gravity);
		hud.update(gravity, consoleOutput);
		gamecam.update();
		renderer.setView(gamecam);
		}
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
        for(Actor o : mapGen.mapObjects) {
			o.draw(game.batch);
		}
        player1.draw(game.batch);
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
