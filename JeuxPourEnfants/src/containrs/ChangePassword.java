package containrs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mehdi Taleb mehdital@protonmail.com
 */
public class ChangePassword extends JFrame {

    public ChangePassword() {
        // Creation Frame

        JFrame frame = new JFrame("Changer le mot de passe");
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);//centrer la fenetre
        frame.setResizable(true);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);

        panel.setLayout(null);

        JLabel error = new JLabel();
        error.setFont(new Font("Courier New", Font.BOLD, 13));
        panel.add(error);
        error.setForeground(Color.BLUE);
        error.setText("Entrez vos informations");
        error.setBounds(200, 10, 250, 25);

        //label utilisateur
        JLabel userLabel = new JLabel("Utilisateur");
        userLabel.setBounds(10, 40, 150, 25);
        panel.add(userLabel);

        // champs pour entrer l'utilisateur
        JTextField userText = new JTextField(20);
        userText.setBounds(200, 40, 165, 25);
        panel.add(userText);

        //label mot de passe
        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(10, 70, 150, 25);
        panel.add(passwordLabel);

        // champs pour entrer le mot de passe
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(200, 70, 165, 25);
        panel.add(passwordText);

        //label mot de passe
        JLabel newPasswordLabel = new JLabel("Nouveau mot de passe");
        newPasswordLabel.setBounds(10, 100, 200, 25);
        panel.add(newPasswordLabel);

        // champs pour entrer le mot de passe
        JPasswordField newPasswordText = new JPasswordField(20);
        newPasswordText.setBounds(200, 100, 165, 25);
        panel.add(newPasswordText);

        // bouton se connecter
        JButton valider = new JButton("Valider");
        valider.setBounds(10, 140, 130, 25);
        panel.add(valider);

        try (FileReader fileRead = new FileReader("mdp");
                FileWriter fileWrite = new FileWriter("mdp")) {
            // Crée un objet properties
            Properties adminProps = new Properties();
            // Charge les properties depuis un fichier
            adminProps.load(fileRead);

            valider.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (userText.getText().equals(adminProps.getProperty("user"))
                            && passwordText.getText().equals(adminProps.getProperty("password"))) {

                    } else {
                        error.setFont(new Font("Courier New", Font.ITALIC, 13));
                        error.setForeground(Color.RED);
                        error.setText("Identifiant ou mot de passe incorrect");

                    }

                }
            });

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnexionAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnexionAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
