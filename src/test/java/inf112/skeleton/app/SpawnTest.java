package inf112.skeleton.app;

import Objects.Player;
import Objects.Actor;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import enums.Life;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class SpawnTest {

    @Test
    void playerSpawnTest() {
        Thread test1= new Thread(() -> {
            System.out.println("Start test");
            Player player1 = new Player(new World(new Vector2(0,0), false), new Vector2(0,0));
            assertTrue(player1.isAlive());
            player1.onHeadHit();
            assertFalse(player1.isAlive());
            //
        });
    }
}


