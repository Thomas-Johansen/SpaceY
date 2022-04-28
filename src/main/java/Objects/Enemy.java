package Objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import gameLogic.GravityHandler;

public class Enemy extends Actor {

	/**
	 * This class mainly serves as a middle point for spesific enemies and actors.
	 * Allowing the ContactListener to check if a fixture is an enemy instead of checking for each spesific type of enemy
	 */
	public Enemy(World world, Texture texture, Vector2 spawn) {
		super(world, texture, spawn);
	}

	@Override
	public void actorAttributes(Vector2 spawn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float deltaTime, GravityHandler gravity, ArrayList<Actor> mapObjects) {
		// TODO Auto-generated method stub

	}
}
