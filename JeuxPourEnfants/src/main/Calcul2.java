package main;

import static java.lang.Integer.divideUnsigned;
import java.util.Random;

/**
 * Class Calcul2
 *
 * Elle permet de generer aléatoirement un calcul sous forme de <Chiffre 1>
 * <Operande> <Chriffre 2><=><resultat>
 *
 * Il s'agit de calcul de niveau 2, elle doit pouvoir generer des additions,
 * soustractions , des multiplications et des divisions. Les nombres doivent
 * être constitué de chiffres pouvant allés jusqu'a 3 (0 à 999). De plus , pour
 * les soustractions résultat ne doit pas être negatif et le cas impossible de
 * la division doit être traité.
 *
 * @author Khalid <Khalid.Khalid at ldnr.fr>
 */
public class Calcul2 {

    private int x;
    private int y;
    private final String operande;

    //-----------------------------Constructeur//-----------------------------
    public Calcul2() {

        this.x = aleaChiffre();
        this.operande = aleaOperation();
        this.y = aleaY();

    }
    
    //-----------------------------ToString//-----------------------------
    @Override
    public String toString() {
        return " " + x + " " + operande + " " + y + " ";
    }

     //-----------------------------Getteur/Setteur//--------------------------    
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
        }
        if (operande.equals("-")) {
            return x - y;
        }
        if (operande.equals("x")) {
            return x * y;
        } else {
            return divideUnsigned(x, y);
        }
    }
    /**
     * Le geteur du resultat qui permet de retourner le resultat de l'opération
     * en fonction de l'operande générée aléatoirement sous forme d'integer afin
     * de pouvoir l'afficher en string
     */

    private int aleaChiffre() {
        Random r = new Random();
        int chiffre = (r.nextInt(1000));
        return chiffre;
    }
    /**
     * Renvoies un int genere aleatoirement entre 0 et 999 avec la class Random
     *
     */
    
    private int aleaY() {

        y = aleaChiffre();
        if ("-".equals(this.operande)) {
            while (y > x) {
                this.y = aleaChiffre();
            }
        }
        if ("÷".equals(this.operande)) {
            while (y == 0) {
                this.y = aleaChiffre();
            }
        }
        return y;
    }
    /**
     * Renvoies un int généré aleatoirement entre 0 et  avec la class Random.
     * Sauf qu'ici nous traitons le cas où le résultat ne doit pas être negatif.
     * Ici il est généré en boucle tant que <Chiffre 1> et inferieur à
     * <Chiffre 2> ou égal a 0 dans le cas de la division
     *
     */
    
    private static String aleaOperation() {
        Random r = new Random();
        int chiffre = (r.nextInt(4));
        if (chiffre == 1) {
            return "+";
        }
        if (chiffre == 2) {
            return "-";
        }
        if (chiffre == 3) {
            return "x";
        } else {
            return "÷";
        }

    }
     /**
     * Renvoies une string genere aleatoirement avec la class Random. Ainsi la
     * class random retourne 0 ou 4
     * Si: 0 , la fonction retourne + : addition 
     *     1 , la fonction retourne - : soustraction
     *     2 , la fonction retourne x : mutliplication
     *     3 , la fonction retourne ÷ : soustraction
     *
     */

}
