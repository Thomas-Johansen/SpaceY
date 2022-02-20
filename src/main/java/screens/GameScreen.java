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
import inf112.skeleton.app.PlatformGame;
import scenes.Hud;

public class GameScreen implements Screen {
	private PlatformGame game;
	Texture texture;
	private OrthographicCamera gamecam;
	private Viewport gamePort;
	private Hud hud;
	
	private TmxMapLoader maploader;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	
	//Box2d variabler
	private World world;
	private Box2DDebugRenderer b2dr;
	private Player player;
	
	
	
	
	public GameScreen(PlatformGame game) {
		this.game = game;
		//texture = new Texture("src/main/resources/assets/Doggo.jpg");
		gamecam = new OrthographicCamera();
		gamePort = new FitViewport(PlatformGame.V_Width / PlatformGame.PPM, PlatformGame.V_Height / PlatformGame.PPM, gamecam);
		hud = new Hud(game.batch);
		
		maploader = new TmxMapLoader();
		map = maploader.load("src/main/resources/assets/mapTest.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1 / PlatformGame.PPM);
		gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
		
		//Box2D
		world = new World(new Vector2(0, (float) -9.81), true);
		b2dr = new Box2DDebugRenderer();
		player = new Player(world);
		
		
		//Midlertidig plassering, skal inn i egen klasse senere.
		BodyDef bodyDef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fixture = new FixtureDef();
		Body body;
		
		for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
			
			bodyDef.type = BodyDef.BodyType.StaticBody;
			bodyDef.position.set((rectangle.getX() + rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / PlatformGame.PPM);
			
			body = world.createBody(bodyDef);
			
			shape.setAsBox((rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getHeight() / 2) / PlatformGame.PPM);
			fixture.shape = shape;
			body.createFixture(fixture);
		}
		
		for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
			
			bodyDef.type = BodyDef.BodyType.StaticBody;
			bodyDef.position.set((rectangle.getX() + rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / PlatformGame.PPM);
			
			body = world.createBody(bodyDef);
			
			shape.setAsBox((rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getHeight() / 2) / PlatformGame.PPM);
			fixture.shape = shape;
			body.createFixture(fixture);
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void update(float deltaTime) {
		inputHandler(deltaTime);
		world.step(1/60f, 6, 2);
		gamecam.update();
		renderer.setView(gamecam);
	}
	
	public void inputHandler(float deltaTime) {
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
			player.Box2DBody.applyLinearImpulse(new Vector2(0,5f), player.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.D)) {
			player.Box2DBody.setLinearVelocity(new Vector2(2f,0));
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.A)) {
			player.Box2DBody.setLinearVelocity(new Vector2(-2f,0));
		}
		
		/*
		if (Gdx.input.isKeyPressed(32)) {
			gamecam.position.x += 100 * deltaTime;
		}
		if (Gdx.input.isKeyPressed(29)) {
			gamecam.position.x += -100 * deltaTime;
		}
		if (Gdx.input.isKeyPressed(51)) {
			gamecam.position.y += 100 * deltaTime;
		}
		if (Gdx.input.isKeyPressed(47)) {
			gamecam.position.y += -100 * deltaTime;
		}
		*/
	}

	@Override
	public void render(float delta) {
		update(delta);
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
        renderer.render();
        
        //Bedub, viser linjer rundt Box2D render
        b2dr.render(world, gamecam.combined);
        
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
		// TODO Auto-generated method stub
		
	}

}
