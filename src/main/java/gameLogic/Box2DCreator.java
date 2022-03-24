package gameLogic;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import inf112.skeleton.app.PlatformGame;

public class Box2DCreator {
	
	public Box2DCreator(World world, TiledMap map) {
		//Generer elementer basert på tmx map filen
		//For øyeblikket genereres kun statisce "vegg" objecter
		// Er meningen at autoplassering av ting som items og enemies skal legges til her senere.
				BodyDef bodyDef = new BodyDef();
				PolygonShape shape = new PolygonShape();
				FixtureDef fixture = new FixtureDef();
				Body body;
				
				for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
					Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
					
					bodyDef.type = BodyDef.BodyType.StaticBody;
					bodyDef.position.set((rectangle.getX() + rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / PlatformGame.PPM);
					
					body = world.createBody(bodyDef);
					
					shape.setAsBox((rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getHeight() / 2) / PlatformGame.PPM);
					fixture.shape = shape;
					body.createFixture(fixture);
				}
				
				for (MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
					Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
					
					bodyDef.type = BodyDef.BodyType.StaticBody;
					bodyDef.position.set((rectangle.getX() + rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / PlatformGame.PPM);
					
					body = world.createBody(bodyDef);
					
					shape.setAsBox((rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getHeight() / 2) / PlatformGame.PPM);
					fixture.shape = shape;
					body.createFixture(fixture);
				}
				
				for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
					Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
					
					bodyDef.type = BodyDef.BodyType.StaticBody;
					bodyDef.position.set((rectangle.getX() + rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / PlatformGame.PPM);
					
					body = world.createBody(bodyDef);
					
					shape.setAsBox((rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getHeight() / 2) / PlatformGame.PPM);
					fixture.shape = shape;
					body.createFixture(fixture);
				}
	}
}
