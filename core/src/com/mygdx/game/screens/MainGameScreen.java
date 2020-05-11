package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.HorsSolGame;

public class MainGameScreen extends ScreenAdapter {

    HorsSolGame game;
    Stage gameStage;
    Camera gameCamera;
    Texture img;
    boolean win;
    int speed=4;
    int x;
    int y;

    public MainGameScreen(HorsSolGame game) {
        this.game = game;

        ScreenViewport viewport = game.getViewport();
        gameStage = new Stage(viewport);
        gameCamera = new OrthographicCamera(game.getGameWorldWidth(),game.getGameWorldHeight()); //création d'une caméra
        //((OrthographicCamera) gameCamera).setToOrtho(false,800,400);
        gameCamera.translate(gameCamera.viewportWidth/2,gameCamera.viewportHeight/2,0); //Par défaut, le coin bas gauche de la caméra se cale sur le centre du viewport, il faut donc translater la caméra.
    }

    @Override
    public void show() {
        img = new Texture("perso1.png");
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(.29f, 0, .12f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = game.getBatch();
        Sprite sprite = game.getSprite();
        gameCamera.update();
        batch.begin();
        batch.setProjectionMatrix(gameCamera.combined);
        sprite.draw(batch);
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y+=speed;
        } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y-=speed;//speed*delta;
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x-=speed;//speed*delta;
        } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x+=speed;//speed*delta;
        }
        batch.draw(img, x, y);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void victoire() {
        if(win==true) {
            game.setScreen(new EndScreen(game));
        }
    }


}
