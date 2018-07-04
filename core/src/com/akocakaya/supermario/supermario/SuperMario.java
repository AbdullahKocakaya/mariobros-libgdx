package com.akocakaya.supermario.supermario;

import com.akocakaya.supermario.ImageLoader.TextureLoader;
import com.akocakaya.supermario.states.MenuState;
import com.akocakaya.supermario.states.StateManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SuperMario extends ApplicationAdapter {

    public static int WIDTH = 1000;
    public static int HEIGHT = 600;
    public static String TITLE = "Super Mario Bros";

    private static StateManager stateManager;

    private SpriteBatch spriteBatch;


    @Override
    public void create() {
        Gdx.gl.glClearColor(0, 0, 0, 1);

        TextureLoader.load();

        spriteBatch = new SpriteBatch();

        stateManager = new StateManager();
        stateManager.pushState(new MenuState(stateManager));
        Gdx.app.log("Game", "MenuState Started");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateManager.render(spriteBatch);
        stateManager.update(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        TextureLoader.dispose();

        Gdx.app.log("Game", "Dispose");
    }
}
