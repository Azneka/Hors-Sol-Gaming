package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.HorsSolGame;

public class MainMenuScreen extends ScreenAdapter {

    HorsSolGame game;
    Stage mainMenuStage;
    TextButton playButton;
    TextButton optionsButton;
    //SpriteBatch batch;
    //TextureAtlas atlas;


    public MainMenuScreen(HorsSolGame game) {
        this.game = game;

        ScreenViewport viewport = game.getViewport();
        mainMenuStage = new Stage(viewport);
        Gdx.input.setInputProcessor(mainMenuStage);
        //batch = new SpriteBatch();
        //atlas = new TextureAtlas();

    }

    public void show() {

        Gdx.input.setInputProcessor(mainMenuStage);

        //createTable(600,600,300,300); > créer cette méthode
        Table tableTitle = new Table();
        tableTitle.setSize(300,300);
        tableTitle.setPosition(600,600);
        tableTitle.setBounds(600,600,300,300);
        mainMenuStage.addActor(tableTitle);


        Label.LabelStyle labelStyleTitle = new Label.LabelStyle();
        BitmapFont fontTitle = new BitmapFont();
        labelStyleTitle.font = fontTitle;
        fontTitle.getData().setScale(3);
        Label labelTitle = new Label("MAIN MENU", labelStyleTitle);
        labelTitle.setPosition(600,1000);
        labelTitle.setAlignment(Align.center);
        tableTitle.add(labelTitle);


        playButton = createPlayButton();
        optionsButton = createOptionsButton();
        mainMenuStage.addActor(playButton);
        mainMenuStage.addActor(optionsButton);


    }

    public TextButton createPlayButton() {

        Table tablePlayButton = new Table();
        tablePlayButton.setSize(300,300);
        //tablePlayButton.setBounds(600,400,300,300);

        //tablePlayButton.setTouchable(Touchable.enabled);

        mainMenuStage.addActor(tablePlayButton);

        Skin playButtonSkin = new Skin(Gdx.files.internal("skin/craftacular/craftacular-ui.json"));
        playButton = new TextButton("JOUER", playButtonSkin);

//        BitmapFont fontSimple = new BitmapFont();
//        fontSimple.getData().setScale(2);
//        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
//        textButtonStyle.font = fontSimple;
//        TextButton playButton = new TextButton("JOUER",textButtonStyle);
        playButton.setPosition(600,400);

        tablePlayButton.add(playButton);

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainGameScreen(game));
            }
        });

        return playButton;
    }


    public TextButton createOptionsButton() {

        Table tableOptionsButton = new Table();
        tableOptionsButton.setSize(300,300);
        tableOptionsButton.setBounds(600,200,300,300);

        //tableOptionsButton.setTouchable(Touchable.enabled);

        mainMenuStage.addActor(tableOptionsButton);

        Skin optionsButtonSkin = new Skin(Gdx.files.internal("skin/craftacular/craftacular-ui.json"));
        optionsButton = new TextButton("OPTIONS", optionsButtonSkin);

//        BitmapFont fontSimple = new BitmapFont();
//        fontSimple.getData().setScale(2);
//        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
//        textButtonStyle.font = fontSimple;
//        TextButton optionsButton = new TextButton("JOUER",textButtonStyle);
        optionsButton.setPosition(600,300);

        tableOptionsButton.add(optionsButton);

        optionsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainOptionsScreen(game));
            }
        });

        return playButton;
    }




    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.29f,0,.12f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = game.getBatch();

        mainMenuStage.act(Gdx.graphics.getDeltaTime());
        mainMenuStage.draw();


        batch.begin();
        //font.draw(batch,"MAIN MENU",700,800);
        batch.end();

    }

    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
