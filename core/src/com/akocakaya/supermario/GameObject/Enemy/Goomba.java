package com.akocakaya.supermario.GameObject.Enemy;

import com.akocakaya.supermario.GameObject.GameWorld;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Goomba extends Enemy {

    public Goomba(GameWorld gameWorld, float x, float y) {
        super(gameWorld, x, y);
        setBounds(getX(), getY(), 16, 16);
    }

    @Override
    protected void defineEnemy() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(getX(), getY());
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(6);

        fixtureDef.shape = circleShape;
        body.createFixture(fixtureDef).setUserData(this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
    }
}
