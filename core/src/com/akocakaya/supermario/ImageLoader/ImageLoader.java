package com.akocakaya.supermario.ImageLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ImageLoader {

    private static Texture texture;
    public static TextureRegion backgroundRegion;

    public static void load() {
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));

        //                                   image - render place  -  how much gonna cut
        backgroundRegion = new TextureRegion(texture,0,0,256,256);
    }

    public static void dispose() {
        texture.dispose();
    }
}
