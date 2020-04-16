package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.screens.MainGameScreen;

public class HorsSolGame extends Game {
	SpriteBatch batch;
	Texture img;
	Screen screen;
	int x;
	int y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("zeldapixel.png");
		setScreen(new MainGameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

}
