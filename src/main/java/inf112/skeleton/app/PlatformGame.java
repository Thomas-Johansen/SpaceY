package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.GameScreen;
import screens.MainMenuScreen;
import screens.MenuScreen;
import screens.TestScreen;


public class PlatformGame extends Game {
	//Sprite batches er memory intensive, så lager en felles
	public SpriteBatch batch;
	
	//Definerer høyde og bredde for spillvindu.
	public static final int V_Width = 500;
	public static final int V_Height = 308;
	/*Definerer pixels per "meter" for Box2D scaling. ¨
	 * Å redusere detta tallet fører til at avstadner blir større, og objecter bever seg saktere
	 * Økning gir omvendt effekt.
	 * */
	public static final float PPM = 100;
	
	

	@Override
	public void create() {
		batch = new SpriteBatch();
		setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void render () {
		super.render();
	}

}
