package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class HelloWorld implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    private TiledMap map;
    private TiledMapTileLayer background;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    
    ShapeRenderer shapeRenderer;
    
    float speed = 125.0f;
    float circleX = 110;
    float circleY = 75;
    
    @Override
    public void create() {
    	
    	shapeRenderer = new ShapeRenderer();
    	
        batch = new SpriteBatch();
        /*
        font = new BitmapFont();
        font.setColor(Color.RED);
        */
        map = new TmxMapLoader().load("src/main/resources/assets/map1.tmx");
        background = (TiledMapTileLayer) map.getLayers().get("Rutelag 1");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 2000, 1000);
        camera.update();
        renderer = new OrthogonalTiledMapRenderer(map, (float) 0.3);
        renderer.setView(camera);
    }

    @Override
    public void dispose() {
        batch.dispose();
        //font.dispose();
        shapeRenderer.dispose();
    }

    @Override
    public void render() {

        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            circleY+= Gdx.graphics.getDeltaTime()*speed;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            circleY-= Gdx.graphics.getDeltaTime()*speed;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            circleX-= Gdx.graphics.getDeltaTime()*speed;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            circleX+= Gdx.graphics.getDeltaTime()*speed;
        }
    	
    	Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        
        renderer.render();
        
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1, 0, 0, 1);
        shapeRenderer.circle(circleX, circleY, 50);
        shapeRenderer.end();

        
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
