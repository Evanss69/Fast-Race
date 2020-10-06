/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastrace;


/**
 *
 * @author p1925390
 */

public class Voiture implements Comparable<Voiture> {
    String nomVoiture;
    int vitesseActuelle;
    int vitesseMax;
    int acceleration;
    boolean pneuPluie;
    boolean boosted;

    public Voiture(String nomVoiture){
        vitesseActuelle = 0;
        vitesseMax = 0;
        acceleration=0;
        pneuPluie=false;
        boosted=false;
    }
    
    
    public Voiture(String nomVoiture,VitesseMaxVoiture vitesseMax, AccelerationVoiture acceleration, boolean pneuPluie) {
        this.nomVoiture = nomVoiture;
        this.vitesseActuelle = 0;
        this.vitesseMax = vitesseMax.action();
        this.acceleration = acceleration.action();
        this.pneuPluie = pneuPluie; 
        this.boosted = false;
    }

    public String getNomVoiture() {
        return nomVoiture;
    }

    public int getVitesseActuelle() {
        return vitesseActuelle;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public boolean isPneuPluie() {
        return pneuPluie;
    }
    
    public boolean isBoosted() {
        return boosted;
    }

   public int getVitesse(){
       if(boosted) { // Return si la voiture dispose d'un boost pour ce tour
           vitesseActuelle=vitesseActuelle+(int) Math.round(acceleration*1.2); // Le boost est de 20% de l'accélération (on arrondi à l'entier le plus proche)
           boosted = false; // Réinitialisation du boost
       } else {
           vitesseActuelle=vitesseActuelle+acceleration;
       }
       
       if(vitesseActuelle > vitesseMax) { // On vérifie que la voiture ne dépasse pas sa vitesse maximale
           vitesseActuelle = vitesseMax;
       }
       return vitesseActuelle;
   }  
    
    public int compareTo(Voiture v) {
       return this.getVitesse() - v.getVitesse();
    }
    
}
