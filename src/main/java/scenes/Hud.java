package scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import inf112.skeleton.app.PlatformGame;

public class Hud {
	//Hud skal "stå stille" på skjermen sammenlignet med resten av spillet, så trenger egen viewport
	public Stage stage;
	private Viewport viewport;
	
	/*
	 * Tester hud elementer som gir mening for type super mario, der man har en score, og begrenset tid på å nå mål.
	 * Endrer til mer spesifikt for vårt spill når vi vet hva vi vil ha og ikke ha.
	 */
	private Integer worldTimer;
	private float timeCount;
	private Integer score;
	
	Label countdownLabel;
	Label scoreLabel;
	Label timeLabel;
	Label scoreNameLabel;
	
	public Hud(SpriteBatch sprite) {
		worldTimer = 100;
		timeCount = 0;
		score = 0;
		
		viewport = new FitViewport(PlatformGame.V_Width, PlatformGame.V_Height, new OrthographicCamera());
		stage = new Stage(viewport, sprite);
		
		Table table = new Table();
		table.top();
		table.setFillParent(true);
		
		LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
		countdownLabel = new Label(String.format("%03d", worldTimer), font);
		scoreLabel = new Label(String.format("%06d", score), font);
		timeLabel = new Label("TIME", font);
		scoreNameLabel = new Label("Score", font);
		
		table.add(scoreNameLabel).expandX().padTop(10);
		table.add(timeLabel).expandX().padTop(10);
		table.row();
		table.add(scoreLabel).expandX();
		table.add(countdownLabel).expandX();
		
		stage.addActor(table);
	}
}
