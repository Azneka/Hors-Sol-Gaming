package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.HorsSolGame;
import com.mygdx.game.screens.MainGameScreen;

public class Inventaire {

    MainGameScreen mainGameScreen;
    Button[] actors;
    boolean[] placesOccupees;
    int nbrPlaces;

    public Inventaire(MainGameScreen mainGameScreen,int nbrPlaces) {
        this.mainGameScreen = mainGameScreen;
        this.nbrPlaces = nbrPlaces;
        actors = new Button[nbrPlaces];

    }

    public Button createInventory() {
        Skin skinTable = new Skin(Gdx.files.internal("skin/craftacular/craftacular-ui.json"));
        Table tableInventaire = new Table(skinTable);
        HorsSolGame game = mainGameScreen.getGame();
        float gameWorldWidth = game.getGameWorldWidth();
        tableInventaire.setSize(gameWorldWidth,150);
        mainGameScreen.getGameStage().addActor(tableInventaire);

        Button buttonTable = new Button(skinTable);
        buttonTable.setSize(gameWorldWidth,150);

        tableInventaire.setPosition(200,150, Align.center);
        return buttonTable;
    }

    public void ajouterObjet(Objet objet) {
        Stage gameStage = mainGameScreen.getGameStage();
        float actorWidth = mainGameScreen.getGame().getGameWorldWidth()/10;
        float actorHeight = 100;
        int j = 0;
        int i = 0;
        while(j==0 && i<nbrPlaces) {
            if(!placesOccupees[i]) {
                actors[i] = objet.buttonAssocie(objet.getTexture());
                j++;
                setOccupee(i);
                actors[i].setPosition((1+i)*(actorWidth/2),actorHeight/2);
                //actors[i].spriteAssocie(objet.getTexture());
            }
            i++;
        }

    }

    public void prendreObjet(Objet objet) {

    }

    public void placerInventaire() {
        float actorWidth = mainGameScreen.getGame().getGameWorldWidth()/10;
        float actorHeight = 100;
        for(int i = 0;i<nbrPlaces;i++) {
            //actors[i].setSize(actorWidth,actorHeight);
            actors[i].setPosition((1+i)*(actorWidth/2),actorHeight/2);
        }
        //return actors;

    }

    public void setOccupee(int i) {
        placesOccupees[i] = true;
    }





}
