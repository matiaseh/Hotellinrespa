/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotellinrespa;

/**
 *
 * @author User
 */
public class Lasku {

    private double loppusumma;

    Hotellia hotelli = new Hotellia();

    public void LisääLaskuun(double hinta) {
        this.loppusumma += hinta;

    }

    public Lasku(double hinta) {
        this.loppusumma = hinta;

    }

    public double getLasku() {
        return loppusumma;

    }

}
