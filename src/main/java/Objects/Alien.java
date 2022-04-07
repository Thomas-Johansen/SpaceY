package Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import inf112.skeleton.app.PlatformGame;

public class Alien extends Enemy {

    public Alien(World world, Vector2 spawn) {
        super(world,new Texture("src/main/resources/assets/pngegg.png"),spawn);
    }

    @Override
    public void defineEnemy(Vector2 spawn) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(spawn);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        Box2DBody = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(6 / PlatformGame.PPM, 6 / PlatformGame.PPM);
        fixtureDef.shape = poly;
        Box2DBody.createFixture(fixtureDef);
    }
}
