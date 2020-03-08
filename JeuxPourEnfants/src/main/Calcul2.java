package main;

import java.util.Random;

/**
 *
 * @author Khalid <Khalid.Khalid at ldnr.fr>
 */
public class Calcul2 {

    private int x;
    private int y;
    private final String operande;
    

    public Calcul2() {

        this.x = aleaChiffre2();
        this.operande = aleaOperation2();
        this.y = aleaY2();

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
    public Integer getResultat2() {
        if (operande.equals("+")) {
            return x + y;
        } if(operande.equals("-")) {
            return x - y;
        } if (operande.equals("*")) {
            return x*y;
        }  else  {
            return x/y;
        } 
    }
    
     private int aleaChiffre2() {
        Random r = new Random();
        int chiffre = (r.nextInt(100));
        return chiffre;
    }
     
     
    private int aleaY2() {

       y=aleaChiffre2();
        if ("-".equals(this.operande)) {
            while (y > x) {
                this.y = aleaChiffre2();
            }
        } if ("/".equals(this.operande)) {
             while (y == 0 ) {
                this.y = aleaChiffre2();
            }
        }
        return y;
    }

            private static String aleaOperation2() {
        Random r = new Random();
        int chiffre = (r.nextInt(4));
        if (chiffre == 1) {
            return "+";
        }  if (chiffre == 2) {
            return "-";
        }  if (chiffre == 3) {
            return "x";
        } else {
            return "/";
        }
        
}
            
}