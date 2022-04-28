package gameLogic;

import java.util.ArrayList;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import Objects.Actor;
import Objects.Alien;
import Objects.Cube;
import Objects.GravityPad;
import Objects.Player;
import Objects.PressurePlate;
import Objects.Text;
import SpaceY.PlatformGame;

public class Box2DCreator {
	public ArrayList<Actor> mapObjects;
	public ArrayList<Text> textObjects;
	public Player player1;
	public Player player2;
	public Box2DCreator(World world, TiledMap map) {
		//Generer elementer basert på tmx map filen
		
				BodyDef bodyDef = new BodyDef();
				PolygonShape shape = new PolygonShape();
				FixtureDef fixture = new FixtureDef();
				Body body;
				mapObjects = new ArrayList<>();
				textObjects = new ArrayList<>();
				
				
				//Static Ground
				for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
					Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
					
					bodyDef.type = BodyDef.BodyType.StaticBody;
					bodyDef.position.set((rectangle.getX() + rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getY() + rectangle.getHeight() / 2) / PlatformGame.PPM);
					
					body = world.createBody(bodyDef);
					
					shape.setAsBox((rectangle.getWidth() / 2) / PlatformGame.PPM, (rectangle.getHeight() / 2) / PlatformGame.PPM);
					fixture.shape = shape;
					body.createFixture(fixture);
				}
				
				//Object Layer
				for (RectangleMapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {

					Vector2 spawn = new Vector2();
					switch ((String)object.getProperties().get("Name")) {
					case "Player": 
						spawn.x = object.getRectangle().getX() / PlatformGame.PPM;
						spawn.y = object.getRectangle().getY() / PlatformGame.PPM;
						player1 = (new Player(world, spawn, 1));
						break;
					case "Player2": 
						spawn.x = object.getRectangle().getX() / PlatformGame.PPM;
						spawn.y = object.getRectangle().getY() / PlatformGame.PPM;
						player2 = (new Player(world, spawn, 2));
						break;
					case "Cube": 
						spawn.x = object.getRectangle().getX() / PlatformGame.PPM;
						spawn.y = object.getRectangle().getY() / PlatformGame.PPM;
						mapObjects.add(new Cube(world, spawn));
						break;
					case "Alien": 
						spawn.x = object.getRectangle().getX() / PlatformGame.PPM;
						spawn.y = object.getRectangle().getY() / PlatformGame.PPM;
						mapObjects.add(new Alien(world, spawn));
						break;
					case "Text":
						spawn.x = object.getRectangle().getX() / PlatformGame.PPM;
						spawn.y = object.getRectangle().getY() / PlatformGame.PPM;
						textObjects.add(new Text(world, ((RectangleMapObject) object).getRectangle(), (String)object.getProperties().get("Text")));
						break;
					case "Gravity": 
						spawn.x = object.getRectangle().getX() / PlatformGame.PPM;
						spawn.y = object.getRectangle().getY() / PlatformGame.PPM;
						mapObjects.add(new GravityPad(world, spawn, (String)object.getProperties().get("Gravity")));
						break;
					case "Pad": 
						spawn.x = object.getRectangle().getX() / PlatformGame.PPM;
						spawn.y = object.getRectangle().getY() / PlatformGame.PPM;
						mapObjects.add(new PressurePlate(world, spawn, (int) object.getProperties().get("ID")));
					default: 
						break;
					}
				}
				
				
				
	}
}
