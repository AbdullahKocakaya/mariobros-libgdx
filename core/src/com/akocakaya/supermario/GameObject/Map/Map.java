package com.akocakaya.supermario.GameObject.Map;

import com.akocakaya.supermario.GameObject.GameObject;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map implements GameObject {

    private OrthogonalTiledMapRenderer renderer;
    private TiledMap tiledMap;

    public Map() {
        TmxMapLoader mapLoader = new TmxMapLoader();
        tiledMap = mapLoader.load("level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        renderer.render();
    }

    @Override
    public void update(float update) {

    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }
}
