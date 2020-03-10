/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containrs;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import main.Calcul;
import javax.swing.*;

/**
 *
 * @author Khalid <Khalid.Khalid at ldnr.fr>
 */
public class Fenetre extends JFrame {

    public Fenetre() {
        /**
         * Création de la fênetre principale
         *
         * Titre : Jeux d'enfant
         *
         */
        this.setTitle("Jeux d'enfant");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setSize(700, 700);

        /**
         * Création du Menu Bar
         *
         * Titre : Jeux d'enfant
         *
         */
        JMenuBar menuBar = new JMenuBar();
        //ceration du menu activite
        JMenu menuActivite = new JMenu("Activité");

        // ajout du racourci clavier ALT+A
        menuActivite.setMnemonic('A');

        //creation de l'item dessin
        JMenuItem dessin = new JMenuItem("Dessin");

        // ajout du raccourci clavier Ctrl+ lettre
        dessin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
                KeyEvent.CTRL_DOWN_MASK));

        menuActivite.add(dessin);

        JMenuItem jdm = new JMenuItem("Jeux de mot");
        // ajout du raccourci clavier Ctrl+ lettre
        jdm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,
                KeyEvent.CTRL_DOWN_MASK));
        menuActivite.add(jdm);

        JMenuItem calcul = new JMenuItem("Calcul");
        // ajout du raccourci clavier Ctrl+ lettre
        calcul.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                KeyEvent.CTRL_DOWN_MASK));
        menuActivite.add(calcul);

        JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
        JPanel pannel = new JPanel();

        JPanel onglet1 = new JPanel();
        FenetreCalcul fc = new FenetreCalcul();
        onglet1.add(fc);
        onglet1.setPreferredSize(new Dimension(700, 700));

        Dessin fd = new Dessin();
        JPanel onglet2 = new JPanel();
        onglet2.add(fd);
        onglet2.setPreferredSize(new Dimension(700, 700));

        JPanel onglet3 = new JPanel();
        FenetreCalcul2 fc2 = new FenetreCalcul2();
        onglet3.add(fc2);
        onglet3.setPreferredSize(new Dimension(700, 700));

        JPanel onglet4 = new JPanel();
        OngletJeuxDeMots2 ojdm = new OngletJeuxDeMots2();
        onglet4.add(ojdm);
        onglet4.setPreferredSize(new Dimension(700, 700));
        onglets.setOpaque(true);
        pannel.add(onglets);
        this.getContentPane().add(pannel);

        onglets.addTab("calcul", onglet1);
        onglets.addTab("Dessins", onglet2);
        onglets.addTab("Calcul2", onglet3);
        onglets.addTab("JeuxDeMots", onglet4);

        JMenu menuLvl = new JMenu("Niveaux");
        // ajout du racourci clavier ALT+N
        menuLvl.setMnemonic('N');

        JMenuItem lvl1 = new JMenuItem("Niveau 1");
        lvl1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
                KeyEvent.CTRL_DOWN_MASK));
        menuLvl.add(lvl1);
        JMenuItem lvl2 = new JMenuItem("Niveau 2");
        lvl2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
                KeyEvent.CTRL_DOWN_MASK));
        menuLvl.add(lvl2);

        JMenu menuAdmin = new JMenu("Administration");

        JMenuItem connect = new JMenuItem("Se connecter");
        menuAdmin.add(connect);

        connect.addActionListener(new ActionListener() { // classe anonyme interne implémentant ActionListener
            @Override
            public void actionPerformed(ActionEvent e) { // Action à effectuer quand survient l’évènement
                ConnexionAdmin c = new ConnexionAdmin();
            }
        });

        //ajout d'une ligne de sepatation entre les deux items (se connecter et modifier le mot de passe)
        menuAdmin.addSeparator();

        JMenuItem modifpass = new JMenuItem("Modifier mot de passe");
        menuAdmin.add(modifpass);

        modifpass.addActionListener(new ActionListener() { // classe anonyme interne implémentant ActionListener
            @Override
            public void actionPerformed(ActionEvent e) { // Action à effectuer quand survient l’évènement
                ChangePassword c = new ChangePassword();
            }
        });

        menuBar.add(menuActivite);
        menuBar.add(menuLvl);
        menuBar.add(menuAdmin);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }
}
