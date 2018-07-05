package com.akocakaya.supermario.imageLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureLoader {

    private static Texture stagePointerTexture;
    public static TextureRegion stagePointerRegion;

    public static void load() {
        stagePointerTexture = new Texture(Gdx.files.internal("stage-pointer.png"));

        //                                                  image - render place  -  how much gonna cut
        stagePointerRegion = new TextureRegion(stagePointerTexture, 0, 0, 1000, 1000);
        Gdx.app.log("Image", "Stage Pointer loaded");
    }

    public static void dispose() {
        stagePointerTexture.dispose();
    }
}
