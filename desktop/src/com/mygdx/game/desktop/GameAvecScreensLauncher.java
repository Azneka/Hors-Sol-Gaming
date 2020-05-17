package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.DoublesCartes;
import com.mygdx.game.DoublesCartes2_Manuel;
import com.mygdx.game.ExempleGameAvecScreens;

public class GameAvecScreensLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new DoublesCartes(), config);
    }
}
