package com.akocakaya.supermario.textureLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureLoader {

    private static Texture stagePointerTexture;
    private static TextureAtlas marioAndEnemiesTextureAtlas;
    public static TextureRegion stagePointerRegion, littleMario;

    public static void load() {
        stagePointerTexture = new Texture(Gdx.files.internal("stage-pointer.png"));
        marioAndEnemiesTextureAtlas = new TextureAtlas("Mario_and_Enemies.pack");

        //                                                  image - render place  -  how much gonna cut
        stagePointerRegion = new TextureRegion(stagePointerTexture, 0, 0, 1000, 1000);
        Gdx.app.log("Image", "Stage Pointer loaded");

        littleMario = new TextureRegion(marioAndEnemiesTextureAtlas.findRegion("little_mario"));
        Gdx.app.log("Texture", "Little mario loaded");
    }

    public static void dispose() {
        stagePointerTexture.dispose();
    }
}
