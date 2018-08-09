package com.akocakaya.supermario.gameObject;

import com.akocakaya.supermario.gameObject.mario.Mario;
import com.akocakaya.supermario.gameObject.map.Map;
import com.akocakaya.supermario.gameObject.tools.WorldCreator;
import com.akocakaya.supermario.textureLoader.TextureLoader;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameWorld implements GameObject {

    private Map map;

    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;

    private OrthogonalTiledMapRenderer renderer;

    private Mario mario;

    public GameWorld() {
        map = new Map();
        renderer = map.getTiledMapRenderer();

        world = new World(new Vector2(0, -5), true);
        box2DDebugRenderer = new Box2DDebugRenderer();
        WorldCreator worldCreator = new WorldCreator(this);


        mario = new Mario(world);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        map.render(spriteBatch);
        mario.render(spriteBatch);
    }

    @Override
    public void update(float delta) {
        mario.move();
        map.update(delta);
                        //gravity
        world.step(1/60f,1,1);
    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        world.dispose();
        box2DDebugRenderer.dispose();
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }

    public World getWorld() {
        return world;
    }

    public Map getMap() {
        return map;
    }

    public Box2DDebugRenderer getBox2DDebugRenderer() {
        return box2DDebugRenderer;
    }

    public Mario getMario() {
        return mario;
    }
}
