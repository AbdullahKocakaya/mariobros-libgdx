package com.akocakaya.supermario.gameObject.enemy;

import com.akocakaya.supermario.gameObject.GameWorld;
import com.akocakaya.supermario.supermario.SuperMario;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Goomba extends Enemy {

    public Goomba(GameWorld gameWorld, float x, float y) {
        super(gameWorld, x, y);
        setBounds(getX(), getY(), 16 / SuperMario.PPM, 16 / SuperMario.PPM);
    }

    @Override
    protected void defineEnemy() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(getX(), getY());

        //Dynamic bodies are objects which move around and are affected by forces and other dynamic,
        //kinematic and static objects. Dynamic bodies are suitable for any object which needs to move and be affected by forces
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(6 / SuperMario.PPM);

        fixtureDef.shape = circleShape;
        body.createFixture(fixtureDef).setUserData(this);

        PolygonShape head = new PolygonShape();
        Vector2[] vertices = new Vector2[4];
        vertices[0] = new Vector2(-5, 6).scl(1 / SuperMario.PPM);
        vertices[1] = new Vector2(5, 6).scl(1 / SuperMario.PPM);
        vertices[2] = new Vector2(-3, 5).scl(1 / SuperMario.PPM);
        vertices[3] = new Vector2(3, 5).scl(1 / SuperMario.PPM);
        head.set(vertices);

        fixtureDef.shape = head;
        fixtureDef.restitution = 0.5f;
        body.createFixture(fixtureDef).setUserData(this);
    }

    @Override
    public void update(float delta) {

    }

    public void draw(Batch batch) {
        super.draw(batch);
    }
}
