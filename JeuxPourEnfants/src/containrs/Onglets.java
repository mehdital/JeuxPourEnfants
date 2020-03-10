/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containrs;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Mehdi Taleb mehdital@protonmail.com
 */
public class Onglets extends JFrame {

    public Onglets(Fenetre f) {

        JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
        JPanel pannel = new JPanel();

        JPanel onglet1 = new JPanel();
        OngletCalcul fc = new OngletCalcul();
        onglet1.add(fc);
        onglet1.setPreferredSize(new Dimension(700, 700));
        onglets.addTab("calcul", onglet1);

        onglets.setOpaque(true);
        pannel.add(onglets);
        f.getContentPane().add(pannel);
        f.setVisible(true);
    }
}
