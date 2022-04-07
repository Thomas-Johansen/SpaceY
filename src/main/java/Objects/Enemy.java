package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import inf112.skeleton.app.PlatformGame;
import screens.GameScreen;

public abstract class Enemy extends Sprite{
    public Texture texture;
    public World world;
    public Body Box2DBody;
    protected Fixture fixture;

    public Enemy(World world, Texture texture, Vector2 spawn) {
        this.world = world;
        this.texture = texture;
        defineEnemy(spawn);
        setBounds(0, 0, 14 / PlatformGame.PPM, 20 / PlatformGame.PPM);
        setRegion(texture);
    }


    public void defineEnemy(Vector2 spawn) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(spawn);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Box2DBody = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(6 / PlatformGame.PPM, 6 / PlatformGame.PPM);
        fixtureDef.shape = poly;
        fixture = Box2DBody.createFixture(fixtureDef);
    }
}
