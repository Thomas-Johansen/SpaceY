package gameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.World;
import Objects.Player;
import enums.Gravity;

public class InputHandler {
	
	
	
	//Input for singleplayer
	public void input(float deltaTime, Player player1, World world, GravityHandler gravity) {
		if (!gravity.isFalling(player1)) {
			if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
				player1.Box2DBody.applyLinearImpulse(gravity.getUp(), player1.Box2DBody.getWorldCenter(), true);
			}
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.D) && !gravity.isMovingMax(player1)) {
			player1.Box2DBody.applyLinearImpulse(gravity.getRight(), player1.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A) && !gravity.isMovingMax(player1)) {
			player1.Box2DBody.applyLinearImpulse(gravity.getLeft(), player1.Box2DBody.getWorldCenter(), true);
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.G)) gravity.resetPlayerGravity(player1);
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) gravity.setPlayerGravity(Gravity.UP, player1);
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) gravity.setPlayerGravity(Gravity.DOWN, player1);
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) gravity.setPlayerGravity(Gravity.LEFT, player1);
		if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) gravity.setPlayerGravity(Gravity.RIGHT, player1);
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		

		//Temp
		tempGravityChange( gravity, world);
	}
	
	//Input for multiplayer
	public void input(float deltaTime, Player player1, Player player2, World world, GravityHandler gravity) {
		if (!gravity.isFalling(player1)) {
			if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
				player1.Box2DBody.applyLinearImpulse(gravity.getUp(), player1.Box2DBody.getWorldCenter(), true);
			}
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.D) && !gravity.isMovingMax(player1)) {
			player1.Box2DBody.applyLinearImpulse(gravity.getRight(), player1.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A) && !gravity.isMovingMax(player1)) {
			player1.Box2DBody.applyLinearImpulse(gravity.getLeft(), player1.Box2DBody.getWorldCenter(), true);
		}
		
		//Player 2 controls
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP) && !gravity.isFalling(player2) ) {
			player2.Box2DBody.applyLinearImpulse(gravity.getUp(), player2.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !gravity.isMovingMax(player2)) {
			player2.Box2DBody.applyLinearImpulse(gravity.getRight(), player2.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && !gravity.isMovingMax(player2)) {
			player2.Box2DBody.applyLinearImpulse(gravity.getLeft(), player2.Box2DBody.getWorldCenter(), true);
		}
		
		//Temp
		tempGravityChange( gravity, world);
		
	}
	
	/**
	 * Temporary method for changing world gravity for testing purposes
	 * */
	
	public void tempGravityChange(GravityHandler gravity, World world){
		if(Gdx.input.isKeyJustPressed(Input.Keys.I)) gravity.setWorldGravity(Gravity.UP, world);
		if(Gdx.input.isKeyJustPressed(Input.Keys.K)) gravity.setWorldGravity(Gravity.DOWN, world);
		if(Gdx.input.isKeyJustPressed(Input.Keys.J)) gravity.setWorldGravity(Gravity.LEFT, world);
		if(Gdx.input.isKeyJustPressed(Input.Keys.L)) gravity.setWorldGravity(Gravity.RIGHT, world);
	}

}
