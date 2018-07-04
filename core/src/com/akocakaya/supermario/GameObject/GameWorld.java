package com.akocakaya.supermario.GameObject;

import com.akocakaya.supermario.GameObject.Map.Map;
import com.akocakaya.supermario.GameObject.Tools.WorldCreator;
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

    public GameWorld() {
        map = new Map();
        renderer = map.getRenderer();

        world = new World(new Vector2(0, -10), true);
        box2DDebugRenderer = new Box2DDebugRenderer();
        WorldCreator worldCreator = new WorldCreator(this);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        map.render(spriteBatch);
    }

    @Override
    public void update(float delta) {
        map.update(delta);
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
}
