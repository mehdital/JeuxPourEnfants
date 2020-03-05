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

    public void AleaChiffre() {

        y = MIN + (int) (Math.random() * ((MAX - MIN) + 1));

        x = MIN + (int) (Math.random() * ((MAX - MIN) + 1));

    }

    @Override
    public String toString() {
        return "Calcul{" + "x=" + x + ", y=" + y + ", Min=" + MIN + ", Max=" + MAX + '}';
    }

    public void AleaCalcul() {
        Calcul c = new Calcul();
        c.AleaChiffre();
        int alea = 1 + (int) (Math.random() * ((2 - 1) + 1));;

        if (alea == 1) {
            System.out.println(c.x + " + " + c.y + " = ");
        } else {

            while (c.x < c.y) {
                c.AleaChiffre();

            }
            System.out.println(c.x + " - " + c.y + " = ");

        }

    }

}