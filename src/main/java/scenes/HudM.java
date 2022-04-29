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

import Objects.Player;
import SpaceY.PlatformGame;

public class HudM {
	//Hud skal "stå stille" på skjermen sammenlignet med resten av spillet, så trenger egen viewport
	public Stage stage;
	private Viewport viewport;
	private int player1;
	private int player2;
	private String console;
	
	Label player1TxtLabel;
	Label player1ScoreLabel;
	Label player2TxtLabel;
	Label player2ScoreLabel;
	Label gameConsole;
	
	public HudM(SpriteBatch sprite) {
		player1 = 0;
		player2 = 0;
		console = "Test text som blir lengre og lengre og lengre";
		
		viewport = new FitViewport(PlatformGame.V_Width, PlatformGame.V_Height, new OrthographicCamera());
		stage = new Stage(viewport, sprite);
		
		Table table = new Table();
		table.top();
		table.setFillParent(true);
		//Gir table elementene font og farge
		LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
		player1TxtLabel = new Label("Player1", font);
		player2TxtLabel = new Label("Player2", font);
		player1ScoreLabel = new Label(String.format("%03d", player1), font);
		player2ScoreLabel = new Label(String.format("%03d", player2), font);
		gameConsole = new Label(console,font);
		
		//Orienterer hud elementer
		table.add(player1TxtLabel).expandX().padTop(10);
		table.add(player2TxtLabel).expandX().padTop(10);
		table.row();
		table.add(player1ScoreLabel).expandX();
		table.add(player2ScoreLabel).expandX();

		//Console for å sende tekst til spilleren ingame
		Table consoleTable = new Table();
		consoleTable.setFillParent(true);
		consoleTable.center();
		consoleTable.add(gameConsole).padBottom(150);
		
		stage.addActor(table);
		stage.addActor(consoleTable);
	}
	
	public void update(Player player1, Player player2, String message) {
		gameConsole.setText(message);
		player1ScoreLabel.setText(player1.points);
		player2ScoreLabel.setText(player2.points);
	}

}
