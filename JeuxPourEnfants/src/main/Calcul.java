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
    private final String operande;

    public Calcul() {

        this.x = aleaChiffre();
        this.operande = aleaOperation();
        this.y = aleaY();

    }

    @Override
    public String toString() {
        return   ""+x +" "+ operande +" "+ y+" "   ;
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

    public Integer getResultat() {
        if (operande.equals("+")) {
            return x + y;
        } else {
            return x - y;
        }
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

    
    


}
