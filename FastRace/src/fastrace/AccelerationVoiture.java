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
public enum AccelerationVoiture {
    BASIQUE,NORMAL,PUISSANTE;

public int action(){
    switch(this)
    {
        case BASIQUE : return 50;
        case NORMAL : return 70;
        case PUISSANTE : return 100;
        default : return 70;
    }
}    
}
