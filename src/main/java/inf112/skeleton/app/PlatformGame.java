package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.GameScreen;


public class PlatformGame extends Game {
	//Sprite batches er memory intensive, så lager en felles
	public SpriteBatch batch;

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
