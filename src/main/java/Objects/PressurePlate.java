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

public class PressurePlate extends Actor{
	public Boolean isActive;
	public int weight;
	public int padID;

	public PressurePlate(World world, Vector2 spawn, int ID) {
		super(world, new Texture("src/main/resources/assets/ObjectArt/Pad.png"), spawn);
		setPosition(Box2DBody.getPosition().x - getWidth() / 2, Box2DBody.getPosition().y - getHeight() / 10);
		isActive = false;
		weight = 0;
		padID = ID;
		Box2DBody.setUserData(this);
	}

	@Override
	public void actorAttributes(Vector2 spawn) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(spawn);  
		bodyDef.type = BodyDef.BodyType.StaticBody;
		Box2DBody = world.createBody(bodyDef);

		
		FixtureDef fixtureDef = new FixtureDef();
		PolygonShape poly = new PolygonShape();
		poly.setAsBox(16/ PlatformGame.PPM, 4 / PlatformGame.PPM);
		fixtureDef.shape = poly;
		fixtureDef.isSensor = true;
		fixture = Box2DBody.createFixture(fixtureDef);
		
	}

	@Override
	public void update(float deltaTime, GravityHandler gravity, ArrayList<Actor> mapObjects) {
		if (weight > 0) {
			isActive = true;
		} else {
			isActive = false;
		}
		
	}

}
