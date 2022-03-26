package Objects;

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

import gameLogic.InputHandler;
import inf112.skeleton.app.PlatformGame;

public abstract class Actor extends Sprite {
	final double PI = 3.1415;
	public World world;
	public Body Box2DBody;
	private Texture texture;
	protected Fixture fixture;
	
	public Actor(World world, Texture texture, Vector2 spawn) {
		this.world = world;
		this.texture = texture;
		actorAttributes(spawn);
		setBounds(0, 0, 14 / PlatformGame.PPM, 20 / PlatformGame.PPM);
		setRegion(texture);
	}
	
	public void actorAttributes(Vector2 spawn) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(spawn);  
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		Box2DBody = world.createBody(bodyDef);
		
		FixtureDef fixtureDef = new FixtureDef();
		PolygonShape poly = new PolygonShape();
		poly.setAsBox(6 / PlatformGame.PPM, 6 / PlatformGame.PPM);
		fixtureDef.shape = poly;
		fixture = Box2DBody.createFixture(fixtureDef);
		
		
	}
	
	public void update(float deltaTime) {
		//Texture & Box2D Object position og rotation varierer basert på gravitasjons-retningen
		switch (InputHandler.gravityDirection) {
		case 0:
			setRotation(0);
			setPosition(Box2DBody.getPosition().x - getWidth() / 2, Box2DBody.getPosition().y - getHeight() / 2 );
			Box2DBody.setTransform(Box2DBody.getPosition(), 0);
			break;
		case 1:
			setRotation(180);
			setPosition(Box2DBody.getPosition().x + getWidth() / 2, Box2DBody.getPosition().y + getHeight() / 2);
			Box2DBody.setTransform(Box2DBody.getPosition(), (float) PI);
			break;
		case 2:
			setRotation(270);
			setPosition(Box2DBody.getPosition().x - getWidth() / 2, Box2DBody.getPosition().y + getHeight() / 3 );
			Box2DBody.setTransform(Box2DBody.getPosition(), (float) ((3*PI)/2));
			break;
		case 3:
			setRotation(90);
			setPosition(Box2DBody.getPosition().x + getWidth() / 2, Box2DBody.getPosition().y - getHeight() / 3 );
			Box2DBody.setTransform(Box2DBody.getPosition(), (float) (PI/2));
			break;
		}	
	}
	
	 
}
