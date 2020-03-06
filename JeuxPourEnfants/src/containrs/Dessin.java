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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author alixia
 */
public class Dessin extends JPanel {

    JPanel primaire = new JPanel();
    JPanel secondaire = new JPanel();
    int x = 0, y = 0;
    JLabel label = new JLabel();
    JPanel dessin = new JPanel();
    String pointerType = "CIRCLE";

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
                g.setColor(Color.red);
                g.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();

            }
        });

        this.setLayout(new BorderLayout());

        this.add(label, BorderLayout.SOUTH);

        this.add(dessin, BorderLayout.CENTER);
        
        this.setPreferredSize(new Dimension(650, 650));

        //barre d'outil
        JToolBar jToolBar = new JToolBar();
        JButton effacer = new JButton("effacer");
        effacer.addActionListener(new MonEcouteurDessin());
        JButton couleur = new JButton("couleur");
        couleur.addActionListener(new MonEcouteurDessin());
        JButton forme = new JButton("forme");
        forme.addActionListener(new MonEcouteurDessin());

        couleur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

        jToolBar.add(effacer);
        jToolBar.add(couleur);
        jToolBar.add(forme);
        couleur.setPreferredSize(new Dimension(80, 30));

        this.add(jToolBar, BorderLayout.SOUTH);

    }

}