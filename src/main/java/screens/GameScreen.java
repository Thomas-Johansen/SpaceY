package screens;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import Objects.Player;
import gameLogic.Box2DCreator;
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
	
	//Box2d variabler
	private  World world;
	private Box2DDebugRenderer b2dr;
	private  Player player1;
	private Player player2;
	
	//GameLogic
	public InputHandler input;
	
	//Test camera
	private float yAxisCamera;
	
	
	
	
	public GameScreen(PlatformGame game) {
		this.game = game;
		gamecam = new OrthographicCamera();
		gamePort = new FitViewport(PlatformGame.V_Width / PlatformGame.PPM, PlatformGame.V_Height / PlatformGame.PPM, gamecam);
		hud = new Hud(game.batch);
		
		maploader = new TmxMapLoader();
		map = maploader.load("src/main/resources/assets/LabMap/LabMap1.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1 / PlatformGame.PPM);
		gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
		
		//Box2D
		world = new World(new Vector2(0, (float) -9.81), true);
		b2dr = new Box2DDebugRenderer();
		new Box2DCreator(world, map);
		player1 = new Player(world);
		player1.Box2DBody.setTransform(200 / PlatformGame.PPM,100 / PlatformGame.PPM, 90);
		player2 = new Player(world);
		
		//GameLogic
		input = new InputHandler();
		
		//cam
		yAxisCamera = player1.Box2DBody.getPosition().y;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void update(float deltaTime) {
		InputHandler.input(deltaTime, player1, player2, world);
		//inputHandler(deltaTime);
		world.step(1/60f, 6, 2);
		
		player1.update(deltaTime);
		player2.update(deltaTime);
		
		//Kamera følger bakerste spiller
		if (player1.Box2DBody.getPosition().x < player2.Box2DBody.getPosition().x) {
			gamecam.position.x = player1.Box2DBody.getPosition().x;
		}
		else {
			gamecam.position.x = player2.Box2DBody.getPosition().x;
		}
		
		
		//Kamera beveger seg opp i inkrementer på 200 pixler
		if (player1.Box2DBody.getPosition().y < yAxisCamera - (200 / PlatformGame.PPM)) {
			yAxisCamera -= (200 / PlatformGame.PPM);
			gamecam.position.y = yAxisCamera;
		}
		if (player1.Box2DBody.getPosition().y > yAxisCamera + (200 / PlatformGame.PPM)) {
			yAxisCamera += (200 / PlatformGame.PPM);
			gamecam.position.y = yAxisCamera;
		}
		
		gamecam.update();
		renderer.setView(gamecam);
	}
	
	/*
	public void inputHandler(float deltaTime) {
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
			player.Box2DBody.applyLinearImpulse(new Vector2(0,5f), player.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D) && player.Box2DBody.getLinearVelocity().x <= 2) {
			player.Box2DBody.applyLinearImpulse(new Vector2(0.1f, 0), player.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A) && player.Box2DBody.getLinearVelocity().x >= -2) {
			player.Box2DBody.applyLinearImpulse(new Vector2(-0.1f, 0), player.Box2DBody.getWorldCenter(), true);
		}
		
		//Test player 2 controls
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			player2.Box2DBody.applyLinearImpulse(new Vector2(0,5f), player.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player2.Box2DBody.getLinearVelocity().x <= 2) {
			player2.Box2DBody.applyLinearImpulse(new Vector2(0.1f, 0), player.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && player2.Box2DBody.getLinearVelocity().x >= -2) {
			player2.Box2DBody.applyLinearImpulse(new Vector2(-0.1f, 0), player.Box2DBody.getWorldCenter(), true);
		}
		
		//Test reverse gravity
		if(Gdx.input.isKeyJustPressed(Input.Keys.G)) {
			Vector2 vector2 = world.getGravity();
			vector2.y = vector2.y * -1;
			world.setGravity(vector2);
			player.Box2DBody.applyLinearImpulse(new Vector2(-0.01f, 0), player.Box2DBody.getWorldCenter(), true);
			player2.Box2DBody.applyLinearImpulse(new Vector2(-0.01f, 0), player.Box2DBody.getWorldCenter(), true);
			
		}
	
	}

	*/
	
	@Override
	public void render(float delta) {
		update(delta);
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
        renderer.render();
        
        //Bedub, viser linjer rundt Box2D render
        b2dr.render(world, gamecam.combined);
        
        
        //Texture render test for spiller
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        player1.draw(game.batch);
        player2.draw(game.batch);
        game.batch.end();
        
        
        hud.stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		gamePort.update(width,height);
		
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
	public void dispose() {
		map.dispose();
		renderer.dispose();
		world.dispose();
		b2dr.dispose();
		
	}

}
