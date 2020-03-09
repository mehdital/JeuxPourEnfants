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
import javax.swing.JButton;

import javax.swing.JColorChooser;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author alixia
 */
public class Dessin extends JPanel {

    JPanel dessin = new JPanel();

    JToolBar jToolBar = new JToolBar();

    int x = 0, y = 0;

    private Color couleur = Color.BLACK;
    private JColorChooser chooser = new JColorChooser();

    JButton affichageCouleur = new JButton();
    JButton bouttonEffacer = new JButton("effacer");
    JButton bouttonCouleur = new JButton("couleur");
    //JButton bouttonForme = new JButton("forme");

    public Dessin() {
        dessin.setBackground(Color.white);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();

            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = dessin.getGraphics();
                g.setColor(couleur);
                g.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();

            }
        });

        this.setLayout(new BorderLayout());
        this.add(dessin, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(600, 600));

        bouttonCouleur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                couleur = JColorChooser.showDialog(chooser,
                        "Choisi ta couleur", couleur);
                affichageCouleur.setBackground(couleur);
            }
        });

        bouttonEffacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();

            }
        });

        jToolBar.add(bouttonEffacer);
        jToolBar.add(bouttonCouleur);
        jToolBar.add(affichageCouleur);
        // jToolBar.add(bouttonForme);

        this.add(jToolBar, BorderLayout.SOUTH);

    }

}
