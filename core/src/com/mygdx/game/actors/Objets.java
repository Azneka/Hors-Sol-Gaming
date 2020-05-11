package com.mygdx.game.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.screens.MainGameScreen;

public class Objets extends Actor {


    boolean ramassable;
    MainGameScreen mainGameScreen;

    Objets() {

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

        } else {

        }

    }

    public void interagirAvecObjet(Objets objet) {

    }

}
