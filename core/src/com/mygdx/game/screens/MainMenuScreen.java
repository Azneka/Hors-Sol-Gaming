package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.HorsSolGame;
import javafx.scene.control.Skin;
import javafx.stage.Stage;
import sun.security.pkcs11.wrapper.Constants;

import javax.swing.text.View;

public class MainMenuScreen extends ScreenAdapter {

    HorsSolGame game;
    //SpriteBatch batch;
    //OrthographicCamera camera;
    //Viewport viewport;
    //Stage stage;
    //TextureAtlas atlas;
    //Skin skin;



    public MainMenuScreen(HorsSolGame game) {
        this.game = game;
        //batch = new SpriteBatch();
        //camera = new OrthographicCamera();
        //stage = new Stage();
        //atlas = new TextureAtlas();
        //skin = new Skin();
        //viewport = new FitViewport(Constants.WorldWidth,Constants.WorldHeight,viewport);

    }

    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            public boolean keyDown(int keyCode) {
                if(keyCode== Input.Keys.SPACE) {
                    game.setScreen(new MainGameScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.29f,0,.12f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = game.getBatch();
        BitmapFont font = game.getFont();
        batch.begin();
        font.draw(game.getBatch(),"MAIN MENU",400,440);
        batch.end();

    }

    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
