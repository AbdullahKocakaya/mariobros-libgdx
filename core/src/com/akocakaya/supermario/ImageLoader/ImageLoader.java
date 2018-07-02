package com.akocakaya.supermario.ImageLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ImageLoader {

    private static Texture texture, stagePointerTexture;
    public static TextureRegion backgroundRegion, stagePointerRegion;

    public static void load() {
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        stagePointerTexture = new Texture(Gdx.files.internal("stage-pointer.png"));

        stagePointerRegion = new TextureRegion(stagePointerTexture,0,0,1000,1000);
        Gdx.app.log("Image", "Stage Pointer loaded");

        //                                   image - render place  -  how much gonna cut
        backgroundRegion = new TextureRegion(texture,0,0,256,256);
        Gdx.app.log("Image", "Background loaded");
    }

    public static void dispose() {
        texture.dispose();
    }
}
