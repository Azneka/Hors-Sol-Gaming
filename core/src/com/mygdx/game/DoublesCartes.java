package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import javax.swing.*;
import java.util.ArrayList;


public class DoublesCartes extends Game {

    @Override
    public void create() {
        // Titre de la fenêtre
        Gdx.graphics.setTitle("Défi de doubles Cartes");
        setScreen(new MaGrilleScreen(this));




    }

    class MaGrilleScreen extends ScreenAdapter {

        private Stage stage,stage1; // la scène
        private ImageButton [] logos;
        private int NbPairesTrouvees;
        private ArrayList<Integer> CartesSelectionnees;
        private ImageButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11; //différentes images utilisées dans le jeu
        private int[] nCartes; // indice des différentes images
        private Table  table;


        public MaGrilleScreen(Game game) {
            stage = new Stage(); // création de la scème
            table = new Table(); // création de la table
            stage.addActor(table); // ajout de l'acteur "table" à la scene

            // Positionnement de la table
            table.setOriginX(0);
            table.setOriginY(0);
            table.setX(300);
            table.setY(300);

            //Initialiser les différents ImagesButton
            b0 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Arthena.jpg"))));
            b1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Arthena.jpg"))));
            b2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Askasai.jpg"))));
            b3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Askasai.jpg"))));
            b4 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Blackliste.png"))));
            b5 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Blackliste.png"))));
            b6 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Charliste.jpg"))));
            b7 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Charliste.jpg"))));
            b8 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Classics.jpg"))));
            b9 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Classics.jpg"))));
            b10 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Wizart.jpg"))));
            b11 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("CarteBlanche.png"))),
                    new TextureRegionDrawable(new TextureRegion(new Texture("Wizart.jpg"))));


            CartesSelectionnees = new ArrayList<>();
            NbPairesTrouvees=0;
            logos = new ImageButton[]{b0,b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11}; //tableau qui regroupe tous les ImagesButton
            nCartes = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};

            //associer à chaque boutton un indice
            for (int i = 0; i < logos.length; i++) {
                    logos[i].setName(String.valueOf(nCartes[i]));
            }


            // Ajout des boutons dans la table
            // dans la boucle qui suit, il y a qlq chose qui ne marche pas, le résultat n'est pas bon. j'ai utilisé la méthode répetetive
             /*int s=0;
            for(int j=0 ; j<3 ; j++){
                for (int i=0 ; i<4; i++){
                    table.add(logos[s]).space(5);
                    s=+1;
                }
                table.row();} */

            initialiseJeu(); //mélanger l'ordre de toutes les images
            table.add(logos[0]).space(5);
            table.add(logos[1]).space(5);
            table.add(logos[2]).space(5);
            table.add(logos[3]).space(5);
            table.row();
            table.add(logos[4]).space(5);
            table.add(logos[5]).space(5);
            table.add(logos[6]).space(5);
            table.add(logos[7]).space(5) ;
            table.row();
            table.add(logos[8]).space(5);
            table.add(logos[9]).space(5);
            table.add(logos[10]).space(5);
            table.add(logos[11]).space(5) ;

            ChangeListener c= new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                    if (CartesSelectionnees.size() < 2) {
                        CartesSelectionnees.add(Integer.parseInt(((ImageButton) actor).getName()));

                    }
                    if (CartesSelectionnees.size() == 2) {

                        if (CartesSelectionnees.get(0)== CartesSelectionnees.get(1)){ // on vérifie si les cartes sont pareilles
                            for ( ImageButton i : logos){
                                if (Integer.parseInt(i.getName())==CartesSelectionnees.get(0)){
                                    i.setVisible(false); //on supprime la paire d'images trouvées
                                }
                            }
                            NbPairesTrouvees+=1;
                            CartesSelectionnees.clear();
                        }
                        else{
                            CartesSelectionnees.clear();
                        }}
                    System.out.println(NbPairesTrouvees);
                }
            };
            for (ImageButton i : logos ){
                i.addListener(c);
            }
            Gagner(); // cette méthode ne marche pas , je ne sais pas pourquoi


        }

        public void initialiseJeu() {
            for (int i = 0; i < logos.length; i++) {
                    int hasard = (int) (Math.random() * (i));
                    ImageButton CaseGardee = logos[i];
                    logos[i] = logos[hasard];
                    logos[hasard]=CaseGardee;
                }
            }
        public void Gagner(){
            if ( NbPairesTrouvees==6){
                JOptionPane.showMessageDialog(null, "Félicitations", "Message", JOptionPane.OK_OPTION);
            }
        }







        @Override
        // Appelée quand on affiche ce Screen */
        public void show() {
            // On indique que les événements sont passés au stage : les listeners des éléments du stage seront bien appelés
            Gdx.input.setInputProcessor(stage);

        }

        @Override
        public void hide() {
            super.hide();
            // si on cré tout dans le show, il faudrait surement tout nettoyer ici plutôt que dans le dispose
        }

        @Override
        // Méthode appelée automatiquement régulièrement pour redessiner la fenêtre */
        public void render(float delta) {
            // Couleur de fond
            Gdx.gl.glClearColor(0.45f, 0.6f, 0.6f, 1f);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            // Dessin du stage
            stage.draw();
        }

        @Override
        public void dispose() {
            // Libération de la mémoire
            stage.dispose();
        }

    }
}
