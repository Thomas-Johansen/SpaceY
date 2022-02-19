package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.GameScreen;


public class PlatformGame extends Game {
	//Sprite batches er memory intensive, så lager en felles
	public SpriteBatch batch;
	
	//Definerer høyde og bredde for spillvindu.
	public static final int V_Width = 500;
	public static final int V_Height = 408;
	
	

	@Override
	public void create() {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}
	
	@Override
	public void render () {
		super.render();
	}

}
