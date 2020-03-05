package containrs;

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);

        panel.setLayout(null);

        //label utilisateur
        JLabel userLabel = new JLabel("Utilisateur");
        userLabel.setBounds(10, 20, 150, 25);
        panel.add(userLabel);

        // champs pour entrer l'utilisateur
        JTextField userText = new JTextField(20);
        userText.setBounds(150, 20, 165, 25);
        panel.add(userText);

        //label mot de passe
        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(10, 50, 150, 25);
        panel.add(passwordLabel);

        // champs pour entrer le mot de passe
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 50, 165, 25);
        panel.add(passwordText);

        // bouton se connecter
        JButton loginButton = new JButton("Se connecter");
        loginButton.setBounds(10, 80, 130, 25);
        panel.add(loginButton);
    }

}
