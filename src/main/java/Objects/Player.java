package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import inf112.skeleton.app.PlatformGame;

public class Player extends Actor {
	enum Life {
		ALIVE,
		DEAD
	}
	public Life life;

	public Player(World world, Vector2 spawn) {
		super(world, new Texture("src/main/resources/assets/mairo.png"), spawn);
		this.life = Life.ALIVE;
	}

	public Boolean isAlive() {
		if (life == Life.ALIVE) {
			return true;
		}
		return false;
	}
}
