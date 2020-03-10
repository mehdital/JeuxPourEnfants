package containrs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class ConnexionAdmin extends JFrame {

    public ConnexionAdmin() {
        // Creation Frame
        JFrame frame = new JFrame("Connexion administrateur");
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);//centrer la fenetre
        frame.setResizable(false);//ne pas redimentionner
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);

        panel.setLayout(null);

        //label message a l'utilisateur
        JLabel error = new JLabel();
        error.setFont(new Font("Courier New", Font.BOLD, 13));
        panel.add(error);
        error.setForeground(Color.BLUE);
        error.setText("Entrez vos informations");
        error.setBounds(100, 10, 250, 25);

        //label utilisateur
        JLabel userLabel = new JLabel("Utilisateur");
        userLabel.setBounds(10, 40, 150, 25);
        panel.add(userLabel);

        // champs pour entrer l'utilisateur
        JTextField userText = new JTextField(20);
        userText.setBounds(150, 40, 165, 25);
        panel.add(userText);

        //label mot de passe
        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(10, 70, 150, 25);
        panel.add(passwordLabel);

        // champs pour entrer le mot de passe
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 70, 165, 25);
        panel.add(passwordText);

        // bouton se connecter
        JButton loginButton = new JButton("Se connecter");
        loginButton.setBounds(10, 100, 130, 25);
        panel.add(loginButton);

        try (FileReader fileRead = new FileReader("mdp.txt")) {
            // Crée un objet properties
            Properties adminProps = new Properties();
            // Charge les properties depuis un fichier
            adminProps.load(fileRead);

            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (userText.getText().equals(adminProps.getProperty("user"))
                            && passwordText.getText().equals(adminProps.getProperty("password"))) {

                        OngletAdmin admin = new OngletAdmin();
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

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
