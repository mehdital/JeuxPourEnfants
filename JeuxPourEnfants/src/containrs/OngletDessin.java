/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containrs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.sound.sampled.Control.Type;
import javax.swing.JButton;

import javax.swing.JColorChooser;

import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * Classe dessin elle permet de dessiner avec un panel de couleur, et different
 * taille de pinceau.
 *
 * Pour la taille du pinceau on utilise une string, cela permet de générer
 * plusieur taille de pinceau. Pour dessiner on utilise la classe Graphics.
 *
 * @author alixia
 */
public class OngletDessin extends JPanel {

    JPanel dessin = new JPanel();

    // création de la barre d'outil
    JToolBar jToolBar = new JToolBar();

    int x = 0, y = 0;
    // Type utilise pour les conditions
    String type = "point";

    private Color couleur = Color.BLACK;
    private JColorChooser chooser = new JColorChooser();

    // création des boutons utilise à la barre d'outils
    JButton affichageCouleur = new JButton();
    JButton bouttonEffacer = new JButton("effacer");
    JButton bouttonCouleur = new JButton("couleur");
    JButton bouttonRond = new JButton("rond");
    JButton bouttonCarre = new JButton("carré");
    JButton bouttonTrait = new JButton("trait");

    // création du graphic
    Graphics g;

    public OngletDessin() {

        // parametre pour l'affichage du panel
        // disposition sur la panel , dimension du dessin centrer sur le panel
        this.setLayout(new BorderLayout());
        this.add(dessin, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(725, 725));


        // ajout des boutons sur la barre d'outil
        jToolBar.add(bouttonEffacer);
        jToolBar.add(bouttonCouleur);
        jToolBar.add(affichageCouleur);
        jToolBar.add(bouttonRond);
        jToolBar.add(bouttonCarre);
        jToolBar.add(bouttonTrait);

        // le panel dessin a un fond blanc
        dessin.setBackground(Color.white);

        /**
         * l'on met un écouteur sur le panel de la classe.
         *
         * On écoute le click de la souris, on écoute le mouvement de la souris.
         * Si le type est égale au string initialisé via les boutons ( plus bas
         * ).
         *
         * L'on dessine avec un ovale plein ou un carré plein l'abscisse et
         * l'ordonnées sont à zéro pour que le point puisse démarrer du premier
         * traçage de la souris.
         *
         */
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                if (type.equals("rond")) {
                    g.fillOval(x, y, 15, 15);
                } else if (type.equals("carre")) {
                    g.fillRect(x, y, 5, 5);
                }
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                g = dessin.getGraphics();
                g.setColor(couleur);
                if (type.equals("rond")) {
                    g.fillOval(x, y, 15, 15);
                } else if (type.equals("carre")) {
                    g.fillRect(x, y, 5, 5);
                } else {
                    g.drawLine(x, y, e.getX(), e.getY());

                }
                x = e.getX();
                y = e.getY();
            }
        });
        /**
         * mise en place de la palette de couleur, pour choisir la couleur du
         * pinceau.
         *
         * couleur est de la classe Color. couleur est égale a la couleur choisi
         * le bouton affichageCouleur contient la palette
         *
         */

        bouttonCouleur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                couleur = JColorChooser.showDialog(chooser,
                        "Choisi ta couleur", couleur);
                affichageCouleur.setBackground(couleur);
            }
        });

        /**
         * Effacer la fenetre.
         *
         * On rénitialise la string a point pour avoir le tracer de base et on
         * repaint pour rénitialiser le graphic.
         *
         */
        bouttonEffacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = "point";
                repaint();

            }
        });

        /**
         * changement du pinceau.
         *
         * pour trait rond, carre, et classique on modifie simplement le string.
         * Cela permet d'être utilisé dans les conditions des écouteurs de
         * souris
         */
        //trait rond
        bouttonRond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                type = "rond";
            }
        });

        //trait carre
        bouttonCarre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                type = "carre";
            }
        });

        // trait classique
        bouttonTrait.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                type = "point";
            }
        });

        // position de la barre de menu en bas du panel
        this.add(jToolBar, BorderLayout.SOUTH);

    }

}
