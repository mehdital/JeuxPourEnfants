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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JFrame;

/**
 * création d'un panel permettant l'affichage d'un onglet. le panel de la classe
 * contient un panel global qui contient plusieur panel ( blocs ).
 *
 * l'on crée des champs de texte et des boutons pour pouvoir: écrire une
 * question, écrire une réponse, choisir le niveau, modifier, enregistrer.
 *
 * le tout connecté à la base de donnée.
 *
 * @author alixia
 */
public class OngletAdmin extends JFrame {

    GridLayout global = new GridLayout(5, 0);

    // pour afficher les blocs
    JPanel globalNiveau = new JPanel(new FlowLayout());
    JPanel globalTexte = new JPanel(new FlowLayout());
    JPanel globalTexte1 = new JPanel(new FlowLayout());
    JPanel globalNumero = new JPanel(new FlowLayout());

    // pour afficher les textes
    JPanel jpNiveau = new JPanel(new FlowLayout());
    JLabel jlNiveau = new JLabel();

    JPanel jpNumero = new JPanel(new FlowLayout());
    JLabel jlNumero = new JLabel();

    JPanel jpEnonce = new JPanel(new FlowLayout());
    JLabel jlEnonce = new JLabel();
    JTextField jtfEnonce = new JTextField(30);

    JPanel jpReponse = new JPanel(new FlowLayout());
    JTextField jtfReponse = new JTextField(30);
    JLabel jlReponse = new JLabel();

    // pour afficher les boutons
    JPanel bouton = new JPanel(new FlowLayout());

    // pour afficher les boutons radios
    JPanel boutonR = new JPanel();
    JLabel jlBoutonR = new JLabel();

    // pour afficher menu deroulant
    JPanel boutonC = new JPanel();

    // utilisé la base de donnée
    JeuxDeMotsDAO jdao = new JeuxDeMotsDAO();
    OngletJeuxDeMots b = new OngletJeuxDeMots();

    public OngletAdmin() {

        // affichage texte niveau
        jlNiveau.setText("Choix du niveau des questions ");
        jlNiveau.setFont(new Font("Courier New", Font.ITALIC, 15));
        jlNiveau.setForeground(Color.BLACK);
        jpNiveau.add(jlNiveau);
        globalNiveau.add(jpNiveau);

        //séléction du niveau
        ButtonGroup bt = new ButtonGroup();
        JRadioButton br = new JRadioButton("Niveau 1");
        JRadioButton br1 = new JRadioButton("Niveau 2");
        bt.add(br);
        bt.add(br1);
        boutonR.add(br);
        boutonR.add(br1);
        globalNiveau.add(boutonR);

        // affichage texte numero question
        jlNumero.setText("Choix de la question");
        jlNumero.setFont(new Font("Courier New", Font.ITALIC, 15));
        jlNumero.setForeground(Color.BLACK);
        jpNumero.add(jlNumero);
        globalNumero.add(jpNumero);

        // séléction numéro de question
        JComboBox selection = new JComboBox(jdao.getAll().toArray());
        boutonC.add(selection);
        globalNumero.add(boutonC);

        // affichage texte niveau
        jlEnonce.setText("Saisir votre énoncer ");
        jlEnonce.setFont(new Font("Courier New", Font.ITALIC, 15));
        jlEnonce.setForeground(Color.BLACK);
        jpEnonce.add(jlEnonce);
        globalTexte.add(jpEnonce);

        jlReponse.setText("Saisir votre réponse ");
        jlReponse.setFont(new Font("Courier New", Font.ITALIC, 15));
        jlReponse.setForeground(Color.BLACK);
        jpReponse.add(jlReponse);
        globalTexte1.add(jpReponse);

        // champ édition rédaction énoncé et réponse
        jpEnonce.add(jlEnonce);
        jpEnonce.add(jtfEnonce);
        jtfEnonce.addActionListener(new MonEcouteurText());
        globalTexte.add(jpEnonce);

        jpReponse.add(jlReponse);
        jpReponse.add(jtfReponse);
        jtfReponse.addActionListener(new MonEcouteurText());
        globalTexte1.add(jpReponse);

        // bouton pour enregistrer et modifier
        JButton enregistrer = new JButton("Enregistrer");
        JButton modifier = new JButton("Modifier");
        bouton.add(enregistrer);
        bouton.add(modifier);

        /**
         * action lors de la pression des boutons. Le bouton enregistrer,
         * récupère la saisie des deux champs de texte. on vérifie le niveau
         * séléctionné sur les boutons radio. Suivant celui séléctionné, le
         * niveau ( String ) est modifier. on crée un nouveau jeux de mots.
         *
         * Le bouton modifier, récupère le choix sélectionné sur la comboBox. on
         * écoute les boutons radio. On met des conditions si les champs textes
         * sont vides, sinon cela remplace la question et la réponse par du
         * vide. Et l'on modifie la question séléctionné.
         *
         */
        enregistrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String enonce = jtfEnonce.getText();
                String reponse = jtfReponse.getText();
                Integer niveau = null;
                int id = 0;
                if (br.isSelected()) {
                    niveau = 1;
                } else if (br1.isSelected()) {
                    niveau = 2;
                }
                jdao.create(new JeuxDeMots(id, enonce, reponse, niveau));
            }

        });
        modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JeuxDeMots jdm;
                Integer niveau = null;
                if (br.isSelected()) {
                    niveau = 1;
                } else if (br1.isSelected()) {
                    niveau = 2;
                }
                jdm = (JeuxDeMots) selection.getSelectedItem();
                if (niveau != null) {
                    jdm.setNiveau(niveau);
                }
                if (!jtfEnonce.getText().equals("")) {
                    jdm.setQuestion(jtfEnonce.getText());
                }
                if (!jtfReponse.getText().equals("")) {
                    jdm.setReponse(jtfReponse.getText());
                }
                jdao.update(jdm);
                System.out.println(jdao);
            }

        });

        this.add(globalNumero);
        this.add(globalTexte);
        this.add(globalTexte1);
        this.add(globalNiveau);
        this.add(bouton);
        this.setLayout(global);
        this.setVisible(true);
        this.setSize(950, 900);
        this.setTitle("Gestion Administration");

    }

}
