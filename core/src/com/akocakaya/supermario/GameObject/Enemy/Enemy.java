package com.akocakaya.supermario.GameObject.Enemy;

import com.akocakaya.supermario.GameObject.GameWorld;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Enemy extends Sprite {

    protected World world;
    protected GameWorld gameWorld;
    public Body body;
    public Vector2 velocity;

    public Enemy(GameWorld gameWorld, float x, float y) {
        this.world = gameWorld.getWorld();
        this.gameWorld = gameWorld;
        setPosition(x, y);
        defineEnemy();
        velocity = new Vector2(-1, -2);
        body.setActive(false);
    }

    protected abstract void defineEnemy();

    public abstract void update(float delta);

    public void draw(SpriteBatch spriteBatch) {
        draw(spriteBatch);
    }
}
