package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import inf112.skeleton.app.PlatformGame;
import screens.GameScreen;

public abstract class Enemy extends Sprite{
    public Texture texture;
    public World world;
    public Body Box2DBody;

    public Enemy(World world, Texture texture, float x, float y) {
        this.world = world;
        this.texture = texture;
        setPosition(x,y);
    }

    public Enemy(World world, Texture texture) {

    }


    public abstract void defineEnemy();
}
