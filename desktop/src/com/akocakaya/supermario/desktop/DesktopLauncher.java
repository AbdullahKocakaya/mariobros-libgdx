package com.akocakaya.supermario.desktop;

import com.akocakaya.supermario.supermario.SuperMario;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new SuperMario(), config);

        config.title = SuperMario.TITLE;
        config.width = SuperMario.WIDTH;
        config.height = SuperMario.HEIGHT;
    }
}
