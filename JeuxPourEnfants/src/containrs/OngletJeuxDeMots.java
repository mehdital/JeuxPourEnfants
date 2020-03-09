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
public class OngletJeuxDeMots extends JPanel {

    JeuxDeMots question;

    JPanel jp = new JPanel();
    GridLayout global = new GridLayout(3, 0);

    // pour afficher les textes
    FlowLayout fl = new FlowLayout();
    FlowLayout flSaisie = new FlowLayout();
    // pour afficher les boutons
    FlowLayout gl = new FlowLayout();
    JPanel JeuxDeMots = new JPanel();

    JLabel jlf = new JLabel();

    JPanel Saisie = new JPanel();
    JLabel saisie = new JLabel("saisissez votre reponse");
    JTextField saisieTexte = new JTextField(30);

    JPanel bouton = new JPanel();
    JeuxDeMotsDAO jdm;

    public OngletJeuxDeMots() {
        jdm = new JeuxDeMotsDAO();

        jlf.setText(jdm.toString());
        jlf.setFont(new Font("Courier New", Font.ITALIC, 15));
        jlf.setForeground(Color.blue);

        JeuxDeMots.add(jlf);
        jlf.setText(jdm.getRandomByLevel(1).getQuestion());
        jp.setLayout(fl);
        jp.add(JeuxDeMots);

        // pour afficher les boutons
        JButton reponse = new JButton("Réponse");
        JButton verifie = new JButton("Vérifier");
        JButton next = new JButton("question suivante");
        // pour l'affichage de la saisie
        Saisie.add(saisie);
        Saisie.add(saisieTexte);
        saisieTexte.setBounds(200, 300, 200, 200);
        jp.setLayout(flSaisie);
        jp.add(Saisie);

        //Ecouteurs de la saisie
        Saisie.setLayout(flSaisie);

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

                jdm = new JeuxDeMotsDAO();
                question = jdm.getRandomByLevel(1);
                jlf.setText(question.getQuestion());
                saisieTexte.setText("");

            }
        });
        reponse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jlf.setText(question.getReponse());
            }
        });

        // ajout au panel
        jp.setLayout(global);
        this.setLayout(global);
        this.add(jp);

        this.add(bouton);
    }
}
