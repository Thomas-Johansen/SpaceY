package Objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import inf112.skeleton.app.PlatformGame;


/**
 * Placable textbox, when a player is inside, the text is displayed, when a player leaves, the text is removed.
 * */
public class Text{
	Rectangle rectangle;
	public String text;
	public boolean isActive;

	public Text(World world, Rectangle rectangle, String text) {
		this.text = text;
		BodyDef bodyDef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fixture = new FixtureDef();
		Body body;
		
		bodyDef.type = BodyDef.BodyType.StaticBody;
		bodyDef.position.set((rectangle.getX() + rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / PlatformGame.PPM);
		
		body = world.createBody(bodyDef);
		
		shape.setAsBox((rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getHeight() / 2) / PlatformGame.PPM);
		fixture.shape = shape;
		fixture.isSensor = true;
		body.createFixture(fixture);
		
		body.setUserData(this);
	}

}
