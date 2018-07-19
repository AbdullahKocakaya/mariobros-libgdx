package com.akocakaya.supermario.gameObject.map;

import com.akocakaya.supermario.gameObject.GameObject;
import com.akocakaya.supermario.supermario.SuperMario;
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
        renderer = new OrthogonalTiledMapRenderer(tiledMap, 1 / SuperMario.PPM);
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
