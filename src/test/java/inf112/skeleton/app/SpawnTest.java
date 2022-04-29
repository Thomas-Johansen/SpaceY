package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import Objects.Player;

public class SpawnTest {

    @Test
    void playerSpawnTest() {
            System.out.println("Start test");
            Player player1 = new Player(new World(new Vector2(0,0), false), new Vector2(0,0), 1);
            assertTrue(player1.isAlive());
            player1.onHeadHit();
            assertFalse(player1.isAlive());
        }
    }


