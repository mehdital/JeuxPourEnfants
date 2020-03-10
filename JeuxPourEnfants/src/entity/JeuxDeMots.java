/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author stag
 */
public class JeuxDeMots {

    // mes attributs
    private int id;
    private String question;
    private String reponse;
    private int niveau;

    public JeuxDeMots() {

    }

    // mon constructeur
    public JeuxDeMots(int id_reponse, String question, String reponse, int niveau) {
        this.id = id_reponse;
        this.question = question;
        this.reponse = reponse;
        this.niveau = niveau;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getReponse() {
        return reponse;
    }

    // mes getteurs
    public int getNiveau() {
        return niveau;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    // mes setteurs
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    // ma methode tostring
    @Override
    public String toString() {
        return "JeuxDeMots{" + "id=" + id + ", question=" + question + ", reponse=" + reponse + ", niveau=" + niveau + '}';
    }

}
