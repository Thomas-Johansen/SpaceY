package gameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import Objects.Actor;
import Objects.Player;

public class InputHandler {
	//Gravity handling shall be moved in it's own class in time, since non input reliant actors depend on it as well
	public static int gravityDirection = 0;
	
	//Returns the gravity vector for changing box2d world gravity
	public static Vector2 getGravityVector(){
		Vector2 vector = new Vector2();
		switch(gravityDirection) {
		case 0:
			vector = new Vector2(0, (float) -9.81);
			break;
		case 1:
			vector = new Vector2(0, (float) 9.81);
			break;
		case 2:
			vector = new Vector2((float) -9.81, 0);
			break;
		case 3:
			vector = new Vector2((float) 9.81, 0);
			break;
		default:
			vector = new Vector2(0, (float) -9.81);
			break;
		}
		return vector;
	}
	//Determines what direction force is applied to the player when pressing WASD depending on which way the gravity is oriented
	public static Vector2 getUp() {
		Vector2 vector = new Vector2();
		switch(gravityDirection) {
		case 0:
			vector = new Vector2(0,5f);
			break;
		case 1:
			vector = new Vector2(0,-5f);
			break;
		case 2:
			vector = new Vector2(5f,0);
			break;
		case 3:
			vector = new Vector2(-5f,0);
			break;
		}
		return vector;
	}
	public static Vector2 getLeft() {
		Vector2 vector = new Vector2();
		switch(gravityDirection) {
		case 0:
			vector = new Vector2(-0.1f,0);
			break;
		case 1:
			vector = new Vector2(-0.1f,0);
			break;
		case 2:
			vector = new Vector2(0,0.1f);
			break;
		case 3:
			vector = new Vector2(0,-0.1f);
			break;
		}
		return vector;
	}
	public static Vector2 getRight() {
		Vector2 vector = new Vector2();
		switch(gravityDirection) {
		case 0:
			vector = new Vector2(0.1f,0);
			break;
		case 1:
			vector = new Vector2(0.1f,0);
			break;
		case 2:
			vector = new Vector2(0,-0.1f);
			break;
		case 3:
			vector = new Vector2(0,0.1f);
			break;
		}
		return vector;
	}
	//isFalling and isMovingMax is used to stop the player from moving/jumping while falling, and to set a max speed left or right
	public static Boolean isFalling(Actor actor) {
		switch(gravityDirection) {
		case 0:
		case 1:
			if (actor.Box2DBody.getLinearVelocity().y == 0) {
				return false;
			} 
			break;
		case 2:
		case 3:
			if (actor.Box2DBody.getLinearVelocity().x == 0) {
				return false;
			}
			break;
		}
		return true;
	}
	public static Boolean isMovingMax(Actor actor) {
		switch(gravityDirection) {
		case 0:
		case 1:
			if (actor.Box2DBody.getLinearVelocity().x > 2 || actor.Box2DBody.getLinearVelocity().x < -2) {
				return true;
			}
		case 2:
		case 3:
			if (actor.Box2DBody.getLinearVelocity().y > 2 || actor.Box2DBody.getLinearVelocity().y < -2) {
				return true;
			}	
		}
		return false;
	}
	
	
	
	//Input skal ha en egen case for bare en spiller, ikke implementert enda.
	public static World input(float deltaTime, Player player1, Player player2, World world) {
		if (!isFalling(player1)) {
			if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
				player1.Box2DBody.applyLinearImpulse(getUp(), player1.Box2DBody.getWorldCenter(), true);
			}
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.D) && !isMovingMax(player1)) {
			player1.Box2DBody.applyLinearImpulse(getRight(), player1.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A) && !isMovingMax(player1)) {
			player1.Box2DBody.applyLinearImpulse(getLeft(), player1.Box2DBody.getWorldCenter(), true);
		}
		
		//Test player 2 controls
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP) && !isFalling(player2) ) {
			player2.Box2DBody.applyLinearImpulse(getUp(), player2.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !isMovingMax(player2)) {
			player2.Box2DBody.applyLinearImpulse(getRight(), player2.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && !isMovingMax(player2)) {
			player2.Box2DBody.applyLinearImpulse(getLeft(), player2.Box2DBody.getWorldCenter(), true);
		}
		
		//Test change gravity
		if(Gdx.input.isKeyJustPressed(Input.Keys.G)) {
			gravityDirection ++;
			if (gravityDirection > 3) gravityDirection = 0; 
			
			world.setGravity(getGravityVector());
			//Physics objects need a little push to get their gravity updated.
			player1.Box2DBody.applyLinearImpulse(new Vector2(-0.01f, 0), player1.Box2DBody.getWorldCenter(), true);
			player2.Box2DBody.applyLinearImpulse(new Vector2(-0.01f, 0), player2.Box2DBody.getWorldCenter(), true);
			
		}
		
		
		
		return world;
	}
}
