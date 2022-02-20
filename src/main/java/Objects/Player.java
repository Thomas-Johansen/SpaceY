package Objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import inf112.skeleton.app.PlatformGame;

public class Player extends Sprite {
	public World world;
	public Body Box2DBody;
	
	public Player(World world) {
		this.world = world;
		playerAttributes();
	}
	
	public void playerAttributes() {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(100 / PlatformGame.PPM,100 / PlatformGame.PPM);  
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		Box2DBody = world.createBody(bodyDef);
		
		FixtureDef fixture = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(10 / PlatformGame.PPM);
		fixture.shape = shape;
		Box2DBody.createFixture(fixture);
	}
	 
}
