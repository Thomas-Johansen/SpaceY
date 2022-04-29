package Objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import SpaceY.PlatformGame;
import gameLogic.GravityHandler;

public class Alien extends Enemy {
	public Vector2 velocity;
	public Vector2 velocity2;
	protected Fixture fixture;
	
	
    public Alien(World world, Vector2 spawn) {
        super(world,new Texture("src/main/resources/assets/ObjectArt/Alien.png"),spawn);
        Box2DBody.setUserData(this);
        alive = true;
		velocity = new Vector2((float) 0.3,0);
		velocity2 = new Vector2( 0, (float) 0.3);

    }

    @Override
    public void actorAttributes(Vector2 spawn) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(spawn);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Box2DBody = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(10 / PlatformGame.PPM, 11 / PlatformGame.PPM);
        fixtureDef.shape = poly;
        fixture =  Box2DBody.createFixture(fixtureDef);
        
      //Sensor for head collision detection
        
      		EdgeShape head = new EdgeShape();
      		head.set(new Vector2(-8 / PlatformGame.PPM, 14 / PlatformGame.PPM), new Vector2(8 / PlatformGame.PPM, 14 / PlatformGame.PPM));
      		fixtureDef.shape = head;
      		fixtureDef.isSensor = true;
      		Box2DBody.createFixture(fixtureDef).setUserData("alienHead");
    }
    
    @Override
    public void update(float deltaTime, GravityHandler gravity, ArrayList<Actor> mapObjects) {
    	//Texture & Box2D Object position og rotation varierer basert på gravitasjons-retningen
    			switch (gravity.worldGravity) {
    			case DOWN:
    				setRotation(0);
    				setPosition(Box2DBody.getPosition().x - getWidth() / 2, Box2DBody.getPosition().y - getHeight() / 2 );
    				Box2DBody.setTransform(Box2DBody.getPosition(), 0);
					if (!gravity.isMovingMax(this)) Box2DBody.applyLinearImpulse(velocity,Box2DBody.getWorldCenter(),true);
    				break;
    			case UP:
    				setRotation(180);
    				setPosition(Box2DBody.getPosition().x + getWidth() / 2, Box2DBody.getPosition().y + getHeight() / 2);
    				Box2DBody.setTransform(Box2DBody.getPosition(), (float) PI);
					if (!gravity.isMovingMax(this)) Box2DBody.applyLinearImpulse(velocity,Box2DBody.getWorldCenter(),true);
    				break;
    			case LEFT:
    				setRotation(270);
    				setPosition(Box2DBody.getPosition().x - getWidth() / 2, Box2DBody.getPosition().y + getHeight() / 2 );
    				Box2DBody.setTransform(Box2DBody.getPosition(), (float) ((3*PI)/2));
					if (!gravity.isMovingMax(this)) Box2DBody.applyLinearImpulse(velocity2,Box2DBody.getWorldCenter(),true);
    				break;
    			case RIGHT:
    				setRotation(90);
    				setPosition(Box2DBody.getPosition().x + getWidth() / 2, Box2DBody.getPosition().y - getHeight() / 2 );
    				Box2DBody.setTransform(Box2DBody.getPosition(), (float) (PI/2));
					if (!gravity.isMovingMax(this)) Box2DBody.applyLinearImpulse(velocity2,Box2DBody.getWorldCenter(),true);
    				break;
    			}
    }
    
    public void onHeadHit() {
    	Box2DBody.setUserData(null);
    	fixture.setSensor(true);
    	alive = false;	
    }
}
