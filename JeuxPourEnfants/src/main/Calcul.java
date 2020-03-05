/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Khalid <Khalid.Khalid at ldnr.fr>
 */
public class Calcul {

    private int x;
    private int y;
    private int resultat;
    private final int MIN = 1;
    private final int MAX = 10;

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

    public void aleaChiffre() {

        y = MIN + (int) (Math.random() * ((MAX - MIN) + 1));

        x = MIN + (int) (Math.random() * ((MAX - MIN) + 1));

    }

    @Override
    public String toString() {
        return "Calcul{" + "x=" + x + ", y=" + y + ", resultat=" + resultat + ", MIN=" + MIN + ", MAX=" + MAX + '}';
    }

    public void aleaCalcul() {
        Calcul c = new Calcul();
        c.aleaChiffre();

        int alea = 1 + (int) (Math.random() * ((2 - 1) + 1));;

        if (alea == 1) {
            setResultat(c.x + c.y);
            System.out.println(c.x + " + " + c.y + " = ");
        } else {

            while (c.x < c.y) {
                c.aleaChiffre();

            }
            setResultat(c.x - c.y);
            System.out.println(c.x + " - " + c.y + " = ");

        }

    }

}
