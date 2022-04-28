package Objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import SpaceY.PlatformGame;
import enums.Gravity;
import gameLogic.GravityHandler;

public class GravityPad extends Actor {
	public Gravity padDirection;
	public boolean isPressed;
	protected Fixture fixture;
	private World thisWorld;

	public GravityPad(World world, Vector2 spawn, String gravity) {
		super(world, new Texture("src/main/resources/assets/ObjectArt/GravityPad.png"), spawn);
		isPressed = false;
		padDirection = Gravity.convertString(gravity);
		thisWorld = world;
		Box2DBody.setUserData(this);
		
		switch (padDirection) {
		case UP:
			setRotation(0);
			setPosition(Box2DBody.getPosition().x - getWidth() / 4, Box2DBody.getPosition().y - getHeight() / 4);
			break;
		case DOWN:
			setRotation(180);
			setPosition(Box2DBody.getPosition().x, Box2DBody.getPosition().y);
		    setPosition(Box2DBody.getPosition().x + getWidth() / 4, Box2DBody.getPosition().y + getHeight() / 4 );
			break;
		case RIGHT:
			setRotation(270);
			setPosition(Box2DBody.getPosition().x - getWidth() / 4, Box2DBody.getPosition().y + getHeight() / 4 );
			break;
		case LEFT:
			setRotation(90);
			setPosition(Box2DBody.getPosition().x + getWidth() / 4, Box2DBody.getPosition().y - getHeight() / 4 );
			break;
		}	
	}

	@Override
	public void actorAttributes(Vector2 spawn) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(spawn);  
		bodyDef.type = BodyDef.BodyType.StaticBody;
		Box2DBody = world.createBody(bodyDef);

		
		FixtureDef fixtureDef = new FixtureDef();
		PolygonShape poly = new PolygonShape();
		poly.setAsBox(8/ PlatformGame.PPM, 8 / PlatformGame.PPM);
		fixtureDef.shape = poly;
		fixtureDef.isSensor = true;
		fixture = Box2DBody.createFixture(fixtureDef);
		
	}

	@Override
	public void update(float deltaTime, GravityHandler gravity, ArrayList<Actor> mapObjects) {
		if (isPressed) gravity.setWorldGravity(padDirection, thisWorld);
	}

}
