/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotellinrespa;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class Kauppa {

    Map<String, Double> ostokset = new HashMap();

    public Kauppa() {
        ostokset.put("Avaimenperä", 2.50);
        ostokset.put("Postikortti", 0.70);
        ostokset.put("Pehmolelu", 10.0);
        ostokset.put("Magneetti", 2.00);
        ostokset.put("Pullonavaaja", 3.50);
        ostokset.put("Muki", 3.00);
        ostokset.put("Limu 0.5l", 2.30);
        ostokset.put("Limu 0.33l", 1.50);
        ostokset.put("Olut 0.5l", 4.50);
        ostokset.put("Kuohuviini 0.2l", 6.50);
        ostokset.put("Pähkinäpussi 100g", 1.50);

    }

    public double getHinta(String tuote) {
        double hinta = ostokset.get(tuote);
        return hinta;

    }

}
