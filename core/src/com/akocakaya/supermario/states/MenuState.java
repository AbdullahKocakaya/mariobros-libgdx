package com.akocakaya.supermario.states;

import com.akocakaya.supermario.ImageLoader.ImageLoader;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State {

    private StateManager stateManager;

    public MenuState(StateManager stateManager) {
        super(stateManager);

        this.stateManager = stateManager;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(ImageLoader.backgroundRegion, 0, 0, 100,100);
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {

    }
}
