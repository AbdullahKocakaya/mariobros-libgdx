package com.akocakaya.supermario.GameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {

    void render(SpriteBatch spriteBatch);

    void update(float delta);

    void dispose();
}
