package com.akocakaya.supermario.gameObject.mario;

import com.akocakaya.supermario.supermario.SuperMario;
import com.akocakaya.supermario.textureLoader.TextureLoader;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Mario extends Sprite {

    private World world;
    private Body body;

    TextureRegion marioStand;

    private boolean right = false;
    boolean left = false;

    public Mario(World world) {
        this.world = world;

        defineMario();

        marioStand = new TextureRegion(TextureLoader.littleMario, 0, 0, 16, 16);
        setBounds(0, 0, 36, 36);
        setRegion(marioStand);
    }

    private void defineMario() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(32 / SuperMario.PPM, 32 / SuperMario.PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(6 / SuperMario.PPM);

        fixtureDef.shape = circleShape;
        body.createFixture(fixtureDef).setUserData(this);

        EdgeShape head = new EdgeShape();
        head.set(new Vector2(-2 / SuperMario.PPM, 6 / SuperMario.PPM), new Vector2(2 / SuperMario.PPM, 6 / SuperMario.PPM));
        fixtureDef.shape = head;
        fixtureDef.isSensor = true;

        body.createFixture(fixtureDef).setUserData(this);
    }

    public void render(SpriteBatch spriteBatch) {
        setPosition((body.getPosition().x - getWidth() / 2), (body.getPosition().y - getHeight() / 2));
    }

    public void move() {
        if (right)
            body.applyLinearImpulse(new Vector2(0.1f, 0), body.getWorldCenter(), true);
        if (left)
            body.applyLinearImpulse(new Vector2(-0.1f, 0), body.getWorldCenter(), true);
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public Body getBody() {
        return body;
    }
}
