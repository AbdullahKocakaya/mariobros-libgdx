package com.akocakaya.supermario.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MenuState extends State {

    private StateManager stateManager;
    private TextureRegion textureRegion;

    public MenuState(StateManager stateManager) {
        super(stateManager);

        this.stateManager = stateManager;
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("badlogic.jpg")),0,0,256,256);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(textureRegion,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {

    }


}
