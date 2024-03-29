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

import SpaceY.PlatformGame;
import enums.Gravity;
import gameLogic.GravityHandler;

public class Hud {
	//Hud skal "stå stille" på skjermen sammenlignet med resten av spillet, så trenger egen viewport
	public Stage stage;
	private Viewport viewport;
	private String player;
	private String world;
	private String console;
	
	Label playerGravityLabel;
	Label worldGravityLabel;
	Label playerGravity;
	Label worldGravity;
	Label gameConsole;
	
	public Hud(SpriteBatch sprite) {
		player = "Down";
		world = "Down";
		console = "";
		
		viewport = new FitViewport(PlatformGame.V_Width, PlatformGame.V_Height, new OrthographicCamera());
		stage = new Stage(viewport, sprite);
		
		Table table = new Table();
		table.top();
		table.setFillParent(true);
		//Gir table elementene font og farge
		LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
		playerGravityLabel = new Label("Player", font);
		worldGravityLabel = new Label("World", font);
		playerGravity = new Label(player, font);
		worldGravity = new Label(world, font);
		gameConsole = new Label(console,font);
		
		//Orienterer hud elementer
		table.add(playerGravityLabel).expandX().padTop(10);
		table.add(worldGravityLabel).expandX().padTop(10);
		table.row();
		table.add(playerGravity).expandX();
		table.add(worldGravity).expandX();

		//Console for å sende tekst til spilleren ingame
		Table consoleTable = new Table();
		consoleTable.setFillParent(true);
		consoleTable.center();
		consoleTable.add(gameConsole).padBottom(150);
		
		stage.addActor(table);
		stage.addActor(consoleTable);
	}
	
	public void update(GravityHandler gravity, String message) {
		playerGravity.setText(Gravity.convertGravity(gravity.playerGravity));
		if (gravity.playerToggle) {
			playerGravity.setColor(Color.YELLOW);
			playerGravityLabel.setColor(Color.YELLOW);
		} else {
			playerGravity.setColor(Color.WHITE);
			playerGravityLabel.setColor(Color.WHITE);
		}
		worldGravity.setText(Gravity.convertGravity(gravity.worldGravity));
		gameConsole.setText(message);
	}
}
