package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

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
	 * Simple test case to see if a test can start the application
	 * 
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
	     	       robot.delay(5000);
	     	       robot.keyPress(71);
	     	       robot.delay(50);
	     	       robot.keyRelease(71);
	     	       robot.delay(2000);
	     	       robot.keyPress(71);
	     	       robot.delay(50);
	     	       robot.keyRelease(71);
	     	       robot.delay(2000);
	     	       robot.keyPress(71);
	     	       robot.delay(50);
	     	       robot.keyRelease(71);
	     	       robot.delay(2000);
	     	       robot.keyPress(71);
	     	       robot.delay(50);
	     	       robot.keyRelease(71);
	     	       System.out.println("Stop Test:");
	        	}
	        };
	       test.start();
	       test2.start();
	       
	       test.join();
	       test2.join();
	    
	}
	
}