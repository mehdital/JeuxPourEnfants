/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containrs;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

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
        JMenuItem dessin = new JMenuItem("Déssin");

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
        menuAdmin.add(new JMenuItem("Se connecter"));

        //ajout d'une ligne de sepatation entre les deux items (se connecter et modifier le mot de passe)
        menuAdmin.addSeparator();
        menuAdmin.add(new JMenuItem("Modifier mot de passe"));

        menuBar.add(menuActivite);
        menuBar.add(menuLvl);
        menuBar.add(menuAdmin);

        initGUI();

        this.setJMenuBar(menuBar);
        this.setVisible(true);

    }

    private void initGUI() {
        JPanel global = new JPanel();
        GridLayout gl = new GridLayout();
        global.setLayout(gl);
        global.add(new FenetreCalcul());
        this.add(global);

    }

}
