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
public enum VitesseMaxVoiture {
    BASIQUE,RAPIDE,PUISSANTE;

public int action(){
    switch(this)
    {
        case BASIQUE : return 150;
        case RAPIDE : return 200;
        case PUISSANTE : return 250;
        default : return 150;
    }
}
}
