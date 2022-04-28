package Objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import SpaceY.PlatformGame;
import gameLogic.GravityHandler;

public class Door extends Actor {
	private int ID;

	public Door(World world, Texture texture, Vector2 spawn) {
		super(world, texture, spawn);

	}

	@Override
	public void actorAttributes(Vector2 spawn) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(spawn);  
		bodyDef.type = BodyDef.BodyType.StaticBody;
		Box2DBody = world.createBody(bodyDef);

		
		FixtureDef fixtureDef = new FixtureDef();
		PolygonShape poly = new PolygonShape();
		poly.setAsBox(16/ PlatformGame.PPM, 8 / PlatformGame.PPM);
		fixtureDef.shape = poly;
		fixtureDef.isSensor = true;
		fixture = Box2DBody.createFixture(fixtureDef);
		
		
	}

	@Override
	public void update(float deltaTime, GravityHandler gravity, ArrayList<Actor> mapObjects) {
		
		
	}

}
