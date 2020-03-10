/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.JeuxDeMots;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stag
 */
public class JeuxDeMotsDAO implements Dao<JeuxDeMots> {

    private final String TABLE = "JeuxDeMots";

    int id;
    String question, reponse, niveau;
    public ArrayList<JeuxDeMots> jdm;

    @Override
    public JeuxDeMots getQuestion() {
        JeuxDeMots jdm = null;
        try {
            String req = "SELECT * FROM jeuxDeMots ORDER BY RAND() LIMIT 1";

            Statement stmt = CONNECTION.createStatement();
            ResultSet result = stmt.executeQuery(req);
            if (result.first()) {
                jdm = new JeuxDeMots(
                        result.getInt("id"),
                        result.getString("question"),
                        result.getString("reponse"),
                        result.getInt("niveau")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(JeuxDeMotsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jdm;

    }

    @Override
    public void create(JeuxDeMots obj) {
        try {
            String req = "INSERT INTO JeuxDeMots"
                    + " (question,reponse,niveau) VALUES(?,?,?)";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getQuestion());
            pstmt.setString(2, obj.getReponse());
            pstmt.setInt(3, obj.getNiveau());
            // On soumet la requête et on récupère le nombre de lignes créées
            int nbLignesImpactees = pstmt.executeUpdate();
            // On récupère un ResulSet contenant toutes les clés générées
            // Ici une seule, évidemment
            ResultSet rs = pstmt.getGeneratedKeys();
            int last_inserted_id;
            if (rs.first()) { // Si on a des id créés on lit le premier
                last_inserted_id = rs.getInt(1);
                // On récupère l'enregistrement créé
                obj.setQuestion(req);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JeuxDeMotsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(JeuxDeMots obj) {
        try {
            String req = "UPDATE " + TABLE + " SET question = ?,"
                    + " reponse = ?, niveau=? WHERE id =?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setString(1, obj.getQuestion());
            pstmt.setString(2, obj.getReponse());
            pstmt.setInt(3, obj.getNiveau());
            pstmt.setInt(4, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JeuxDeMotsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(JeuxDeMots obj) {
        try {
            String req = "DELETE JeuxDeMots WHERE id = ?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setInt(1, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JeuxDeMotsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JeuxDeMots getRandomByLevel(int niveau) {
        JeuxDeMots jdm = null;

        if (niveau == 1) {
            try {

                String req = "SELECT * FROM JeuxDeMots WHERE niveau = 1 ORDER BY RAND() LIMIT 1";
                PreparedStatement pstmt = CONNECTION.prepareStatement(req);
                ResultSet result = pstmt.executeQuery();
                if (result.first()) {
                    jdm = new JeuxDeMots(
                            result.getInt("id"),
                            result.getString("question"),
                            result.getString("reponse"),
                            result.getInt("niveau"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(JeuxDeMotsDAO.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            if (niveau == 2) {
                try {
                    String req = "SELECT * FROM JeuxDeMots WHERE niveau=2 ORDER BY RAND() LIMIT 1";
                    PreparedStatement pstmt = CONNECTION.prepareStatement(req);
                    ResultSet result = pstmt.executeQuery();
                    while (result.next()) {
                        jdm = new JeuxDeMots(
                                result.getInt("id"),
                                result.getString("question"),
                                result.getString("reponse"),
                                result.getInt("niveau"));

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(JeuxDeMotsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return jdm;
    }

    @Override
    public JeuxDeMots find(int id) {
        JeuxDeMots jdm = null;
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                jdm = new JeuxDeMots(
                        id,
                        result.getString("question"),
                        result.getString("reponse"),
                        result.getInt("niveau")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(JeuxDeMots.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jdm;
    }

    public JeuxDeMots find(String niveau) {
        JeuxDeMots jdm = null;

        if ("1".equals(niveau)) {
            try {
                String req = "SELECT * FROM " + TABLE + " WHERE niveau = 1 ORDER BY RAND() LIMIT 1 ";
                PreparedStatement pstmt = CONNECTION.prepareStatement(req);
                ResultSet result = pstmt.executeQuery();
                if (result.first()) {
                    jdm = new JeuxDeMots(
                            result.getInt("id"),
                            result.getString("question"),
                            result.getString("reponse"),
                            result.getInt("niveau")
                    );
                }
            } catch (SQLException ex) {
                Logger.getLogger(JeuxDeMots.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if ("2".equals(niveau)) {
                try {
                    String req = "SELECT * FROM " + TABLE + " WHERE  niveau = 2 ORDER BY RAND() LIMIT 2 ";
                    PreparedStatement pstmt = CONNECTION.prepareStatement(req);
                    ResultSet result = pstmt.executeQuery();
                    if (result.first()) {
                        jdm = new JeuxDeMots(
                                result.getInt("id"),
                                result.getString("question"),
                                result.getString("reponse"),
                                result.getInt("niveau")
                        );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JeuxDeMots.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return jdm;
    }

    public ArrayList<JeuxDeMots> getAll() {

        jdm = new ArrayList();
        try {
            String req = "SELECT * FROM JeuxDeMots ";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                jdm.add(new JeuxDeMots(result.getInt("id"), result.getString("question"), result.getString("reponse"), result.getInt("niveau")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(JeuxDeMotsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jdm;
    }

}
