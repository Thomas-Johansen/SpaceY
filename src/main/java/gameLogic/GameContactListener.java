package gameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import Objects.Cube;
import Objects.Player;
import enums.Life;

/**
 * This class handles events when two specific objects touch in the Box2D world
 * 
 * */
public class GameContactListener implements ContactListener {

	@Override
	public void beginContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();
		
			if (fixA.getUserData() =="head" && fixB.getUserData() instanceof Cube) {
				Player player = (Player) fixA.getBody().getUserData();
				Cube cube = (Cube) fixB.getBody().getUserData();
				Gdx.app.log("Player", "Hit in head");
				player.onHeadHit();
			}
			
			if (fixB.getUserData() == "head" && fixA.getUserData() instanceof Cube) {
				Player player = (Player) fixB.getBody().getUserData();
				Cube cube = (Cube) fixA.getBody().getUserData();
				Gdx.app.log("Player", "Hit in head");
				player.onHeadHit();
			}
		
		
		
		/*
		if ("head".equals(fixA.getUserData()) || "head".equals(fixB.getUserData())) {
			Fixture head = fixA.getUserData() == "head" ? fixA : fixB;
			Fixture object = head == fixA ? fixB : fixA;
			//Checks if the head has collided with a cube spesifically
			if(object.getUserData() != null &&  Cube.class.isAssignableFrom(object.getUserData().getClass())) {
				System.out.println("Player has died");
				System.out.println((Player)head.getUserData());
			}
		}
		*/
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
