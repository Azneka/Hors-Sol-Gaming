package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ExempleDecoupageImage extends ApplicationAdapter {

    private static final int NB_LIGNES = 5;
    private static final int NB_COLONNES = 5;

    private SpriteBatch batch;
    private Texture img;
    private TextureRegion[][] pieces;
    private double largeurPieces;
    private double hauteurPiece;
    private int espacement;


    @Override
    public void create() {

        // Titre de la fenêtre
        Gdx.graphics.setTitle("Exemple de découpage d'une image");

        espacement = 10;
        batch = new SpriteBatch();
        // Chargement de l'image complète dans une Texture
        img = new Texture("badlogic.jpg");

        // Découpage en TextureRegion
        pieces = new TextureRegion[NB_LIGNES][NB_COLONNES];
        largeurPieces = img.getWidth() / (double) NB_COLONNES;
        hauteurPiece = img.getHeight() / (double) NB_LIGNES;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                pieces[i][j] = new TextureRegion(img, (int) (i * largeurPieces), (int) (j * hauteurPiece), (int) largeurPieces, (int) hauteurPiece);
            }
        }
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown (int x, int y, int pointer, int button) {
                System.out.println("clic en position "+x+", "+y);
                // Retrouver ensuite la pièce à partir des coordonnées, etc
                return true;
            }
        });
    }

    @Override
    public void render() {
        // Couleur de fond
        Gdx.gl.glClearColor(0.45f, 0.6f, 0.6f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Dessin  :  Attention au sens des axes
        batch.begin();
        double largeurTotale = NB_COLONNES * (largeurPieces + espacement) - espacement;
        double hauteurTotale = NB_LIGNES * (largeurPieces + espacement) - espacement;
        int x = (int) ((Gdx.graphics.getWidth() - largeurTotale) / 2);
        int y0 = (int) ((Gdx.graphics.getHeight() - hauteurTotale) / 2);
        int y;
        for (int i = 0; i < 5; i++) {
            y = y0;
            for (int j = 4; j >= 0; j--) {
                batch.draw(pieces[i][j], x, y);
                y += pieces[i][j].getRegionHeight() + espacement;
            }
            x += pieces[i][0].getRegionWidth() + espacement;
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
