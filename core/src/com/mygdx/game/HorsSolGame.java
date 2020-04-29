package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.screens.WelcomeScreen;


import java.awt.*;

public class HorsSolGame extends Game {
	SpriteBatch batch;
	Sprite sprite;
	Texture img;
	//BitmapFont font;
	ScreenViewport viewport;
	//Stage welcomeStage;
	//Stage mainMenuStage;
	//Stage gameStage;
	//Camera gameCamera;
	final float gameWorldWidth = 2000; //Gdx.graphics.getWidth(); ne fonctionne pas ici, comment faire pour que ce soit adaptable selon les écrans ?
	final float gameWorldHeight = 1000; //Gdx.graphics.getHeight();

	
	@Override
	public void create () {
		viewport = new ScreenViewport();




		batch = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal("waterfall.jpg")));
		sprite.setSize(gameWorldWidth,gameWorldHeight);
		img = new Texture("zeldapixel.png");
		//font = new BitmapFont();
		setScreen(new WelcomeScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		//font.dispose();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	//public BitmapFont getFont() { return font; }

//	public Stage getWelcomeStage() {
//		return welcomeStage;
//	}
//
//	public Stage getMainMenuStage() { return mainMenuStage; }
//
//	public Stage getGameStage() { return gameStage; }
//
	public Sprite getSprite() { return sprite; }
//
//	public Camera getGameCamera() { return gameCamera; }

	public ScreenViewport getViewport() { return viewport; }

	public float getGameWorldWidth() { return gameWorldWidth; }

	public float getGameWorldHeight() { return gameWorldHeight; }

//	public double getHeight() {
//		return height;
//	}
//
//	public double getWidth() {
//		return width;
//	}
}
