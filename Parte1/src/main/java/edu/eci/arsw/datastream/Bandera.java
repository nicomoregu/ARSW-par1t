/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.datastream;

/**
 *
 * @author Nicolas Moreno Guataquira.
 */
public class Bandera {
    private static boolean band;
    
    public Bandera() {
        this.band = false;
    }
    public void setBand(boolean value){
        band = value;
    }
    public synchronized boolean getBand(){
        return band;
    }
    
}
