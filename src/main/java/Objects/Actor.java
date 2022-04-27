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

import SpaceY.PlatformGame;
import enums.Gravity;
import gameLogic.GravityHandler;
import gameLogic.InputHandler;

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
	
	public abstract void update(float deltaTime, GravityHandler gravity) ;

}
