/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotellinrespa;

/**
 *
 * @author Tommi
 */
public class Huonepalvelu {

    public double huonepalvelu(String valinta) {
        double x = 0;

        switch (valinta) {
            case "English breakfast":
                x = 12;
                break;
            case "French breakfast":
                x = 12;
                break;
            case "Puuro ja näkkäri":
                x = 4;
                break;
            case "Kahvi":
                x = 2.5;
                break;
            case "Lihapullat":
                x = 13;
                break;
            case "Makaronilaatikko":
                x = 8;
                break;
            case "Karjalanpaisti":
                x = 10;
                break;
            case "Kanasalaatti":
                x = 10;
                break;
            case "Soijaburgeri":
                 x = 25;
                 break;
            case "Pizza":
                x = 9;
                break;
            case "Kanapasta":
                x = 8;
                break;
            case "Lehtipihvi":
                x = 30;
                break;
            case "Salaatti":
                x = 10;
                break;
            case "Hernekeitto":
               x = 5;
               break;
            case "Kokin speacial":
                x = 50;
                break;
            case "Juustolautanen":
                x = 14;
                break;
            case "Hedelmälautanen":
                x = 5;
                break;
            case "Pelkkä lautanen":
                x = 4;
                break;
            case "Täytetty patonki":
                x = 5;
                break;
            case "Roiskeläppä":
                x = 2;
                break;
        }
        return x;
    }

    
}
