package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.screens.WelcomeScreen;

import java.awt.*;

public class HorsSolGame extends Game {
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	//double width = Gdx.graphics.getWidth();
	//double height = Gdx.graphics.getHeight();

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("zeldapixel.png");
		font = new BitmapFont();
		setScreen(new WelcomeScreen(this));
	}

	//@Override
	//public void render () {
	//	super.render();
	//}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		font.dispose();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public BitmapFont getFont() { return font; }

//	public double getHeight() {
//		return height;
//	}
//
//	public double getWidth() {
//		return width;
//	}
}
