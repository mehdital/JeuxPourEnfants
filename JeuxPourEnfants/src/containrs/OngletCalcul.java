/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containrs;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
public class OngletCalcul extends JPanel {

    JPanel jp = new JPanel();
    
    //La forme global de l'onglet calcul
    GridLayout global = new GridLayout(3, 0);

    // pour afficher les textes
    FlowLayout flCal = new FlowLayout();
    FlowLayout flSaisie = new FlowLayout();
    
    // pour afficher les boutons
    FlowLayout gl = new FlowLayout();
    
    //Creation des champs d'information et de saisie
    JPanel Calcul = new JPanel();
    JLabel jtfCal = new JLabel();
    JPanel Saisie = new JPanel();
    JLabel saisie = new JLabel("Saisie");
    JTextField jtfSai = new JTextField(10);
    JPanel bouton = new JPanel();
    Calcul c;

    public OngletCalcul() {

        // Creation et affichage du calcul
        c = new Calcul();
       
        //Configueration et affichage du calcul et ajout dans la Jpanel global
        jtfCal.setText(c.toString());
        jtfCal.setFont(new Font("Courier New", Font.ITALIC, 35));
        Calcul.add(jtfCal);jtfCal.setText(c.toString());
        jp.setLayout(flCal);
        jp.add(Calcul);

        // pour l'affichage de la saisie
        Saisie.add(saisie);
        Saisie.add(jtfSai);
        jp.setLayout(flSaisie);
        jp.add(Saisie);

        //Ecouteurs de la saisie 
        Saisie.setLayout(flSaisie);
        Saisie.setFont(new Font("Courier New", Font.ITALIC, 35));
        jtfCal.setForeground(Color.BLUE);

        // pour afficher les boutons
        JButton reponse = new JButton("Réponse");
        JButton verifie = new JButton("Vérifier");
        JButton next = new JButton("Calcul suivant");
        bouton.add(reponse);
        bouton.add(verifie);
        bouton.add(next);
        bouton.setLayout(gl);
        jp.add(bouton);bouton.add(next);
        bouton.add(verifie);
        bouton.add(reponse);
        
        //-------------------------Gestion evenementiel-------------------------

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                c = new Calcul();
                jtfCal.setText(c.toString());
                jtfSai.setText("");
                jtfCal.setForeground(Color.BLUE);

            }
        });
        /**
         * Cet évenement est déclanché quand l'utilisateur clic sur 
         * "question suivante", permet de generer un nouveau calcul et gestion de l'affichage 
         * et on vide le champs de saisie pour pas induire l'utilisateur en erreur
         */
        
        reponse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtfCal.setText(c.toString() + " = " + c.getResultat().toString() + "");
                jtfCal.setFont(new Font("Courier New", Font.ITALIC, 35));
                jtfCal.setForeground(Color.RED);

            }

        });
        /**
         * Cet évenement est déclanché quand l'utilisateur clic sur 
         * "réponse", permet d'afficher le résultat du calcul généré, gestion 
         * de l'affichage
         */
        
        
        verifie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if ((jtfSai.getText()).equals(c.getResultat().toString())) {

                    jtfCal.setText(c.toString() + " = " + c.getResultat().toString() + "  : C'est ça , Bien joué!");
                    jtfCal.setFont(new Font("Courier New", Font.ITALIC, 35));
                    jtfCal.setForeground(Color.GREEN);

                } else if ((jtfSai.getText()).equals("")) {
                    jtfCal.setText("Saisie un résultat!" + "->"
                            + c.toString() + " = " + "?");
                    jtfCal.setForeground(Color.BLUE);

                } else {

                    jtfCal.setText(c.toString() + "  : Essaie encore!");
                    jtfCal.setFont(new Font("Courier New", Font.ITALIC, 35));
                    jtfCal.setForeground(Color.RED);
                }

            }

        });
        /**
         *Gestion de l'événement quand l'utilisateur clic sur verifie. 
         * Compare la saisie et le resultat
         * si rien n'est saisie demande de saisie 
         */

        // on ajoute le panel à notre panel
        jp.setLayout(global);
        this.setLayout(global);
        this.add(jp);
        this.add(bouton);

    }

}
