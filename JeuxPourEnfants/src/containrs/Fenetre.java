/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containrs;

import java.awt.BorderLayout;
import java.awt.PopupMenu;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Khalid <Khalid.Khalid at ldnr.fr>
 */
public class Fenetre extends JFrame {

    public Fenetre() {
        
        this.setTitle("Jeux d'enfant");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(600, 600);
        this.setVisible(true);
        

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Activité");
        menu.add(new JMenuItem("Déssin"));
        menu.add(new JMenuItem("Jeux de mots"));
        menu.add(new JMenuItem("Calcul"));

        JMenu menu2 = new JMenu("Niveaux");
        menu2.add(new JMenuItem("Niveau 1"));
        menu2.add(new JMenuItem("Niveau 2"));

        JMenu menu3 = new JMenu("Administration");

        menuBar.add(menu);
        menuBar.add(menu2);
        menuBar.add(menu3);

        this.setJMenuBar(menuBar);
       
       

    }

}
