/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastrace;

import java.util.Random;

public class NameGenerator {
    
    private static String[] names = {"Rosena",
        "Neely", 
        "Caryl",
        "Roxana",
        "Ione",
        "Marcela", 
        "Katrice",   
        "Mica",   
        "Madalene",   
        "Beatriz",   
        "Kathrin",   
        "Yaeko",   
        "Mina",   
        "Joleen",   
        "Elouise",   
        "Allie",   
        "Lisette",   
        "Gaston",   
        "Raylene",   
        "Deangelo",   
        "Hilde",   
        "Stephane",   
        "Creola",   
        "Carter",   
        "Suzette",   
        "Gianna",   
        "Willie",   
        "Rodger",   
        "Su",   
        "Terra",   
        "Lili",   
        "Jenine",   
        "Shonta",   
        "Hermina",   
        "Brice",   
        "Mario",   
        "Sonja",   
        "Darnell",   
        "Cassaundra",   
        "Elias",   
        "Zola",   
        "Margie",   
        "Laure",   
        "Keven",   
        "Maryellen",   
        "Tashia",   
        "Dennise",   
        "Regine",   
        "Leta",   
        "Jessenia"  
        }; // Noms générés avec http://www.listofrandomnames.com/index.cfm?textarea

        public static String generate() {
            Random random = new Random();
            int i = random.nextInt(names.length);
            return names[i];
        }
        
}