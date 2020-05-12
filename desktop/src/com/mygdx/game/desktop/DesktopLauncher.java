package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.HorsSolGame;

import java.awt.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		config.width = dim.width;
		config.height = dim.height;
		new LwjglApplication(new HorsSolGame(), config);
	}
}
