package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

// La classe de type Game
public class ExempleGameAvecScreens extends Game {

    @Override
    public void create() {

        // Titre de la fenêtre
        Gdx.graphics.setTitle("Exemple de découpage d'une image");
        // Version 1 : dessin et positionnement manuel
        // setScreen(new ImageDecoupeeScreen());

        // Version 2 : utilisation d'une table
        setScreen(new MaGrilleScreen(this));
    }
}

// Pour la version Manuelle, représente une pièce dessinée
class Piece {

    TextureRegion region; // Image de la pièce
    boolean visible = true;
    float x, y; // position

    public Piece(TextureRegion region, boolean visible, float x, float y) {
        this.region = region;
        this.visible = visible;
        this.x = x;
        this.y = y;
    }

    /**
     * Indique si la pièce contient le point (x,y) issu d'un clic
     */
    boolean contains(float x, float y) {
        y = Gdx.graphics.getHeight() - y;
        return x >= this.x && x <= this.x + this.region.getRegionWidth() && y >= this.y && y <= this.y + this.region.getRegionHeight();
    }
}

/**
 * Screen en version dessin manuel : ressemble à la première version envoyée pour le découpage d'une image
 * Ajout de la gestion du clic qui masque l'image.
 */
class ImageDecoupeeScreen extends ScreenAdapter {

    private static final int NB_LIGNES = 5;
    private static final int NB_COLONNES = 5;

    private SpriteBatch batch;
    private Texture img;
    private Piece[] pieces;

    public ImageDecoupeeScreen() {
        int espacement = 10;
        batch = new SpriteBatch();
        // Chargement de l'image complète dans une Texture
        img = new Texture("badlogic.jpg");
        pieces = new Piece[NB_LIGNES * NB_COLONNES];
        double largeurPiece = img.getWidth() / (double) NB_COLONNES;
        double hauteurPiece = img.getHeight() / (double) NB_LIGNES;
        double largeurTotale = NB_COLONNES * (largeurPiece + espacement) - espacement;
        double hauteurTotale = NB_LIGNES * (hauteurPiece + espacement) - espacement;
        int x = (int) ((Gdx.graphics.getWidth() - largeurTotale) / 2);
        int y0 = (int) (Gdx.graphics.getHeight() - (Gdx.graphics.getHeight() - hauteurTotale) / 2);
        int y;
        for (int i = 0; i < NB_COLONNES; i++) {
            y = y0;
            for (int j = 0; j < NB_LIGNES; j++) {
                pieces[i + j * NB_COLONNES] = new Piece(new TextureRegion(img, (int) (i * largeurPiece), (int) (j * hauteurPiece), (int) largeurPiece, (int) hauteurPiece), true, x, y);
                y -= hauteurPiece + espacement;
            }
            x += largeurPiece + espacement;
        }
        // gestion du clic qui masque l'image cliquée
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int x, int y, int pointer, int button) {
                for (Piece p : pieces) {
                    if (p.contains(x, y)) {
                        p.visible = !p.visible;
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
        for (Piece p : pieces) {
            if (p != null && p.visible) {
                batch.draw(p.region, p.x, p.y);
            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}


/**
 * Screen utilisant une scene2D
 */
class MaGrilleScreen extends ScreenAdapter {

    private static final int NB_LIGNES = 5;
    private static final int NB_COLONNES = 5;

    private Stage stage; // la scène
    private Texture img; // l'image complète qui sera découpée mais on pourrait avoir une image différente par bouton
    private Texture imgChecked; // image utilisée quand le bouton est checké

    public MaGrilleScreen(Game game) {
        stage = new Stage(); // création d ela scème
        Table table = new Table(); // création de la table
        stage.addActor(table); // ajout de l'acteur "table" à la scene

        // Positionnement de la table
        table.setOriginX(0);
        table.setOriginY(0);
        table.setX(300);
        table.setY(300);

        // Chargement des images
        img = new Texture("badlogic.jpg");
        imgChecked = new Texture("zeldapixel.png");

        // Toujours le même découpage
        double largeurPiece = img.getWidth() / (double) NB_COLONNES;
        double hauteurPiece = img.getHeight() / (double) NB_LIGNES;
        // Ajout des boutons dans la table
        for (int i = 0; i < NB_LIGNES; i++) {
            for (int j = 0; j < NB_COLONNES; j++) {
                final ImageButton button;
                // création du bouton avec les images up, down et checked (up et down sont les même ici, on pourrait optimiseer...
                button = new ImageButton(new TextureRegionDrawable(new TextureRegion(img, (int) (i * hauteurPiece),
                        (int) (j * largeurPiece), (int) largeurPiece, (int) hauteurPiece)),
                        new TextureRegionDrawable(new TextureRegion(img, (int) (i * hauteurPiece),
                                (int) (j * largeurPiece), (int) largeurPiece, (int) hauteurPiece)),
                        new TextureRegionDrawable(new TextureRegion(imgChecked, (int) (i * hauteurPiece),
                                (int) (j * largeurPiece), (int) largeurPiece, (int) hauteurPiece))
                );
                table.add(button).space(10);
                button.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        System.out.println("Changement d'état du bouton , checked = " + ((ImageButton) actor).isChecked());
                    }
                });
            }
            table.row(); // on passe à la ligne
        }
    }

    @Override
    /** Appelée quand on affiche ce Screen */
    public void show() {
        // On indique que les événements sont passés au stage : les listeners des éléments du stage seront bien appelés
        Gdx.input.setInputProcessor(stage);
        // on pourrit aussi choisir de plutôt faire ici ce qui est dans le constructeur : à voir si le Screen doit rester en
        // mémoire toute la durée du jeu ou pas
    }

    @Override
    public void hide() {
        super.hide();
        // si on cré tout dans le show, il faudrait surement tout nettoyer ici plutôt que dans le dispose
    }

    @Override
    /** Méthode appelée automatiquement régulièrement pour redessiner la fenêtre */
    public void render(float delta) {
        // Couleur de fond
        Gdx.gl.glClearColor(0.45f, 0.6f, 0.6f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //stage.act(delta); // qui appelle un act sur tous les acteurs, qui les mets à jours si nécessaire, inutile ici
        // car ils ne changent pas de position etc.
        // Dessin du stage
        stage.draw();
    }

    @Override
    public void dispose() {
        // Libération de la mémoire
        stage.dispose();
        img.dispose();
        imgChecked.dispose();
    }
}

