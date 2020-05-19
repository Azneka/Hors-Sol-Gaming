package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Felicitations extends ApplicationAdapter {

    private Texture texture;
    private SpriteBatch batch;
    private BitmapFont fontmessage;
    private String message;

public Felicitations(){

}
    @Override
    public void create() {
        fontmessage = new BitmapFont();
        batch = new SpriteBatch();
        message = "Félicitations, Tu as Gagné";
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        fontmessage.draw(batch, message, 10, 30);
        batch.end();
    }
}
