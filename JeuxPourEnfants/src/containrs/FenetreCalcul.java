/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containrs;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main.Calcul;

/**
 *
 * @author alixia
 */
public class FenetreCalcul extends JPanel {

    JPanel jp = new JPanel();
    GridLayout global = new GridLayout(3, 0);

    // pour afficher les textes
    FlowLayout flCal = new FlowLayout();
    FlowLayout flSaisie = new FlowLayout();
    // pour afficher les boutons
    GridLayout gl = new GridLayout(0, 3);
    JPanel Calcul = new JPanel();

    JLabel calcul = new JLabel("Affichage");
    JTextField jtfCal = new JTextField(30);

    JPanel Saisie = new JPanel();
    JLabel saisie = new JLabel("Saisie");
    JTextField jtfSai = new JTextField(30);
    JPanel bouton = new JPanel();
    Calcul c;

    public FenetreCalcul() {

        // Creation et affichage du calcul
        c = new Calcul();

        jtfCal.setText(c.toString());
        Calcul.add(calcul);
        Calcul.add(jtfCal);
        jp.setLayout(flCal);
        jp.add(Calcul);

        // pour l'affichage de la saisie
        Saisie.add(saisie);
        Saisie.add(jtfSai);
        jp.setLayout(flSaisie);
        jp.add(Saisie);

        //Ecouteurs de la saisie 
        jtfSai.addActionListener(new MonEcouteurText());
        Saisie.setLayout(flSaisie);

        // pour afficher les boutons
        JButton reponse = new JButton("Réponse");

        JButton verifie = new JButton("Vérifier");
        JButton next = new JButton("Calcul suivant");

        bouton.add(reponse);
        bouton.add(verifie);
        bouton.add(next);
        bouton.setLayout(gl);

        jp.add(bouton);

        bouton.add(next);
        bouton.add(verifie);
        bouton.add(reponse);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                c = new Calcul();
                jtfCal.setText(c.toString());
                jtfSai.setText("");

            }
        });

        reponse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtfCal.setText(c.toString()+ " = " + c.getResultat().toString() + " Tu feras mieux la prochaine fois :)");

            }

        });
        verifie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (!(jtfSai.getText()).equals(c.getResultat().toString())) {
                     jtfCal.setText(c.toString()+"  : Ce n'est pas ça , Essaie encore!");
                    

                } else {

                      jtfCal.setText(c.toString()+ " = " + c.getResultat().toString() +"  : C'est ça , Bien joué!");

                }

            }

        });

        // on ajoute le panel à notre panel
        jp.setLayout(global);
        this.setLayout(global);
        this.add(jp);

        this.add(bouton);

    }

}
