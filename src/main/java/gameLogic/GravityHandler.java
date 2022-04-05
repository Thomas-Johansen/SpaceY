package gameLogic;

import com.badlogic.gdx.math.Vector2;

import Objects.Actor;
import enums.Gravity;

public class GravityHandler {
	public Gravity worldGravity;
	public Gravity playerGravity;
	public boolean playerToggle;
	
	public GravityHandler() {
		worldGravity = Gravity.DOWN;
		playerGravity = worldGravity;
		playerToggle = false;
	}
	
	//Returns the gravity vector for changing box2d world gravity
		public Vector2 getGravityVector(){
			Vector2 vector = new Vector2();
			switch(worldGravity) {
			case DOWN:
				vector = new Vector2(0, (float) -9.81);
				break;
			case UP:
				vector = new Vector2(0, (float) 9.81);
				break;
			case LEFT:
				vector = new Vector2((float) -9.81, 0);
				break;
			case RIGHT:
				vector = new Vector2((float) 9.81, 0);
				break;
			default:
				vector = new Vector2(0, (float) -9.81);
				break;
			}
			return vector;
		}
		//Determines what direction force is applied to the player when pressing WASD depending on which way the gravity is oriented
		public Vector2 getUp() {
			Gravity switchGrav;
			if (playerToggle) switchGrav = playerGravity; else switchGrav = worldGravity;
			
				Vector2 vector = new Vector2();
				switch(switchGrav) {
				case DOWN:
					vector = new Vector2(0,5f);
					break;
				case UP:
					vector = new Vector2(0,-5f);
					break;
				case LEFT:
					vector = new Vector2(5f,0);
					break;
				case RIGHT:
					vector = new Vector2(-5f,0);
					break;
				}
				return vector; 
		}
		public Vector2 getLeft() {
			Gravity switchGrav;
			if (playerToggle) switchGrav = playerGravity; else switchGrav = worldGravity;
			
			Vector2 vector = new Vector2();
			switch(switchGrav) {
			case DOWN:
				vector = new Vector2(-0.1f,0);
				break;
			case UP:
				vector = new Vector2(0.1f,0);
				break;
			case LEFT:
				vector = new Vector2(0,0.1f);
				break;
			case RIGHT:
				vector = new Vector2(0,-0.1f);
				break;
			}
			return vector;
		}
		public Vector2 getRight() {
			Gravity switchGrav;
			if (playerToggle) switchGrav = playerGravity; else switchGrav = worldGravity;
			
			Vector2 vector = new Vector2();
			switch(switchGrav) {
			case DOWN:
				vector = new Vector2(0.1f,0);
				break;
			case UP:
				vector = new Vector2(-0.1f,0);
				break;
			case LEFT:
				vector = new Vector2(0,-0.1f);
				break;
			case RIGHT:
				vector = new Vector2(0,0.1f);
				break;
			}
			return vector;
		}
		
		//isFalling and isMovingMax is used to stop the player from moving/jumping while falling, and to set a max speed left or right
		public Boolean isFalling(Actor actor) {
			Gravity switchGrav;
			if (playerToggle) switchGrav = playerGravity; else switchGrav = worldGravity;
			switch(switchGrav) {
			case DOWN:
			case UP:
				if (actor.Box2DBody.getLinearVelocity().y == 0) {
					return false;
				} 
				break;
			case LEFT:
			case RIGHT:
				if (actor.Box2DBody.getLinearVelocity().x == 0) {
					return false;
				}
				break;
			}
			return true;
		}
		public Boolean isMovingMax(Actor actor) {
			Gravity switchGrav;
			if (playerToggle) switchGrav = playerGravity; else switchGrav = worldGravity;
			switch(switchGrav) {
			case DOWN:
			case UP:
				if (actor.Box2DBody.getLinearVelocity().x > 2 || actor.Box2DBody.getLinearVelocity().x < -2) {
					return true;
				}
			case LEFT:
			case RIGHT:
				if (actor.Box2DBody.getLinearVelocity().y > 2 || actor.Box2DBody.getLinearVelocity().y < -2) {
					return true;
				}	
			}
			return false;
		}
	
}
