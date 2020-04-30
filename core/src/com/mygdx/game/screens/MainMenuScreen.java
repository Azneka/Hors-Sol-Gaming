package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.HorsSolGame;
import com.mygdx.game.actors.ParameterButton;
import javafx.scene.control.Skin;
import sun.security.pkcs11.wrapper.Constants;

import javax.swing.text.View;

public class MainMenuScreen extends ScreenAdapter {

    HorsSolGame game;
    Stage mainMenuStage;
    ParameterButton playButton;
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

        //Gdx.input.setInputProcessor(mainMenuStage);

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


        playButton = new ParameterButton(600,400);
        play();
        playButton.setTouchable(Touchable.enabled);
        mainMenuStage.addActor(playButton);





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



    }

    public TextButton createPlayButton() {

        final Table tablePlayButton = new Table();
        tablePlayButton.setSize(300,300);
        tablePlayButton.setPosition(600,400);
        //tablePlayButton.setBounds(600,400,300,300);


        tablePlayButton.setTouchable(Touchable.enabled);

        mainMenuStage.addActor(tablePlayButton);

        BitmapFont fontSimple = new BitmapFont();
        fontSimple.getData().setScale(2);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = fontSimple;
        TextButton playButton = new TextButton("JOUER",textButtonStyle);
        playButton.setPosition(600,400);

        tablePlayButton.add(playButton);

        return playButton;
    }

    public void play() {

        //playButton = new ParameterButton(600,400);

        Table tableButton = new Table();
        tableButton.setSize(400,400);
        tableButton.setPosition(600,400);
        tableButton.setBounds(600,400,400,400);
        mainMenuStage.addActor(tableButton);

        tableButton.add(playButton.creerLabel("JOUER"));
        tableButton.add(playButton);

        if(playButton.getStarted()) {
            game.setScreen(new MainGameScreen(game));
        }

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.29f,0,.12f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = game.getBatch();
        //BitmapFont font = game.getFont();
        BitmapFont font = new BitmapFont();

        mainMenuStage.act(Gdx.graphics.getDeltaTime());
        mainMenuStage.draw();

//        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
//            game.setScreen(new MainGameScreen(game));
//        }

//        playButton.addListener(new ClickListener() {
//           @Override
//            public void clicked(InputEvent event, float x, float y) {
//                game.setScreen(new MainGameScreen(game) );
//            };
//        });

        batch.begin();
        //font.draw(batch,"MAIN MENU",700,800);
        batch.end();

    }

    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
