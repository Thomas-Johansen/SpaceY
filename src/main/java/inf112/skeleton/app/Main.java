package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("SpaceY");
        cfg.setWindowedMode(PlatformGame.V_Width, PlatformGame.V_Height);
        new Lwjgl3Application(new PlatformGame(), cfg);
    }
}