package Objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import enums.Life;
import gameLogic.GravityHandler;
import SpaceY.PlatformGame;
import scenes.HudM;

/**
 * A simple cube that the player can move
 * 
 * */
public class Coin extends Actor {
	
	public Coin(World world, Vector2 spawn) {
		super(world, new Texture("src/main/resources/assets/ObjectArt/Cube.png"), spawn);
		setPosition(Box2DBody.getPosition().x - getWidth() / 2, Box2DBody.getPosition().y - getHeight() / 2);
		Box2DBody.setUserData(this);
	}
	
	@Override
    public void actorAttributes(Vector2 spawn) {
		
		BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(spawn);
        bodyDef.type = BodyDef.BodyType.StaticBody;
        Box2DBody = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(16 / PlatformGame.PPM, 6 / PlatformGame.PPM);
        fixtureDef.shape = poly;
        fixtureDef.isSensor = true;
        fixture = Box2DBody.createFixture(fixtureDef);
    }
    
    @Override
    public void update(float deltaTime, GravityHandler gravity, ArrayList<Actor> mapObjects) {

    }
    
	public void activated() {
		setAlpha(0);
		Box2DBody.setUserData(null);
	}
	
}
