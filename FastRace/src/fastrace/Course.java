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
    
    public Course(int nbTours, ArrayList<Voiture> voitures) {
        this.nbToursMax = nbTours;
        this.tourActuel = 0;
        this.voitures = voitures;
    }
    
    public ArrayList<Voiture> getClassement() {
        if(this.tourActuel <= this.nbToursMax) { // Si ce n'est pas le dernier tour ou que le dernier tour n'a pas déjà été affiché une fois (et donc pas encore calculé)
            Collections.sort(this.voitures);
            this.tourActuel++;
        }
        return voitures;
    }
    
    public int getNbTourMax() {
        return this.nbToursMax;
    }
    
}
