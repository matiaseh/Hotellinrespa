/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotellinrespa;

/**
 *
 * @author tommi
 */
public class PIN {              // Koodisyöte tuodaan konstruktorilla
    
    private int pin = 1234;
  
    
    public boolean koodi(int syöte) {
        return this.pin == syöte;
    }
    
    public void setPIN(int uusipin){
        this.pin = uusipin;    
    }


    
}
