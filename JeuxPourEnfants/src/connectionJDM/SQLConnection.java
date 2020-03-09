/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionJDM;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stag
 */
public final class SQLConnection {
    // MES ATTRIBUTS

    private final static String HOST = "172.16.0.48"; // L'ip de l'hôte
    private final static String PORT = "3306"; // Le PORT de connexion, 3306 par défaut sur MySQL
    private final static String BASE = "2020devJSEg4"; // La BASE de données sur laquelle se connecter
    private final static String LOGIN = "2020devJSEg4"; // Le LOGIN
    private final static String PASSWORD = "Edmundo"; // Le mot de passe
    private static Connection connection = null;
    private final static String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + BASE;

    // mon constructeur doit etre private
    private SQLConnection() {
    }

    // je cree ma methode statique final pour me connecter
    public static final Connection getInstance() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                System.out.println("vous etes connecter a la base de donnée");

            } catch (SQLException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;

    }
    // ont creé une Méthode properties qui va nous retourner notre instance connection et la créer si elle n'existe pas

    public static Connection getInstanceWithProperties(String propertiesFileName) {
        // Crée un objet properties pour récupérer les données
        Properties sqlConfig = new Properties();

        try (InputStream in = SQLConnection.class
                .getResourceAsStream("/ressources/" + propertiesFileName);) {
            sqlConfig.load(in);
        } catch (IOException ex) {
            System.out.println("Fichier property " + propertiesFileName + " n'a pas pu être lu");
            System.exit(1);
        }

        if (connection == null) {
            try {
                String url = "jdbc:" + sqlConfig.getProperty("sgbdr") + "://"
                        + sqlConfig.getProperty("host") + ":"
                        + sqlConfig.getProperty("port") + "/"
                        + sqlConfig.getProperty("database");
                System.out.println("url = " + url);
                connection = DriverManager.getConnection(url, sqlConfig);
            } catch (SQLException ex) {
                System.out.println("Connection à la DB impossible");
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("connecté");

        return connection;
    }
}
