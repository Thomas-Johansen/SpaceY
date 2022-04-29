package Objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

import SpaceY.PlatformGame;
import gameLogic.GravityHandler;

public abstract class Actor extends Sprite {
	final double PI = 3.1415;
	public World world;
	public Body Box2DBody;
	public Texture texture;
	protected Fixture fixture;
	
	public Actor(World world, Texture texture, Vector2 spawn) {
		this.world = world;
		this.texture = texture;
		actorAttributes(spawn);
		setBounds(0, 0, 32 / PlatformGame.PPM, 32 / PlatformGame.PPM);
		setRegion(texture);
	}
	
	public abstract void actorAttributes(Vector2 spawn) ;
	
	public abstract void update(float deltaTime, GravityHandler gravity, ArrayList<Actor> mapObjects) ;
	
	
	public void checkMaxSpeed() {
		int max = 5;
				if(Box2DBody.getLinearVelocity().x > max) Box2DBody.setLinearVelocity(max, Box2DBody.getLinearVelocity().y);
				if(Box2DBody.getLinearVelocity().x < -max)Box2DBody.setLinearVelocity(-max, Box2DBody.getLinearVelocity().y);
				if(Box2DBody.getLinearVelocity().y > max) Box2DBody.setLinearVelocity(Box2DBody.getLinearVelocity().x, max);
				if(Box2DBody.getLinearVelocity().y < -max) Box2DBody.setLinearVelocity(Box2DBody.getLinearVelocity().x, -max);
	}

}
