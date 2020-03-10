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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.reflect.Array.set;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author alixia
 */
public class Admin extends JPanel {

    BoxLayout global = new BoxLayout(this, Y_AXIS);

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

    public Admin() {

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
        jlNumero.setText("Choix du numéro de la question");
        jlNumero.setFont(new Font("Courier New", Font.ITALIC, 15));
        jlNumero.setForeground(Color.BLACK);
        jpNumero.add(jlNumero);
        globalNumero.add(jpNumero);

        //remplir la combox avec le nbr de question
        ArrayList<Integer> nbr = new ArrayList<Integer>();

        for (int i = 1; i < 23; i++) {

            nbr.add(i);
        }
        // séléction numéro de question
        JComboBox numero = new JComboBox(nbr.toArray());
        boutonC.add(numero);
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

        // action lors de la pression des boutons
        enregistrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        // action lors des boutons radio
        br.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String composant = ae.getActionCommand();
                System.out.println(composant);

                for (JeuxDeMots jdm : jdao.getAll()) {
                    jdm = jdao.find("1");

                    System.out.println(jdm);
                }
            }
        });

        br1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String composant = ae.getActionCommand();
                System.out.println(composant);

                for (JeuxDeMots jdm : jdao.getAll()) {
                    jdm = jdao.find("2");
                    System.out.println(jdm);
                }
            }
        });

//        AbstractAction detailsAction = new AbstractAction() {
//
//            public void actionPerformed(ActionEvent pE) {
//                this.setVisible(!true);
//
//            }
//
//        };
        this.add(globalNumero);
        this.add(globalTexte);
        this.add(globalTexte1);
        this.add(globalNiveau);
        this.add(bouton);
        this.setLayout(global);

    }

}
