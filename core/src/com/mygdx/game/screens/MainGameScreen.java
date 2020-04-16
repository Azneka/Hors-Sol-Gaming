package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.HorsSolGame;

public class MainGameScreen extends ScreenAdapter {

    HorsSolGame game;
    Texture img;
    int speed=4;
    int x;
    int y;

    public MainGameScreen(HorsSolGame game) {
        this.game = game;
    }

    @Override
    public void show() {
//        Gdx.Input.setInputProcessor(new InputAdapter() {
//            public void moveCharacter() {
//                if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
//                    y+=speed;
//                } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
//                    y-=speed;//speed*delta;
//                } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//                    x-=speed;//speed*delta;
//                } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//                    x+=speed;//speed*delta;
//                }
//            }
//        });


        img = new Texture("zeldapixel.png");
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(.29f, 0, .12f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = game.getBatch();
        batch.begin();

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


}
