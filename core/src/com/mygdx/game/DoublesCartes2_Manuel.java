package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import java.util.ArrayList;

public class DoublesCartes2_Manuel  extends Game {

    @Override
    public void create() {

        // Titre de la fenêtre
        Gdx.graphics.setTitle("Exemple de découpage d'une image");
        // Version 1 : dessin et positionnement manuel
        setScreen(new ImageDecoupeeScreens());

        // Version 2 : utilisation d'une table
        //setScreen(new MaGrilleScreen(this));
    }
}

// Pour la version Manuelle, représente une pièce dessinée
class Pieces {

    TextureRegion region1,region2; // Image de la pièce
    boolean visible = true;
    float x, y; // position

    public Pieces(TextureRegion region,TextureRegion regionn, boolean visible, float x, float y) {
        this.region1 = region;
        this.region2 = regionn;
        this.visible = visible;
        this.x = x;
        this.y = y;
    }

    /**
     * Indique si la pièce contient le point (x,y) issu d'un clic
     */
    boolean contains(float x, float y) {
        y = Gdx.graphics.getHeight() - y;
        return x >= this.x && x <= this.x + this.region1.getRegionWidth() && y >= this.y && y <= this.y + this.region1.getRegionHeight();
    }
}

/**
 * Screen en version dessin manuel : ressemble à la première version envoyée pour le découpage d'une image
 * Ajout de la gestion du clic qui masque l'image.
 */
class ImageDecoupeeScreens extends ScreenAdapter {

    private static final int NB_LIGNES =5;
    private static final int NB_COLONNES = 5;

    private SpriteBatch batch;
    private Texture img1,img2,img3,img4,img5,img6,imgChecked;
    private Pieces[] piece;
    private ArrayList<TextureRegion> CartesRetournees;

    public ImageDecoupeeScreens() {
        int espacement = 5;
        batch = new SpriteBatch();
        // Chargement de l'image complète dans une Texture
        img1 = new Texture("Arthena.jpg");
        img2 = new Texture("Askasai.jpg");
        img3 = new Texture("Blackliste.png");
        img4 = new Texture("Charliste.jpg");
        img5 = new Texture("Classics.jpg");
        img6 = new Texture("Wizart.jpg");
        imgChecked = new Texture("CarteBlanche.png");
        Texture [] img= {img1,img2,img3,img4,img5,img6,img1,img2,img3,img4,img5,img6,img1,img2,img3,img4};
        piece = new Pieces[NB_LIGNES * NB_COLONNES];
        double largeurPiece = 3*(img1.getWidth() / (double) NB_COLONNES);
        double hauteurPiece = 3*(img1.getHeight()/ (double) NB_LIGNES);
        double largeurTotale = NB_COLONNES * (largeurPiece + espacement) - espacement;
        double hauteurTotale = NB_LIGNES * (hauteurPiece + espacement) - espacement;
        int x = (int) ((Gdx.graphics.getWidth() - largeurTotale) / 2);
        int y0 = (int) (Gdx.graphics.getHeight() - (Gdx.graphics.getHeight() - hauteurTotale) / 2);
        int y;
        for (int i = 0; i < NB_COLONNES; i++) {
            y = y0;
            for (int j = 0; j < NB_LIGNES; j++) {
                piece[i + j * NB_COLONNES] = new Pieces(new TextureRegion(img[6], (int) (i * largeurPiece), (int) (j * hauteurPiece), (int) largeurPiece, (int) hauteurPiece), new TextureRegion(imgChecked, (int) (i * largeurPiece), (int) (j * hauteurPiece), (int) largeurPiece, (int) hauteurPiece),true, x, y);
                /* je ne comprends pas si j'essaye avec  piece[i + j * NB_COLONNES] = new Pieces(new TextureRegion(img[i + j * NB_COLONNES]....
                ça ne marche pas. le but c'est que pour chaque case, j'aurais une image du tableau img */
                y -= hauteurPiece + espacement;
            }
            x += largeurPiece + espacement;
        }
        // gestion du clic qui masque l'image cliquée
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int x, int y, int pointer, int button) {
                for (Pieces p : piece) {
                    if (p.contains(x, y)) {
                        //p.visible = !p.visible;
                        p.region1 = p.region2 ;



                    }
                }
                return true;
            }
        });
    }

    @Override
    /** Méthode appelée automatiquement et régulièrement pour redessiner la fenêtre */
    public void render(float delta) {
        // Couleur de fond
        Gdx.gl.glClearColor(0.45f, 0.6f, 0.6f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        // dessin de toutes les pièces visibles
        for (Pieces p : piece) {
            if (p != null && p.visible) {
                batch.draw(p.region1, p.x, p.y);

            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img1.dispose();
        img2.dispose();
        img3.dispose();
        img4.dispose();
        img5.dispose();
        img6.dispose();
    }
}


