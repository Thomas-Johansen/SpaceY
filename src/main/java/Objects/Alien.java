package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import SpaceY.PlatformGame;
import gameLogic.GravityHandler;

public class Alien extends Enemy {

    public Alien(World world, Vector2 spawn) {
        super(world,new Texture("src/main/resources/assets/ObjectArt/Alien.png"),spawn);
        Box2DBody.setUserData(this);
    }

    @Override
    public void actorAttributes(Vector2 spawn) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(spawn);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Box2DBody = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(10 / PlatformGame.PPM, 12 / PlatformGame.PPM);
        fixtureDef.shape = poly;
        Box2DBody.createFixture(fixtureDef);
    }
    
    @Override
    public void update(float deltaTime, GravityHandler gravity) {
    	//Texture & Box2D Object position og rotation varierer basert på gravitasjons-retningen
    			switch (gravity.worldGravity) {
    			case DOWN:
    				setRotation(0);
    				setPosition(Box2DBody.getPosition().x - getWidth() / 2, Box2DBody.getPosition().y - getHeight() / 2 );
    				Box2DBody.setTransform(Box2DBody.getPosition(), 0);
    				break;
    			case UP:
    				setRotation(180);
    				setPosition(Box2DBody.getPosition().x + getWidth() / 2, Box2DBody.getPosition().y + getHeight() / 2);
    				Box2DBody.setTransform(Box2DBody.getPosition(), (float) PI);
    				break;
    			case LEFT:
    				setRotation(270);
    				setPosition(Box2DBody.getPosition().x - getWidth() / 2, Box2DBody.getPosition().y + getHeight() / 2 );
    				Box2DBody.setTransform(Box2DBody.getPosition(), (float) ((3*PI)/2));
    				break;
    			case RIGHT:
    				setRotation(90);
    				setPosition(Box2DBody.getPosition().x + getWidth() / 2, Box2DBody.getPosition().y - getHeight() / 2 );
    				Box2DBody.setTransform(Box2DBody.getPosition(), (float) (PI/2));
    				break;
    			}	
    }
}
