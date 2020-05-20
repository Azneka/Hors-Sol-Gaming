package com.mygdx.game;


import com.badlogic.gdx.graphics.g2d.BitmapFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Puzzle extends JFrame {
    JFrame f = new JFrame();

    ImageIcon ic1,ic2,ic3,ic4,ic5,ic6,ic7,ic8,ic9;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;

    public Puzzle() {
        // Charger les différentes images
        ic1 = new ImageIcon("C:\\Users\\SALMA\\Documents\\CEPI\\1.jpg");
        b1 = new JButton(ic1);
        ic2 = new ImageIcon("C:\\Users\\SALMA\\Documents\\CEPI\\5.jpg");
        b2 = new JButton(ic2);
        ic3 = new ImageIcon("C:\\Users\\SALMA\\Documents\\CEPI\\2.jpg");
        b3 = new JButton(ic3);
        ic4 = new ImageIcon("C:\\Users\\SALMA\\Documents\\CEPI\\7.jpg");
        b4 = new JButton(ic4);
        ic5 = new ImageIcon("C:\\Users\\SALMA\\Documents\\CEPI\\4.jpg");
        b5 = new JButton(ic5);
        ic6 = new ImageIcon("C:\\Users\\SALMA\\Documents\\CEPI\\6.jpg");
        b6 = new JButton(ic6);
        ic7 = new ImageIcon("C:\\Users\\SALMA\\Documents\\CEPI\\8.jpg");
        b7 = new JButton(ic7);
        ic8 = new ImageIcon("C:\\Users\\SALMA\\Documents\\CEPI\\3.jpg");
        b8 = new JButton(ic8);
        ic9 = new ImageIcon("C:\\Users\\SALMA\\Documents\\CEPI\\9.jpg");
        b9 = new JButton(ic9);

        f.setTitle("Puzzle");
        f.setSize(500, 500);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.setLocationRelativeTo(null);

        //On définit le layout à utiliser sur le content pane
        //Trois lignes sur Trois colonnes
        f.setLayout(new GridLayout(3, 3));
        //On ajoute les boutons au content pane de la JFrame
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        f.getContentPane().add(b3);
        f.getContentPane().add(b4);
        f.getContentPane().add(b5);
        f.getContentPane().add(b6);
        f.getContentPane().add(b7);
        f.getContentPane().add(b8);
        f.getContentPane().add(b9);
        f.setVisible(true);
        b1.setBounds(10, 80, 100, 100);
        b2.setBounds(110, 80, 100, 100);
        b3.setBounds(210, 80, 100, 100);
        b4.setBounds(10, 180, 100, 100);
        b5.setBounds(110, 180, 100, 100);
        b6.setBounds(210, 180, 100, 100);
        b7.setBounds(10, 280, 100, 100);
        b8.setBounds(110, 280, 100, 100);
        b9.setBounds(210, 280, 100, 100);


        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    Icon i = b1.getIcon();
                    b1.setIcon(b2.getIcon());
                    b2.setIcon(i);
                }
                if (e.getSource() == b2) {
                    Icon i = b2.getIcon();
                    b2.setIcon(b3.getIcon());
                    b3.setIcon(i);
                }
                if (e.getSource() == b3) {
                    Icon i = b3.getIcon();
                    b3.setIcon(b6.getIcon());
                    b6.setIcon(i);
                }
                if (e.getSource() == b4) {
                    Icon i = b4.getIcon();
                    b4.setIcon(b5.getIcon());
                    b5.setIcon(i);
                }
                if (e.getSource() == b5) {
                    Icon i = b5.getIcon();
                    b5.setIcon(b6.getIcon());
                    b6.setIcon(i);
                }
                if (e.getSource() == b6) {
                    Icon i = b6.getIcon();
                    b6.setIcon(b9.getIcon());
                    b9.setIcon(i);
                }
                if (e.getSource() == b7) {
                    Icon i = b7.getIcon();
                    b7.setIcon(b8.getIcon());
                    b8.setIcon(i);
                }
                if (e.getSource() == b8) {
                    Icon i = b8.getIcon();
                    b8.setIcon(b9.getIcon());
                    b9.setIcon(i);
                }
                if (e.getSource() == b9) {
                    Icon i = b9.getIcon();
                    b9.setIcon(b8.getIcon());
                    b8.setIcon(i);
                }
                //Condition pour gagner
                if ((b1.getIcon() == ic1) && (b2.getIcon() == ic3)
                        && (b3.getIcon() == ic8) && (b4.getIcon() == ic5)
                        && (b6.getIcon() == ic6) && (b7.getIcon() == ic4)
                        && (b8.getIcon() == ic7) && (b5.getIcon() == ic2)
                        && (b9.getIcon() == ic9)) {

                    JOptionPane.showMessageDialog(null, "Félicitations", "Message", JOptionPane.OK_OPTION);
                }
            }
        };
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        b6.addActionListener(a);
        b7.addActionListener(a);
        b8.addActionListener(a);
        b9.addActionListener(a);



    }



}

