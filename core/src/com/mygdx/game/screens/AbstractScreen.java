//package com.mygdx.game.screens;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import javafx.stage.Stage;
//
//public abstract class AbstractScreen extends Stage implements Screen {
//
//    protected abstract void buildStage();
//
//    public  void render(float delta) {
//
//        Gdx.gl.glClearColor(1,0,0,1); //Nettoie l'écran
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        //super.act(delta);
//        //super.draw();
//
//    }
//
//    @Override
//    //public void show() {
//      //  Gdx.input.setInputProcessor(this);
//
//    //}
//
//    public void resize() {
//        resize(400,400);
//    }
//
//    @Override
//    //public void show() {
//      //  Gdx.input.setInputProcessor(this);
//
//    //}
//
//    public void resize(int width, int height) {
//        //getViewport().update(width,height,true);
//    }
//
//
//}
