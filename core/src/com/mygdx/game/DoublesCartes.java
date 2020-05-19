package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;


public class DoublesCartes extends Game {

    @Override
    public void create() {
        // Titre de la fenêtre
        Gdx.graphics.setTitle("Défi de doubles Cartes");
        setScreen(new MaGrilleScreen(this));




    }

    class MaGrilleScreen extends ScreenAdapter {

        private static final int NB_LIGNES = 5;
        private static final int NB_COLONNES = 5;

        private Stage stage; // la scène
        private Texture img1,img2,img3,img4,img5,img6; // les différentes images utilisées pour le jeu
        private Texture imgChecked; // image utilisée quand le bouton est checké
        private Texture [] logos={img1, img1, img2, img2, img3, img3, img4, img4, img5, img5, img6, img6,img1, img1, img2, img2};;
        private int NbPairesTrouvees=0;
        private ArrayList<ImageButton> CartesRetournees;
        private ArrayList<ImageButton> Bouttons;



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
            img1 = new Texture("Arthena.jpg");
            img2 = new Texture("Askasai.jpg");
            img3 = new Texture("Blackliste.png");
            img4 = new Texture("Charliste.jpg");
            img5 = new Texture("Classics.jpg");
            img6 = new Texture("Wizart.jpg");
            imgChecked = new Texture("CarteBlanche.png");

            CartesRetournees= new ArrayList();

            int largeurPiece = 100;
            int hauteurPiece = 100;

            // Ajout des boutons dans la table
            for (int i = 0; i < NB_LIGNES; i++) {
                for (int j = 0; j < NB_COLONNES; j++) {
                    for (int k = 0; k < (NB_COLONNES+NB_LIGNES); k++){


                    Bouttons.add(new ImageButton(new TextureRegionDrawable(new TextureRegion(imgChecked, i* hauteurPiece,
                            j * largeurPiece, largeurPiece,  hauteurPiece)),null,
                            new TextureRegionDrawable(new TextureRegion(logos[k], i * hauteurPiece,
                                    j * largeurPiece,  largeurPiece,  hauteurPiece)))
                    );
                    // j'ai une erreur que je ne comprends pas
                    table.add(Bouttons.get(k)).space(5);
                        Bouttons.get(k).addListener(new ChangeListener() {
                        @Override
                        public void changed(ChangeEvent event, Actor actor) {
                            if (((ImageButton) actor).isChecked() == true) {
                                CartesRetournees.add(((ImageButton) actor));
                                System.out.println(CartesRetournees);
                            }}});

                    }

                }}
                table.row();




            }

ChangeListener a=new ChangeListener() {
    @Override
    public void changed(ChangeEvent event, Actor actor) {
        if (((ImageButton) actor).isChecked() == true) {
            CartesRetournees.add(((ImageButton) actor));
            System.out.println(CartesRetournees);
        }}};



        public void initialiseJeu() {
            for (int i = 0; i < NB_LIGNES; i++) {
                for (int j = 0; j < NB_COLONNES; j++) {
                    int hasard = (int) (Math.random() * (NB_LIGNES));
                    Texture CaseGardee = logos[i];
                    logos[i] = logos[hasard];
                    logos[hasard]=CaseGardee;
                }
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
            img1.dispose();
            img2.dispose();
            imgChecked.dispose();
        }

    }
}
