package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import inf112.skeleton.app.PlatformGame;
import screens.GameScreen;

public class Alien extends Enemy {
    public Alien(World world, Texture texture, float x, float y) {
        super(world, texture, x, y);
    }

    public Alien(World world, Texture texture) {
        super(world, texture);
    }

    @Override
    public void defineEnemy() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(100 / PlatformGame.PPM,100 / PlatformGame.PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Box2DBody = world.createBody(bodyDef);

        FixtureDef fixture = new FixtureDef();
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(6 / PlatformGame.PPM, 6 / PlatformGame.PPM);
        fixture.shape = poly;
        Box2DBody.createFixture(fixture);

    }
}
