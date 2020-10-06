/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastrace;

import java.util.ArrayList;
import java.util.Random;


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
    
    private static Voiture genererVoiture(ArrayList<Voiture> autresVoitures) {
        Random random = new Random();   
        
        String nom;
        boolean nameExist;
        do{
            nameExist = false;
            nom = NameGenerator.generate();
            // Vérifier que le nom n'existe pas déjà
            for(Voiture v: autresVoitures) {
                if (v.getNomVoiture().equals(nom)) {
                    nameExist = true;
                }
            }
        } while (nameExist);
        
        AccelerationVoiture acc;
        int acc_rd = random.nextInt(2);
        switch(acc_rd) {
            case 1:
                acc = AccelerationVoiture.NORMAL;
                break;
            case 2:  
                acc = AccelerationVoiture.PUISSANTE;
                break;
            default:
                acc = AccelerationVoiture.BASIQUE;
                break;
        }
        
        VitesseMaxVoiture vmax;
        int vmax_rd = random.nextInt(2);
        switch(vmax_rd) {
            case 1:
                vmax = VitesseMaxVoiture.PUISSANTE;
                break;
            case 2:  
                vmax = VitesseMaxVoiture.RAPIDE;
                break;
            default:
                vmax = VitesseMaxVoiture.BASIQUE;
                break;
        }
        
        boolean pneuPluie = random.nextBoolean();
        
        Voiture v = new Voiture(nom,vmax,acc, pneuPluie);
        return v;
    }
    
    public static ArrayList<Voiture> genererVoitures(int nb) {
        ArrayList<Voiture> voitures = new ArrayList<Voiture>();
        for(int i=0;i<nb;i++) {
            voitures.add(Voiture.genererVoiture(voitures));
        }
        return voitures;
    }

    @Override
    public String toString() {
        return "Voiture{" + "nomVoiture=" + nomVoiture + ", vitesseActuelle=" + vitesseActuelle + ", vitesseMax=" + vitesseMax + ", acceleration=" + acceleration + ", pneuPluie=" + pneuPluie + ", boosted=" + boosted + '}';
    }
    
    
}
