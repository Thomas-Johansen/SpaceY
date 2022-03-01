package gameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import Objects.Player;
import screens.GameScreen;

public class InputHandler {

	
	public static void input(float deltaTime, Player player1, Player player2, World world) {
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
			player1.Box2DBody.applyLinearImpulse(new Vector2(0,5f), player1.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D) && player1.Box2DBody.getLinearVelocity().x <= 2) {
			player1.Box2DBody.applyLinearImpulse(new Vector2(0.1f, 0), player1.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A) && player1.Box2DBody.getLinearVelocity().x >= -2) {
			player1.Box2DBody.applyLinearImpulse(new Vector2(-0.1f, 0), player1.Box2DBody.getWorldCenter(), true);
		}
		
		//Test player 2 controls
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			player2.Box2DBody.applyLinearImpulse(new Vector2(0,5f), player2.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player2.Box2DBody.getLinearVelocity().x <= 2) {
			player2.Box2DBody.applyLinearImpulse(new Vector2(0.1f, 0), player2.Box2DBody.getWorldCenter(), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && player2.Box2DBody.getLinearVelocity().x >= -2) {
			player2.Box2DBody.applyLinearImpulse(new Vector2(-0.1f, 0), player2.Box2DBody.getWorldCenter(), true);
		}
		
		//Test reverse gravity
		if(Gdx.input.isKeyJustPressed(Input.Keys.G)) {
			Vector2 vector2 = world.getGravity();
			vector2.y = vector2.y * -1;
			world.setGravity(vector2);
			player1.Box2DBody.applyLinearImpulse(new Vector2(-0.01f, 0), player1.Box2DBody.getWorldCenter(), true);
			player2.Box2DBody.applyLinearImpulse(new Vector2(-0.01f, 0), player2.Box2DBody.getWorldCenter(), true);
			
		}
	}
}
