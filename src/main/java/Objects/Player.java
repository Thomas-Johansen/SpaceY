package Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import enums.Gravity;
import enums.Life;
import enums.PadSensor;
import gameLogic.GravityHandler;
import inf112.skeleton.app.PlatformGame;

public class Player extends Actor {
	
	public Life life;
	//public PadSensor sensor;
	protected Fixture fixture;

	public Player(World world, Vector2 spawn) {
		super(world, new Texture("src/main/resources/assets/ObjectArt/Elon.png"), spawn);
		this.life = Life.ALIVE;
		//this.sensor = PadSensor.notActive;
		Box2DBody.setUserData(this);
	}
	
	
	@Override
	public void actorAttributes(Vector2 spawn) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(spawn);  
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		Box2DBody = world.createBody(bodyDef);

		
		FixtureDef fixtureDef = new FixtureDef();
		PolygonShape poly = new PolygonShape();
		poly.setAsBox(6 / PlatformGame.PPM, 16 / PlatformGame.PPM);		
		fixtureDef.shape = poly;
		fixture = Box2DBody.createFixture(fixtureDef);
		
		
		//Sensor for head collision detection
		EdgeShape head = new EdgeShape();
		head.set(new Vector2(-2 / PlatformGame.PPM, 18 / PlatformGame.PPM), new Vector2(2 / PlatformGame.PPM, 18 / PlatformGame.PPM));
		fixtureDef.shape = head;
		fixtureDef.isSensor = true;
		Box2DBody.createFixture(fixtureDef).setUserData("head");
	}
	@Override
	public void update(float deltaTime, GravityHandler gravity) {
		//Texture & Box2D Object position og rotation varierer basert på gravitasjons-retningen
		Gravity switchGrav;
		if (gravity.playerToggle) switchGrav = gravity.playerGravity; else switchGrav = gravity.worldGravity;
		switch (switchGrav) {
		case DOWN:
			setRotation(0);
			setPosition(Box2DBody.getPosition().x - getWidth() / 2, Box2DBody.getPosition().y - getHeight() / 2 );
			Box2DBody.setTransform(Box2DBody.getPosition(), 0);
			break;
		case UP:
			setRotation(180);
			setPosition(Box2DBody.getPosition().x + getWidth() / 2, Box2DBody.getPosition().y + getHeight() / 2);
			Box2DBody.setTransform(Box2DBody.getPosition(), (float) PI);
			break;
		case LEFT:
			setRotation(270);
			setPosition(Box2DBody.getPosition().x - getWidth() / 2, Box2DBody.getPosition().y + getHeight() / 3 );
			Box2DBody.setTransform(Box2DBody.getPosition(), (float) ((3*PI)/2));
			break;
		case RIGHT:
			setRotation(90);
			setPosition(Box2DBody.getPosition().x + getWidth() / 2, Box2DBody.getPosition().y - getHeight() / 3 );
			Box2DBody.setTransform(Box2DBody.getPosition(), (float) (PI/2));
			break;
		}	
	}

	public boolean isAlive() {
		if (life == Life.ALIVE) {
			return true;
		}
		return false;
	}
	public void onHeadHit() {
		life = Life.DEAD;
	}
	
}
