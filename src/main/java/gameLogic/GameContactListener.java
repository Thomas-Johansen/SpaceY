package gameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import Objects.Cube;
import Objects.Enemy;
import Objects.Player;

/**
 * This class handles events when two specific objects touch in the Box2D world
 * 
 * */
public class GameContactListener implements ContactListener {

	@Override
	public void beginContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();
		
			//Player head hit by cube
			if (fixA.getUserData() =="head" && fixB.getBody().getUserData() instanceof Cube) {
				Player player = (Player) fixA.getBody().getUserData();
				Gdx.app.log("Player", "Hit in head");
				player.onHeadHit();
			}
			
			if (fixB.getUserData() == "head" && fixA.getBody().getUserData() instanceof Cube) {
				Player player = (Player) fixB.getBody().getUserData();
				Gdx.app.log("Player", "Hit in head");
				player.onHeadHit();
			}
		
			//Player hit by alien
			if (fixA.getBody().getUserData() instanceof Player && fixB.getBody().getUserData() instanceof Enemy) {
				Player player = (Player) fixA.getBody().getUserData();
				Gdx.app.log("Player", "Hit by Enemy");
				player.onHeadHit();
			}
			
			if (fixB.getBody().getUserData() instanceof Player && fixA.getBody().getUserData() instanceof Enemy) {
				Player player = (Player) fixB.getBody().getUserData();
				Gdx.app.log("Player", "Hit by Enemy");
				player.onHeadHit();
			}
		
		
	}

	@Override
	public void endContact(Contact contact) {

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}

}
