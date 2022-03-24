package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	 */
	@Test
	void test1() {
		 Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
	        
	        cfg.setTitle("GameTest");
	        cfg.setWindowedMode(PlatformGame.V_Width, PlatformGame.V_Height);
	        new Lwjgl3Application(new TestGame(), cfg);
	}

}