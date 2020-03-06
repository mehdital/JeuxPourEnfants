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
public class ChangePassword extends JFrame {

    public ChangePassword() {
        // Creation Frame
        JFrame frame = new JFrame("Changer le mot de passe");
        frame.setSize(450, 250);
        frame.setLocationRelativeTo(null);//centrer la fenetre
        frame.setResizable(false);
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
        userText.setBounds(200, 20, 165, 25);
        panel.add(userText);

        //label mot de passe
        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(10, 50, 150, 25);
        panel.add(passwordLabel);

        // champs pour entrer le mot de passe
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(200, 50, 165, 25);
        panel.add(passwordText);

        //label mot de passe
        JLabel newPasswordLabel = new JLabel("Nouveau mot de passe");
        newPasswordLabel.setBounds(10, 80, 200, 25);
        panel.add(newPasswordLabel);

        // champs pour entrer le mot de passe
        JPasswordField newPasswordText = new JPasswordField(20);
        newPasswordText.setBounds(200, 80, 165, 25);
        panel.add(newPasswordText);

        // bouton se connecter
        JButton loginButton = new JButton("Valider");
        loginButton.setBounds(10, 120, 130, 25);
        panel.add(loginButton);
    }
}
