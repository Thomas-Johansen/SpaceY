package gameLogic;

import com.badlogic.gdx.math.Vector2;

import enums.Gravity;

public class gravityHandler {
	public Gravity worldGravity;
	public Gravity playerGravity;
	
	public gravityHandler() {
		worldGravity = Gravity.DOWN;
		playerGravity = worldGravity;
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
			Vector2 vector = new Vector2();
			switch(playerGravity) {
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
			Vector2 vector = new Vector2();
			switch(playerGravity) {
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
			Vector2 vector = new Vector2();
			switch(playerGravity) {
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
}
