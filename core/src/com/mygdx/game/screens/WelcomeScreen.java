package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.HorsSolGame;

public class WelcomeScreen extends ScreenAdapter {

    HorsSolGame game;
    Stage welcomeStage;
    //ShapeRenderer shapeRenderer = new ShapeRenderer();

    public WelcomeScreen(HorsSolGame game) {
        this.game = game;
        ScreenViewport viewport = game.getViewport();

        welcomeStage = new Stage(viewport);
        Gdx.input.setInputProcessor(welcomeStage);
    }

    public void show() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            public boolean keyDown(int keyCode) {
                if(keyCode==Input.Keys.SPACE) {
                    game.setScreen(new MainMenuScreen(game));
                }
                return true;
            }
        });

        afficherTextes();



    }

    public void afficherTextes() {

        Label.LabelStyle labelStyleTitle = new Label.LabelStyle(); // création d'un style d'écriture pour le titre
        BitmapFont fontTitle = new BitmapFont(); // création d'une police pour le titre
        fontTitle.getData().setScale(4);
        labelStyleTitle.font = fontTitle;
        labelStyleTitle.fontColor = new Color(0,0.1f,0.1f,0.5f);
        Label.LabelStyle labelStyleSimple = new Label.LabelStyle(); // création d'un style d'écriture simple
        BitmapFont fontSimple = new BitmapFont(); // création d'une police simple
        fontSimple.getData().setScale(2);
        labelStyleSimple.font = fontSimple;


        Label labelTitle = new Label("Week-end à la campagne",labelStyleTitle); // création du texte pour le titre
        labelTitle.setSize(100,30);
        labelTitle.setPosition(700,550);
        labelTitle.setAlignment(Align.center);

        Label labelEspace = new Label("Appuyez sur ESPACE",labelStyleSimple);
        labelEspace.setSize(100,30);
        labelEspace.setPosition(300,200);
        labelEspace.setAlignment(Align.center);


        welcomeStage.addActor(labelEspace);
        welcomeStage.addActor(labelTitle);

    }

    public void render(float delta) {

        Gdx.gl.glClearColor(.29f,0,.12f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = game.getBatch();
        //BitmapFont font = game.getFont();

        welcomeStage.act();
        welcomeStage.draw();


        //shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //shapeRenderer.setColor(.25f,0,0,0);
        //shapeRenderer.circle(350,200,200);
        //shapeRenderer.end();
        batch.begin();
        //font.draw(batch,"Week-end à la campagne",700,800);
        //font.draw(batch,"Appuyez sur ESPACE",400,200);
        batch.end();

    }

    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

}
