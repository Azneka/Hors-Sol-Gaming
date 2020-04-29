package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.HorsSolGame;
import javafx.scene.control.Skin;
import sun.security.pkcs11.wrapper.Constants;

import javax.swing.text.View;

public class MainMenuScreen extends ScreenAdapter {

    HorsSolGame game;
    Stage mainMenuStage;
    //SpriteBatch batch;
    //TextureAtlas atlas;
    //Skin skin;



    public MainMenuScreen(HorsSolGame game) {
        this.game = game;

        ScreenViewport viewport = game.getViewport();
        mainMenuStage = new Stage(viewport);
        Gdx.input.setInputProcessor(mainMenuStage);
        //batch = new SpriteBatch();
        //atlas = new TextureAtlas();
        //skin = new Skin();

    }

    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            public boolean keyDown(int keyCode) {
                if(keyCode==Input.Buttons.LEFT) {
                    game.setScreen(new MainGameScreen(game));
                }
                return true;
            }
        });


        //ClickListener leftClickListener = new ClickListener();
        Table table = new Table();

        table.setSize(300,300);
        table.setPosition(800,400);
        mainMenuStage.addActor(table);

        BitmapFont fontSimple = new BitmapFont();
        fontSimple.getData().setScale(2);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = fontSimple;
        TextButton playButton = new TextButton("JOUER",textButtonStyle);
        playButton.setPosition(800,400);
        //playButton.addListener(leftClickListener);

        table.add(playButton);


//        playButton.addListener(new ChangeListener() {
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                game.setScreen(new MainGameScreen(game));
//            }
//        });

//        playButton.addListener(new EventListener() {
//            @Override
//            public boolean handle(Event event) {
//                game.setScreen(new MainGameScreen(game));
//                return false;
//            }
//        });

//        Gdx.input.setInputProcessor(new InputAdapter() {
//            public boolean keyDown(int keyCode) {
//                if(keyCode==Input.Keys.SPACE) {
//                    game.setScreen(new MainGameScreen(game));
//                }
//                return true;
//            }
//        });

//        playButton.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                game.setScreen(new MainGameScreen(game) );
//            };
//        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.29f,0,.12f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = game.getBatch();
        //BitmapFont font = game.getFont();
        BitmapFont font = new BitmapFont();

        mainMenuStage.act();
        mainMenuStage.draw();

        batch.begin();
        font.draw(batch,"MAIN MENU",700,800);
        batch.end();

    }

    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
