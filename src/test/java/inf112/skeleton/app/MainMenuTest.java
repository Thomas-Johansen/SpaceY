package inf112.skeleton.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import SpaceY.PlatformGame;

public class MainMenuTest {

    @Test
    public void MainMenuHeightTest(){
        assertEquals(370, PlatformGame.V_Height);
    }

    @Test
    public void MainMenuWidthTest(){
        assertEquals(600, PlatformGame.V_Width);
    }
}
