/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;

/**
 * Class Calcul
 *
 * Elle permet de generer aléatoirement un calcul sous forme de <Chiffre 1>
 * <Operande> <Chriffre 2><=><resultat>
 *
 * Il s'agit de calcul de niveau 1, elle doit pouvoir generer des additions et
 * soustractions. Les nombres doivent être constitué d'un seul chiffre mais le
 * résultat pouvant être a deux chiffre De plus , pour les soustractions le
 * résultat ne doit pas être negatif
 *
 * @author Khalid <Khalid.Khalid at ldnr.fr>
 */
public class Calcul {

    private int x;
    private int y;
    private final String operande;

    //-----------------------------Constructeur//-----------------------------
    public Calcul() {
        this.x = aleaChiffre();
        this.operande = aleaOperation();
        this.y = aleaY();
    }

    //-----------------------------ToString//-----------------------------
    @Override
    public String toString() {
        return "" + x + " " + operande + " " + y + " ";
    }

    //-----------------------------Getteur/Setteur//----------------------------
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //----------------------------Getteur Résultat ----------------------------
    public Integer getResultat() {
        if (operande.equals("+")) {
            return x + y;
        } else {
            return x - y;
        }
    }
    /**
     * Le geteur du resultat qui permet de retourner le resultat de l'opération
     * en fonction de l'operande générée aléatoirement sous forme d'integer afin
     * de pouvoir l'afficher en string
     */
    
    private int aleaChiffre() {
        Random r = new Random();
        int chiffre = (r.nextInt(10));
        return chiffre;
    }
    /**
     * Renvoies un int genere aleatoirement entre 0 et 10 avec la class Random
     *
     */
    private int aleaY() {

        y = aleaChiffre();
        if ("-".equals(this.operande)) {
            while (y > x) {
                this.y = aleaChiffre();
            }
        }
        return y;
    }

    /**
     * Renvoies un int genere aleatoirement entre 0 et 10 avec la class Random.
     * Sauf qu'ici nous traitons le cas où le résultat ne doit pas être negatif.
     * Ici il est genere en boucle tant que <Chiffre 1> et inferieur à
     * <Chiffre 2>
     *
     */
    private static String aleaOperation() {
        Random r = new Random();
        int chiffre = (r.nextInt(2));
        if (chiffre == 0) {
            return "+";
        } else {
            return "-";
        }
    }
    /**
     * Renvoies une string genere aleatoirement avec la class Random. Ainsi la
     * class random retourne 0 ou 1 Si 0 , la fonction retourne + : addition Si
     * 1 , la fonction retourne - : soustraction
     *
     */

}
