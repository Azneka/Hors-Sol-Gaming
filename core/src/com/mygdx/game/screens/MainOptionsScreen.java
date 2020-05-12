package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.HorsSolGame;

public class MainOptionsScreen extends ScreenAdapter {

    HorsSolGame game;
    Stage mainOptionsStage;

    public MainOptionsScreen(HorsSolGame game) {
        this.game = game;

        ScreenViewport viewport = game.getViewport();
        mainOptionsStage = new Stage(viewport);
        Gdx.input.setInputProcessor(mainOptionsStage);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(mainOptionsStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.29f,0,.12f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = game.getBatch();

        mainOptionsStage.act(Gdx.graphics.getDeltaTime());
        mainOptionsStage.draw();


        batch.begin();

        batch.end();
    }

    @Override
    public void hide() { Gdx.input.setInputProcessor(null); }

}
