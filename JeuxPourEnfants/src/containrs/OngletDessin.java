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
 *
 * @author alixia
 */
public class OngletDessin extends JPanel {

    JPanel dessin = new JPanel();

    JToolBar jToolBar = new JToolBar();

    int x = 0, y = 0;
    // ype utilise pour les conditions
    String type = "point";

    private Color couleur = Color.BLACK;
    private JColorChooser chooser = new JColorChooser();

    JButton affichageCouleur = new JButton();
    JButton bouttonEffacer = new JButton("effacer");
    JButton bouttonCouleur = new JButton("couleur");
    JButton bouttonRond = new JButton("rond");
    JButton bouttonCarre = new JButton("carré");
    JButton bouttonTrait = new JButton("trait");

    Graphics g;

    public OngletDessin() {

        this.setLayout(new BorderLayout());
        this.add(dessin, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(600, 600));

        jToolBar.add(bouttonEffacer);
        jToolBar.add(bouttonCouleur);
        jToolBar.add(affichageCouleur);
        jToolBar.add(bouttonRond);
        jToolBar.add(bouttonCarre);
        jToolBar.add(bouttonTrait);

        dessin.setBackground(Color.white);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();

                if (type.equals("rond")) {
                    g.fillOval(x, y, 15, 15);
                } else if (type.equals("carre")) {
                    g.fillRect(x, y, 10, 10);
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
                    g.fillRect(x, y, 10, 10);
                } else {
                    g.drawLine(x, y, e.getX(), e.getY());

                }
                x = e.getX();
                y = e.getY();
            }
        });

        //Choisir une couleur via JcolorChooser
        bouttonCouleur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                couleur = JColorChooser.showDialog(chooser,
                        "Choisi ta couleur", couleur);
                affichageCouleur.setBackground(couleur);
            }
        });

        //Effacer la fenetre
        bouttonEffacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = "point";
                repaint();

            }
        });

        // changement du pinceau
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

        this.add(jToolBar, BorderLayout.SOUTH);

    }

}
