/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;

/**
 *
 * @author Khalid <Khalid.Khalid at ldnr.fr>
 */
public class Calcul {

    private int x;
    private int y;
    private int resultat;
    private final String operande;

    public Calcul() {

        this.x = aleaChiffre();
        this.operande = aleaOperation();
        this.y = aleaY();

        this.resultat = resultat();

    }

    @Override
    public String toString() {
        return "Calcul{ " + x + operande + y + " = " + resultat + '}';
    }

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

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    private int aleaChiffre() {
        Random r = new Random();
        int chiffre = (r.nextInt(10));
        return chiffre;
    }

    private int aleaY() {

       y=aleaChiffre();
        if ("-".equals(this.operande)) {
            while (y > x) {
                this.y = aleaChiffre();
            }
        }
        return y;
    }

    private static String aleaOperation() {
        Random r = new Random();
        int chiffre = (r.nextInt(2));
        if (chiffre == 1) {
            return "+";
        } else {
            return "-";
        }

    }

    private int resultat() {
        if (operande.equals("+")) {
            return x + y;
        } else {
            return x - y;
        }
    }

}
