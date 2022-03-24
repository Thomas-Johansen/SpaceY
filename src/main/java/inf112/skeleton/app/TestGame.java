package inf112.skeleton.app;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.GameScreen;


/*
 * TestGame is a special case of PlatformGame that forgoes the main menu for testing purposes.
 * 
 * 
 * */
public class TestGame extends PlatformGame {
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
