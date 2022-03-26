package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * A simple cube that the player can move
 * 
 * */
public class Cube extends Actor {

	public Cube(World world, Vector2 spawn) {
		super(world, new Texture("src/main/resources/assets/ObjectArt/Cube.png"), spawn);
		fixture.setUserData(this);
	}
}
