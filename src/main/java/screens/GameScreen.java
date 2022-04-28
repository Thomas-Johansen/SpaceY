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

import Objects.Alien;
import Objects.Cube;
import Objects.Player;
import gameLogic.Box2DCreator;
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
	private Player player1;
	private Alien enemy;
	private Cube cube;
	
	//GameLogic
	public InputHandler input;
	public GravityHandler gravity;
	public World savepoint;
	
	//Test camera
	private float yAxisCamera;
	
	
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
		new Box2DCreator(world, map);
		world.setContactListener(new GameContactListener());
		player1 = new Player(world, new Vector2(100 / PlatformGame.PPM, 100 / PlatformGame.PPM));
		cube = new Cube(world, new Vector2(500 / PlatformGame.PPM, 100 / PlatformGame.PPM));
		enemy = new Alien(world, new Vector2(300/ PlatformGame.PPM, 35/PlatformGame.PPM));
		//GameLogic
		input = new InputHandler();
		gravity = new GravityHandler();
		
		//cam
		yAxisCamera = player1.Box2DBody.getPosition().y;
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
		enemy.update(deltaTime,gravity);
		cube.update(deltaTime,gravity);
		
		//Kamera skal i egen klasse
		gamecam.position.x = player1.Box2DBody.getPosition().x;
		
		
		//Kamera beveger seg opp i inkrementer på 200 pixler
		if (player1.Box2DBody.getPosition().y < yAxisCamera - (200 / PlatformGame.PPM)) {
			yAxisCamera -= (200 / PlatformGame.PPM);
			gamecam.position.y = yAxisCamera;
		}
		if (player1.Box2DBody.getPosition().y > yAxisCamera + (200 / PlatformGame.PPM)) {
			yAxisCamera += (200 / PlatformGame.PPM);
			gamecam.position.y = yAxisCamera;
		}
		
		//Kamera rotasjon test
		switch (gravity.playerGravity) {
		case DOWN:
			gamecam.up.set(0,1,0);
			break;
		case UP:
			gamecam.up.set(0,1,0);
			gamecam.rotate(180);
			break;
		case LEFT:
			gamecam.up.set(0,1,0);
			gamecam.rotate(90);
			break;
		case RIGHT:
			gamecam.up.set(0,1,0);
			gamecam.rotate(270);
			break;
		}
		
		
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
        
        
        //Texture render test for spiller
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        player1.draw(game.batch);
        enemy.draw(game.batch);
        cube.draw(game.batch);
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
