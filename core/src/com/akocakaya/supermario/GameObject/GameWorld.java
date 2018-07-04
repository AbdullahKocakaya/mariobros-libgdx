package com.akocakaya.supermario.GameObject;

import com.akocakaya.supermario.GameObject.Map.Map;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameWorld implements GameObject {

    private Map map;

    private OrthogonalTiledMapRenderer renderer;

    public GameWorld() {
        map = new Map();
        renderer = map.getRenderer();
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
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }
}
