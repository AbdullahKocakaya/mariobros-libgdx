package com.akocakaya.supermario.states;

import com.akocakaya.supermario.inputhandler.StageStateInput;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StageState extends State {

    private StateManager stateManager;

    public StageState(StateManager stateManager) {
        super(stateManager);

        this.stateManager = stateManager;

        Gdx.input.setInputProcessor(new StageStateInput(this));
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void update(float delta) {

    }

    public StateManager getStateManager() {
        return stateManager;
    }
}
