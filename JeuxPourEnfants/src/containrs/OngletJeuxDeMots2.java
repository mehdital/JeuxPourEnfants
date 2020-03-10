/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containrs;

import dao.JeuxDeMotsDAO;
import entity.JeuxDeMots;
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

/**
 *
 * @author stag
 */
public class OngletJeuxDeMots2 extends JPanel {

    JeuxDeMots question;
    int compt;

    JPanel jp = new JPanel();
    GridLayout global = new GridLayout(3, 0);
    JPanel JeuxDeMots = new JPanel();
    JLabel jl = new JLabel();
    JLabel labelCompteur = new JLabel();

    // pour afficher les textes
    FlowLayout fl = new FlowLayout(80, 60, 80);
    FlowLayout flSaisie = new FlowLayout(80, 40, 80);
    // pour afficher les boutons
    FlowLayout gl = new FlowLayout(20, 40, 20);
// pour la saisie de la reponse
    JPanel Saisie = new JPanel();
    JLabel saisie = new JLabel("saisissez votre reponse");
    JTextField saisieTexte = new JTextField(30);
// ajout du JPanel panelInteractions
    JPanel panelInteractions = new JPanel();
    // definition d'une variable jdm de type JeuxDeMots
    JeuxDeMotsDAO jdm;

    // mon contructeurs de JeuxDeMots
    public OngletJeuxDeMots2() {

        labelCompteur.setText(" Points  : " + compt);
        jdm = new JeuxDeMotsDAO();
        JeuxDeMots.add(jl);
        question = jdm.getRandomByLevel(2);
        jl.setText(question.getQuestion());
        jp.setLayout(fl);
        jp.add(JeuxDeMots);

        // pour afficher les boutons
        JButton reponse = new JButton("Réponse");
        JButton verifie = new JButton("Vérifier");
        JButton next = new JButton("question suivante");
        // pour l'affichage de la saisie
        Saisie.add(saisie);
        Saisie.add(saisieTexte);
        // saisieTexte.setBounds(200, 300, 200, 200);
        jp.setLayout(flSaisie);
        jp.add(Saisie);

        //Ecouteurs de la saisie
        Saisie.setLayout(flSaisie);

        panelInteractions.add(reponse);
        panelInteractions.add(verifie);
        panelInteractions.add(next);
        panelInteractions.setLayout(gl);
        panelInteractions.add(labelCompteur);

        jp.add(panelInteractions);

        panelInteractions.add(next);
        panelInteractions.add(verifie);
        panelInteractions.add(reponse);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                jdm = new JeuxDeMotsDAO();
                question = jdm.getRandomByLevel(2);
                jl.setText(question.getQuestion());
                saisieTexte.setText("");

            }
        });
        reponse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jl.setText(question.getReponse());
                jl.setFont(new Font("Courier New", Font.ITALIC, 18));
                jl.setForeground(Color.blue);
            }
        });
        verifie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (!saisieTexte.getText().equalsIgnoreCase(question.getReponse())) {

                    jl.setText("PERDU !!! ESSAYEZ ENCORE");
                    jl.setFont(new Font("Courier New", Font.ITALIC, 18));
                    jl.setForeground(Color.blue);
                    compt--;

                } else {
                    jl.setText("BRAVO VOUS AVEZ GAGNÉ");
                    jl.setFont(new Font("Courier New", Font.ITALIC, 18));
                    jl.setForeground(Color.blue);
                    compt++;
                }
                labelCompteur.setText("Points :" + compt);
            }

        });

        // ajout au panel
        jp.setLayout(global);
        this.setLayout(global);
        this.add(jp);

        this.add(panelInteractions);
    }
}
