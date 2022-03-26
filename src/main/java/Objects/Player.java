package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import enums.Life;
import inf112.skeleton.app.PlatformGame;

public class Player extends Actor {
	public Life life;

	public Player(World world, Vector2 spawn) {
		super(world, new Texture("src/main/resources/assets/mairo.png"), spawn);
		this.life = Life.ALIVE;
	}
	//Overriding actor attributes since i only, for now, want the player to have a "head"
	@Override
	public void actorAttributes(Vector2 spawn) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(spawn);  
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		Box2DBody = world.createBody(bodyDef);
		
		FixtureDef fixtureDef = new FixtureDef();
		PolygonShape poly = new PolygonShape();
		poly.setAsBox(6 / PlatformGame.PPM, 6 / PlatformGame.PPM);
		fixtureDef.shape = poly;
		Box2DBody.createFixture(fixtureDef);
		
		//Sensor for head collision detection
		EdgeShape head = new EdgeShape();
		head.set(new Vector2(-2 / PlatformGame.PPM, 7 / PlatformGame.PPM), new Vector2(2 / PlatformGame.PPM, 7 / PlatformGame.PPM));
		fixtureDef.shape = head;
		Box2DBody.createFixture(fixtureDef).setUserData("head");
	}

	public Boolean isAlive() {
		if (life == Life.ALIVE) {
			return true;
		}
		return false;
	}
	public void onHeadHit() {
		life = Life.DEAD;
	}
	
	
}
