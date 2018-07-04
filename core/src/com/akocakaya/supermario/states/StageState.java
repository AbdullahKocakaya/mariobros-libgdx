package com.akocakaya.supermario.states;

import com.akocakaya.supermario.GameObject.GameWorld;
import com.akocakaya.supermario.inputhandler.StageStateInput;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StageState extends State {

    private Viewport viewport;

    private StateManager stateManager;
    private GameWorld gameWorld;

    public StageState(StateManager stateManager) {
        super(stateManager);

        this.stateManager = stateManager;

        viewport = new FitViewport(10, 10, camera);
        camera.zoom = 0.34f;

        camera.setToOrtho(false);
        Gdx.input.setInputProcessor(new StageStateInput(this));

        gameWorld = new GameWorld();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        gameWorld.render(spriteBatch);
    }

    @Override
    public void update(float delta) {
        camera.update();
        gameWorld.update(delta);
        gameWorld.getRenderer().setView(camera);
        camera.position.x += 2;

    }

    public StateManager getStateManager() {
        return stateManager;
    }
}
