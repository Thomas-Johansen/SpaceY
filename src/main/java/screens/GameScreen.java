package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

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
	
	public GameScreen(PlatformGame game) {
		this.game = game;
		//texture = new Texture("src/main/resources/assets/Doggo.jpg");
		gamecam = new OrthographicCamera();
		gamePort = new FitViewport(PlatformGame.V_Width, PlatformGame.V_Height, gamecam);
		hud = new Hud(game.batch);
		
		maploader = new TmxMapLoader();
		map = maploader.load("src/main/resources/assets/mapTest.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void update(float deltaTime) {
		inputHandler(deltaTime);
		gamecam.update();
		renderer.setView(gamecam);
	}
	
	public void inputHandler(float deltaTime) {
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
	}

	@Override
	public void render(float delta) {
		update(delta);
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
        renderer.render();
        
        //game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
        
        /*
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        game.batch.draw(texture, 0, 0);
        game.batch.end();
        */
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
