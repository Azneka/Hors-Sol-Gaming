package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
    SpriteBatch batch;
    OrthographicCamera camera;
    Viewport viewport;
    Stage stage;
    TextureAtlas atlas;
    Skin skin;


    public MainMenuScreen(HorsSolGame game) {
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        stage = new Stage();
        atlas = new TextureAtlas();
        //skin = new Skin();
        //viewport = new FitViewport(Constants.WorldWidth,Constants.WorldHeight,viewport);

    }

//    public void show() {
//        Gdx.input.setInputProcessor(InputAdapter );
//    }
}
