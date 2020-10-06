/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastrace;

import java.util.ArrayList;
import java.util.Collections;

public class Course {
    private ArrayList<Voiture> voitures;
    private int nbToursMax;
    private int tourActuel;
    private boolean boost;
    private boolean malus;
    private int argent ;
    
    public Course(int nbTours, ArrayList<Voiture> voitures) {
        this.nbToursMax = nbTours;
        this.tourActuel = 0;
        this.voitures = voitures;
        this.malus = false;
        this.boost = false;
        this.argent =175;
    }

    public boolean isBoost() {
        return boost;
    }

    public void setBoost() {
        this.boost = true;
    }

    public boolean isMalus() {
        return malus;
    }

    public void setMalus() {
        this.malus = true;
    }
    
    
    public ArrayList<Voiture> getClassement() {
        if(this.tourActuel <= this.nbToursMax) { // Si ce n'est pas le dernier tour ou que le dernier tour n'a pas déjà été affiché une fois (et donc pas encore calculé)
            // Définir les malus/bonus
            if(boost) {
                voitureJoueur.setBoosted(true);
            }
            if(malus) { // Malus pour toutes les voitures sauf celle du joueur
                for(Voiture v: voitures) {
                    if(v != voitureJoueur) {
                        v.setMalus(true);
                    }
                }
            }
            
            Collections.sort(this.voitures);
            this.tourActuel++;
        }      
        return voitures;
    }
    
    public int getNbTourMax() {
        return this.nbToursMax;
    }
    public int getArgent() {
        return this.argent;
    }
    public void setArgent (int tune){
        this.argent=tune;
    }
    public int getTourActuel() {
        return tourActuel;
    }
}
