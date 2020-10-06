/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastrace;

import java.util.ArrayList;

public class TestGenerationVoitures {

    public static void main(String[] args) {
        ArrayList<Voiture> voitures = Voiture.genererVoitures(10);
        for(Voiture v: voitures) {
            System.out.println(v.toString());
        }
    }
    
}
