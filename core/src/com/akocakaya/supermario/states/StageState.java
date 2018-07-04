package com.akocakaya.supermario.states;

import com.akocakaya.supermario.GameObject.GameWorld;
import com.akocakaya.supermario.inputhandler.StageStateInput;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StageState extends State {

    private StateManager stateManager;
    private GameWorld gameWorld;

    public StageState(StateManager stateManager) {
        super(stateManager);

        this.stateManager = stateManager;

        camera.zoom = 0.34f;

        camera.setToOrtho(false);
        Gdx.input.setInputProcessor(new StageStateInput(this));

        gameWorld = new GameWorld();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        gameWorld.render(spriteBatch);
        gameWorld.getBox2DDebugRenderer().render(gameWorld.getWorld(), camera.combined);
    }

    @Override
    public void update(float delta) {
        camera.update();
        gameWorld.update(delta);
        gameWorld.getRenderer().setView(camera);
        //camera.position.x += 1;
    }

    public StateManager getStateManager() {
        return stateManager;
    }
}
