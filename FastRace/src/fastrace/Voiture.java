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
    boolean malus;

    public Voiture(String nomVoiture){
        vitesseActuelle = 0;
        vitesseMax = 150;
        acceleration=50;
        pneuPluie=false;
        boosted=false;
        malus=false;
    }
    
    
    public Voiture(String nomVoiture,VitesseMaxVoiture vitesseMax, AccelerationVoiture acceleration, boolean pneuPluie) {
        this.nomVoiture = nomVoiture;
        this.vitesseActuelle = 0;
        this.vitesseMax = vitesseMax.action();
        this.acceleration = acceleration.action();
        this.pneuPluie = pneuPluie; 
        this.boosted = false;
        this.malus=false;
    }

    public void setNomVoiture(String nomVoiture) {
        this.nomVoiture = nomVoiture;
    }

    public void setVitesseActuelle(int vitesseActuelle) {
        this.vitesseActuelle = vitesseActuelle;
    }

    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public void setPneuPluie(boolean pneuPluie) {
        this.pneuPluie = pneuPluie;
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
    
    public void setBoosted(boolean boost) {
        this.boosted = boost;
    }
    
    public boolean isBoosted() {
        return boosted;
    }

     public void setMalus(boolean malu) {
        this.malus = malu;
    }
    
    public boolean isMalus() {
        return malus;
    }

    
   public int getVitesse(){
       if(boosted && !malus) { // si boost et pas malus
           vitesseActuelle=vitesseActuelle+(int) Math.round(acceleration*1.2); // Le boost est de 20% de l'accélération (on arrondi à l'entier le plus proche)
       } else if(!boosted && malus) {
           vitesseActuelle=vitesseActuelle+(int) Math.round(acceleration*0.8); // Le malus est de 20% de l'accélération (on arrondi à l'entier le plus proche)
       } else { // Si il y a un boost et malus ou s'il n'y a rien la conséquence est la même, la vitesse est calculée normalement
           vitesseActuelle=vitesseActuelle+acceleration;
       }
       
       boosted = false; // Réinitialisation du boost
       malus = false; // Réinitialisation du malus
       
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
        int vId = 1;
        do{
            nameExist = false;
            nom = NameGenerator.generate() + vId;
            // Vérifier que le nom n'existe pas déjà
            for(Voiture v: autresVoitures) {
                if (v.getNomVoiture().equals(nom)) {
                    nameExist = true;
                    vId++;
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
