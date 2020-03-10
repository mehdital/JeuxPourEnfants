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
import main.Calcul2;

/**
 *
 * @author alixia
 */
public class OngletCalcul2 extends JPanel {

    JPanel jp = new JPanel();
    GridLayout global = new GridLayout(3, 0);

    // pour afficher les textes
    FlowLayout flCal = new FlowLayout();
    FlowLayout flSaisie = new FlowLayout();
    // pour afficher les boutons
    FlowLayout gl = new FlowLayout();
    JPanel Calcul = new JPanel();

    JPanel Info = new JPanel();

    JLabel jtfCal = new JLabel();

    JLabel jtfinfo = new JLabel();

    JPanel Saisie = new JPanel();
    JLabel saisie = new JLabel("Saisie");
    JTextField jtfSai = new JTextField(10);
    JPanel bouton = new JPanel();
    Calcul2 c;

    public OngletCalcul2() {

        // Creation et affichage du calcul
        c = new Calcul2();
        
        //Affichage d'un label pour informer l'utilisateur 
        jtfinfo.setText("Le résultat de la division (÷) est à la décimale près (zero chiffre apres la virgule)");
        Info.add(jtfinfo);

        //Creation de l'affichage du calcul
        jtfCal.setText(c.toString());
        jtfCal.setFont(new Font("Courier New", Font.ITALIC, 35));
        jtfCal.setForeground(Color.BLUE);
        Calcul.add(jtfCal);
        
       
        jp.setLayout(flCal);
        jp.add(Calcul);

        // pour l'affichage de la saisie
        Saisie.add(saisie);
        Saisie.add(jtfSai);
        jp.setLayout(flSaisie);
        jp.add(Saisie);
        jp.add(Info);

        //Ecouteurs de la saisie 
        Saisie.setLayout(flSaisie);
        Saisie.setFont(new Font("Courier New", Font.ITALIC, 35));

        //Pour afficher les boutons
        JButton reponse = new JButton("Réponse");
        JButton verifie = new JButton("Vérifier");
        JButton next = new JButton("Calcul suivant");

        //Ajout des boutons
        bouton.add(reponse);
        bouton.add(verifie);
        bouton.add(next);
        bouton.setLayout(gl);

        jp.add(bouton);

        bouton.add(next);
        bouton.add(verifie);
        bouton.add(reponse);

        //-------------------------Gestion evenementiel-------------------------
        
        next.addActionListener((ActionEvent ae) -> {
            c = new Calcul2();
            jtfCal.setText(c.toString());
            jtfSai.setText("");
            jtfCal.setFont(new Font("Courier New", Font.ITALIC, 35));
            jtfCal.setForeground(Color.BLUE);
        });
        /**
         * Cet évenement est déclanché quand l'utilisateur clic sur 
         * "question suivante", permet de generer un nouveau calcul et gestion de l'affichage 
         * et on vide le champs de saisie pour pas induire l'utilisateur en erreur
         */

        reponse.addActionListener((ActionEvent ae) -> {
            jtfCal.setText(c.toString() + " = " + c.getResultat().toString() + "");
            jtfCal.setFont(new Font("Courier New", Font.ITALIC, 35));
            jtfCal.setForeground(Color.RED);
        });
         /**
         * Cet évenement est déclanché quand l'utilisateur clic sur 
         * "réponse", permet d'afficher le résultat du calcul généré, gestion 
         * de l'affichage
         */
        
        verifie.addActionListener((ActionEvent ae) -> {
            if ((jtfSai.getText()).equals(c.getResultat().toString())) {
                
                jtfCal.setText(c.toString() + " = " + c.getResultat().toString() + "  : C'est ça , Bien joué!");
                jtfCal.setFont(new Font("Courier New", Font.ITALIC, 35));
                jtfCal.setForeground(Color.GREEN);
                
            } else if ((jtfSai.getText()).equals("")) {
                jtfCal.setText("Saisie un résultat!" + "->"
                        + c.toString() + " = " + "?");
                jtfCal.setFont(new Font("Courier New", Font.ITALIC, 35));
                jtfCal.setForeground(Color.BLUE);
                
            } else {
                
                jtfCal.setText(c.toString() + "  : Essaie encore!");
                jtfCal.setFont(new Font("Courier New", Font.ITALIC, 35));
                jtfCal.setForeground(Color.RED);
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
