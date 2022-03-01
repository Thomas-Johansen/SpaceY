package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import inf112.skeleton.app.PlatformGame;

public class Actor extends Sprite {
	public World world;
	public Body Box2DBody;
	private Texture texture;
	private TextureRegion TextureRegion;
	
	public Actor(World world, Texture texture) {
		this.world = world;
		actorAttributes();
		TextureRegion = new TextureRegion(texture, 0, 0, 14, 20);
		setBounds(0, 0, 14 / PlatformGame.PPM, 20 / PlatformGame.PPM);
		setRegion(texture);
	}
	
	public void update(float deltaTime) {
		//Posisjon til texture er nedre venster hjørne av Box2d objektet
		setPosition(Box2DBody.getPosition().x - getWidth() / 2, Box2DBody.getPosition().y - getHeight() / 2 );
	}
	
	public void actorAttributes() {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(100 / PlatformGame.PPM,100 / PlatformGame.PPM);  
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		Box2DBody = world.createBody(bodyDef);
		
		FixtureDef fixture = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(7 / PlatformGame.PPM);
		fixture.shape = shape;
		Box2DBody.createFixture(fixture);
	}
	 
}
