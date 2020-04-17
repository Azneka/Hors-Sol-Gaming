package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.HorsSolGame;

public class WelcomeScreen extends ScreenAdapter {

    HorsSolGame game;

    ShapeRenderer shapeRenderer = new ShapeRenderer();

    public WelcomeScreen(HorsSolGame game) {
        this.game = game;

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

        Label.LabelStyle labelStyleTitle = new Label.LabelStyle();
        BitmapFont fontTitle = new BitmapFont();
        fontTitle.getData().setScale(5);
        labelStyleTitle.font = fontTitle;
        //labelStyleTitle.fontColor = Color.RED;//rgba4444(Color.RED,Color.GREEN,#05468,#45869);
        Label.LabelStyle labelStyleSimple = new Label.LabelStyle();
        BitmapFont fontSimple = new BitmapFont();
        fontSimple.getData().setScale(2.5f);
        labelStyleSimple.font = fontSimple;

        Label labelTitle = new Label("Week-end à la campagne",labelStyleTitle);
        labelTitle.setSize(100,30);
        labelTitle.setPosition(700,550);
        labelTitle.setAlignment(Align.center);


        Label labelEspace = new Label("Appuyez sur ESPACE",labelStyleSimple);
        labelEspace.setSize(100,30);
        labelEspace.setPosition(300,200);
        labelEspace.setAlignment(Align.center);

        game.getWelcomeStage().addActor(labelEspace);
        game.getWelcomeStage().addActor(labelTitle);



    }

    public void render(float delta) {
        Gdx.gl.glClearColor(.29f,0,.12f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = game.getBatch();
        BitmapFont font = game.getFont();

        game.getWelcomeStage().act();
        game.getWelcomeStage().draw();


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
