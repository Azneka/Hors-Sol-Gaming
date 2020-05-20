package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.screens.MainGameScreen;

public class Objet extends Actor {

    boolean ramassable;
    Texture texture;
    MainGameScreen mainGameScreen;

    public Objet(boolean ramassable, Texture texture) {
        this.ramassable = ramassable;
        this.texture = texture;
    }

    public Button buttonAssocie(Texture texture) {
        //Sprite sprite = new Sprite(texture);
        //sprite.setPosition(getX(),getY());
        //sprite.draw(mainGameScreen.getGame().getBatch());
        Drawable drawable = new TextureRegionDrawable(new TextureRegion(texture));
        Button button = new Button(drawable);
        return button;
    }

    public void interagirObjet() {
        if(ramassable==false) {

        } else {

        }

    }

    public void observerObjet(String texteObservation) {

    }

    public void ramasserObjet() {
        if(ramassable==true) {
            if(true) {
                addAction(Actions.removeActor());
                Stage gameStage = mainGameScreen.getGameStage();




            }

        } else {
            interagirObjet();
        }

    }

    public void interagirAvecObjet(Objet objet) {

    }

    public Texture getTexture() { return texture; }


}
