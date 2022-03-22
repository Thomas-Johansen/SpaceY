package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;

import inf112.skeleton.app.PlatformGame;

public class MainMenuScreen implements Screen {
	
	private static final int EXIT_WIDTH = 200;
	private static final int EXIT_HEIGHT = 75;
	private static final int PLAY_WIDTH = 185;
	private static final int PLAY_HEIGHT = 75;
	private static final int PLAY_Y = 150;
	private static final int EXIT_Y = 75;
	
	PlatformGame game;
	
	Texture playActive;
	Texture playInactive;
	Texture exitActive;
	Texture exitInactive;
	Texture background;
	
	Music menuMusic; 
	
	public MainMenuScreen (PlatformGame game) {
		this.game = game;
		playActive = new Texture("src/main/resources/assets/play_button_active.png");
		playInactive = new Texture("src/main/resources/assets/play_button_inactive.png");
		exitActive = new Texture("src/main/resources/assets/exit_button_active.png");
		exitInactive = new Texture("src/main/resources/assets/exit_button_inactive.png");
		background = new Texture("src/main/resources/assets/space_background.png");
		
		//Music Test
		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("src/main/resources/assets/Space.mp3"));
		//menuMusic.setLooping(true);
		menuMusic.play();
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        
        game.batch.begin();
        
        //Draw background
        game.batch.draw(background, 0,0, PlatformGame.V_Width, PlatformGame.V_Height);
        
        int x = PlatformGame.V_Width / 2 - PLAY_WIDTH /2;
        
        //Hover effect for Play button
        if (Gdx.input.getX() < x + PLAY_WIDTH && Gdx.input.getX() > x && PlatformGame.V_Height - Gdx.input.getY() < PLAY_Y + PLAY_HEIGHT && PlatformGame.V_Height - Gdx.input.getY() > PLAY_Y) {
        	game.batch.draw(playActive, x, PLAY_Y, PLAY_WIDTH, PLAY_HEIGHT);
        	//Play game when clicking button
        	if (Gdx.input.isTouched()) {
        		this.dispose();
        		game.setScreen(new GameScreen(game));
        	}
        } else {
        	game.batch.draw(playInactive, x, PLAY_Y, PLAY_WIDTH, PLAY_HEIGHT);
        }
        
        x = PlatformGame.V_Width / 2 - EXIT_WIDTH /2;
        
        //Hover effect for Exit button
        if (Gdx.input.getX() < x + EXIT_WIDTH && Gdx.input.getX() > x && PlatformGame.V_Height - Gdx.input.getY() < EXIT_Y + EXIT_HEIGHT && PlatformGame.V_Height - Gdx.input.getY() > EXIT_Y) {
        	game.batch.draw(exitActive, x, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT);
        	//Exit game when clicking button
        	if (Gdx.input.isTouched()) {
        		Gdx.app.exit();
        	}
        } else {
        	game.batch.draw(exitInactive, x, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT);
        }
        
        
        game.batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
