package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Objects;


import Objects.Player;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import screens.GameScreen;

public class AppTest {
	/**
	 * Static method run before everything else
	 */
	@BeforeAll
	static void setUpBeforeAll() {
	}

	/**
	 * Setup method called before each of the test methods
	 */
	@BeforeEach
	void setUpBeforeEach() {
	}

	/**
	 * Test for running the entire application via tests
	 * Moves the player inn 3 directions.
	 * Then tests the player controled gravity movement
	 * Then extits the application
	 */
	@Test
	void test1() throws AWTException, InterruptedException {
		 Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
	        
	        cfg.setTitle("GameTest");
	        cfg.setWindowedMode(PlatformGame.V_Width, PlatformGame.V_Height);
	        
	        Thread test = new Thread() {
	        	@Override
	        	public void run() {
	        		new Lwjgl3Application(new TestGame(), cfg);
	        	}
	        };
	        Robot robot = new Robot();
	        Thread test2 = new Thread() {
	        	@Override
	        	public void run() {
	        	   
	     	       System.out.println("Start Test:");
	     	       //Movement test singleplayer
	     	       robot.delay(5000);
	     	       robot.keyPress(87);
	     	       robot.delay(500);
	     	       robot.keyRelease(87);
	     	       robot.delay(2000);
	     	       robot.keyPress(65);
	     	       robot.delay(500);
	     	       robot.keyRelease(65);
	     	       robot.delay(2000);
	     	       robot.keyPress(68);
	     	       robot.delay(500);
	     	       robot.keyRelease(68);
	     	       robot.delay(2000);
	     	       
	     	       //Gravity turn singleplayer
	     	       robot.keyPress(KeyEvent.VK_UP);
	     	       robot.delay(50);
	     	       robot.keyRelease(KeyEvent.VK_UP);
	     	      robot.delay(2000);
	     	       robot.keyPress(KeyEvent.VK_LEFT);
	     	       robot.delay(50);
	     	       robot.keyRelease(KeyEvent.VK_LEFT);
	     	      robot.delay(2000);
	     	       robot.keyPress(KeyEvent.VK_RIGHT);
	     	       robot.delay(50);
	     	       robot.keyRelease(KeyEvent.VK_RIGHT);
	     	      robot.delay(2000);
	     	       robot.keyPress(KeyEvent.VK_DOWN);
	     	       robot.delay(50);
	     	       robot.keyRelease(KeyEvent.VK_DOWN);
	     	      robot.delay(2000);

	     	       System.out.println("Stop Test:");
	     	      robot.keyPress(27);
	     	       robot.delay(50);
	     	       robot.keyRelease(27);
	     	      

	        	}
	        };
	       test.start();
	       test2.start();
	       
	       test.join();
	       test2.join();
	    
	}
}