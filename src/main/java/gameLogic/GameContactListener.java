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
		
		if (fixA.getUserData() == "head" || fixB.getUserData() == "head") {
			Fixture head = fixA.getUserData() == "head" ? fixA : fixB;
			Fixture object = head == fixA ? fixB : fixA;
			//Checks if the head has collided with a cube spesifically
			if(object.getUserData() != null &&  Cube.class.isAssignableFrom(object.getUserData().getClass())) {
				System.out.println("Player has died");
				if(fixA.getUserData() == "head") {
				System.out.println();
				}
					/*
					((Player)fixA.getUserData()).onHeadHit();
				} else ((Player)fixB.getUserData()).onHeadHit();
				*/
				//At the moment, getting a box on the head only prints player has died, as an actual death mechanic is not yet implemented.
				
			}
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
