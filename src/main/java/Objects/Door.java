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

public class Door extends Actor {
	private int ID;

	public Door(World world, Vector2 spawn, int ID) {
		super(world, new Texture("src/main/resources/assets/ObjectArt/Door.png"), spawn);
		this.ID = ID;

	}

	@Override
	public void actorAttributes(Vector2 spawn) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(spawn);  
		bodyDef.type = BodyDef.BodyType.StaticBody;
		Box2DBody = world.createBody(bodyDef);

		
		FixtureDef fixtureDef = new FixtureDef();
		PolygonShape poly = new PolygonShape();
		poly.setAsBox(16/ PlatformGame.PPM, 8 / PlatformGame.PPM);
		fixtureDef.shape = poly;
		fixtureDef.isSensor = true;
		fixture = Box2DBody.createFixture(fixtureDef);
		
		
	}

	@Override
	public void update(float deltaTime, GravityHandler gravity, ArrayList<Actor> mapObjects) {
		boolean buttonPressed = true;
		for (Actor o : mapObjects) {
			if (o instanceof PressurePlate && ((PressurePlate) o).padID == ID) {
				PressurePlate i = (PressurePlate) o;
				if (!i.isActive) buttonPressed = false;
			}
		}
		if (buttonPressed == true) {
			System.out.println("Door opened");
		}
		
		
	}

}
