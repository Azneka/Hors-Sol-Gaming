package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.HorsSolGame;
import com.mygdx.game.actors.Inventaire;
import com.mygdx.game.actors.Objet;

public class MainGameScreen extends ScreenAdapter {

    HorsSolGame game;
    Stage gameStage;
    Camera gameCamera;
    Sprite background;
    Texture perso;
    Inventaire inventaire = new Inventaire(this,10);
    boolean win;
    int speed=4;
    int x=400;
    int y=400;

    public MainGameScreen(HorsSolGame game) {
        this.game = game;

        ScreenViewport viewport = game.getViewport();
        gameStage = new Stage(viewport);
        gameCamera = new OrthographicCamera(game.getGameWorldWidth(),game.getGameWorldHeight()); //création d'une caméra
        //((OrthographicCamera) gameCamera).setToOrtho(false,800,400);
        gameCamera.translate(gameCamera.viewportWidth/2,gameCamera.viewportHeight/2,0); //Par défaut, le coin bas gauche de la caméra se cale sur le centre du viewport, il faut donc translater la caméra.
        Gdx.input.setInputProcessor(gameStage);

    }

    @Override
    public void show() {


        background = new Sprite(new Texture(Gdx.files.internal("salleBDE.png")));
        background.setSize(game.getGameWorldWidth(),game.getGameWorldHeight());
        perso = new Texture("perso1.png");



        Actor zoneInventaire = inventaire.createInventory();
        //Objet bobCharliste = new Objet(true,new Texture("chapeauCharliste.png"));
        //gameStage.addActor(bobCharliste);
        //inventaire.ajouterObjet(bobCharliste);

        gameStage.addActor(zoneInventaire);


    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(.29f, 0, .12f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = game.getBatch();
        gameCamera.update();

        batch.begin();
        background.draw(batch);
        moveCharacter(perso);
        batch.draw(perso,x,y);

        batch.setProjectionMatrix(gameCamera.combined);

        gameStage.act(Gdx.graphics.getDeltaTime());
        gameStage.draw();


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

    public void moveCharacter(Texture perso) {
        SpriteBatch batch = game.getBatch();
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y+=speed;
        } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y-=speed;//speed*delta;
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x-=speed;//speed*delta;
        } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x+=speed;//speed*delta;
            //perso.addAction(Actions.moveTo(x+=speed,y));
            //perso.setPosition(x+speed,y);
            //perso.setX(x+speed);
        }

    }

    public Stage getGameStage() { return gameStage; }
    public HorsSolGame getGame() { return game; }


}
