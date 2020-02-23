/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotellinrespa;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tommi
 */
public class Näkymä {

    private Controller controller;

    public Näkymä(Controller controller) {
        this.controller = controller;
    }

    public int valinta() {

        controller.Lisäälaskulistaan("Hynnä", 320);
        controller.Lisäälaskulistaan("Suni", 1);
        controller.Lisäälaskulistaan("Vanhanen", 1000);
        controller.Lisäälaskulistaan("Väyrynen", 540);

        int lopeta = 0;
        String[] valinnat = {"Checkin", "Checkout", "Kauppa", "Huonepalvelu", "Kassa", "Lopeta"};
        String valinta = (String) JOptionPane.showInputDialog(null, "Valitse haluamasi toiminto", "TERVETULOA!", JOptionPane.QUESTION_MESSAGE, null, valinnat, valinnat[0]);
        if (valinta == null) {
        } else {
            switch (valinta) {
                case "Checkin":           //Asiakasnumero huone, luo laskuolio.
                    final String[] valinnat1 = {"Sviitti", "Perhehuone", "Parihuone"};
                    String huonevalinta = (String) JOptionPane.showInputDialog(null, "Valitse huone", "CHECKIN", JOptionPane.QUESTION_MESSAGE, null, valinnat1, valinnat1[0]);
                    if (huonevalinta == null) {
                        break;
                    }
                    int huoneidenmäärä;
                    try {
                        huoneidenmäärä = Integer.parseInt(JOptionPane.showInputDialog(null, "Valitse huoneiden määrä \nHuoneita jäljellä " + controller.huoneLkm(huonevalinta), "CHECKIN", JOptionPane.QUESTION_MESSAGE));
                    } catch (Exception e) {
                        break;
                    }

                    int kesto;
                    try {
                        kesto = Integer.parseInt(JOptionPane.showInputDialog(null, "Anna viipymisen kesto (yötä)", "CHECKIN", JOptionPane.QUESTION_MESSAGE));
                    } catch (Exception e) {
                        break;
                    }
                    int huonehinta = controller.huonevalinta(huonevalinta, huoneidenmäärä, kesto);

                    if (huonehinta == 0) {
                        JOptionPane.showMessageDialog(null, "HUONETYYPPIÄ EI JÄLJELLÄ");

                    } else {
                        String asiakasnimi = JOptionPane.showInputDialog(null, null, "Anna asiakkaan sukunimi", JOptionPane.QUESTION_MESSAGE);
                        if (asiakasnimi == null) {
                            break;
                        }
                        controller.Lisäälaskulistaan(asiakasnimi, huonehinta); //Luo laskuolion ja lisää sen listaan
                        JOptionPane.showMessageDialog(null, "Asiakas lisätty listaan" ,"CHECKIN", JOptionPane.DEFAULT_OPTION);
                        
                    }
                    break;

                case "Checkout":
                    valinnat = controller.haeAsiakasLista();
                    String laskuvalinta = (String) JOptionPane.showInputDialog(null, "Valitse asiakas", "CHECKOUT", JOptionPane.QUESTION_MESSAGE, null, valinnat, valinnat[0]);
                    if (laskuvalinta == null) {
                        break;
                    }
                    int pin;
                    try {
                        pin = Integer.parseInt(JOptionPane.showInputDialog(null, "ANNA PIN", "KASSA", JOptionPane.QUESTION_MESSAGE));
                    } catch (Exception e) {
                        break;
                    }

                    double hinta = controller.haelasku(laskuvalinta);
                    String tulos = controller.kassa(pin, hinta);
                    switch (tulos) {
                        case "MAKSU EPÄONNISTUI":
                            break;
                        default:
                            controller.poistaLasku(laskuvalinta);
                            break;
                    }
                    JOptionPane.showMessageDialog(null, tulos, "KASSA", JOptionPane.DEFAULT_OPTION);
                    break;

                case "Kauppa":
                    final String[] tuotteet = {"Avaimenperä", "Postikortti", "Pehmolelu", "Magneetti", "Pullonavaaja", "Muki", "Limu 0.5l", "Limu 0.33l", "Olut 0.5l", "Kuohuviini 0.2l", "Pähkinäpussi 100g"};
                    String tuote = (String) JOptionPane.showInputDialog(null, "Valitse tuote", "KAUPPA", JOptionPane.QUESTION_MESSAGE, null, tuotteet, tuotteet[0]);
                    if (tuote == null) {
                        break;
                    }
                    double määrä = controller.kauppa(tuote);
                    try {
                        pin = Integer.parseInt(JOptionPane.showInputDialog(null, "ANNA PIN", "KASSA", JOptionPane.QUESTION_MESSAGE));
                    } catch (Exception e) {
                        break;
                    }
                    tulos = controller.kassa(pin, määrä);
                    JOptionPane.showMessageDialog(null, tulos, "KASSA", JOptionPane.DEFAULT_OPTION);

                    break;
                case "Huonepalvelu":
                    final String[] palvelut = {"Aamiainen", "Lounas", "Päivällinen", "Iltapala"};
                    String palvelu = (String) JOptionPane.showInputDialog(null, "Valitse palvelu", "Room Service", JOptionPane.QUESTION_MESSAGE, null, palvelut, palvelut[0]);
                    if (palvelu == null) {
                        break;
                    }
                    String palveluval = null;
                    switch (palvelu) {
                        case "Aamiainen":
                            final String[] aamiaiset = {"English breakfast", "French breakfast", "Puuro ja näkkäri", "Kahvi"};
                            palveluval = (String) JOptionPane.showInputDialog(null, "Valitse aamiainen", "Room Service", JOptionPane.QUESTION_MESSAGE, null, aamiaiset, aamiaiset[0]);
                            break;
                        case "Lounas":
                            final String[] lounaat = {"Lihapullat", "Makaronilaatikko", "Karjalanpaisti", "Kanasalaatti", "Soijaburgeri"};
                            palveluval = (String) JOptionPane.showInputDialog(null, "Valitse lounas", "Room Service", JOptionPane.QUESTION_MESSAGE, null, lounaat, lounaat[0]);
                            break;
                        case "Päivällinen":
                            final String[] päivälliset = {"Pizza", "Kanapasta", "Lehtipihvi", "Salaatti", "Hernekeitto", "Kokin speacial"};
                            palveluval = (String) JOptionPane.showInputDialog(null, "Valitse päivällinen", "Room Service", JOptionPane.QUESTION_MESSAGE, null, päivälliset, päivälliset[0]);
                            break;
                        case "Iltapala":
                            final String[] iltapalat = {"Juustolautanen", "Heldelmälautanen", "Pelkkä lautanen", "Täytetty patonki", "Roiskeläppä"};
                            palveluval = (String) JOptionPane.showInputDialog(null, "Valitse iltapala", "Room Service", JOptionPane.QUESTION_MESSAGE, null, iltapalat, iltapalat[0]);
                            break;
                    }
                    if (palveluval == null) {
                        break;
                    }

                    String tilaaja = (String) JOptionPane.showInputDialog(null, "Valitse asiakas listalta", "Room Service", JOptionPane.QUESTION_MESSAGE, null, controller.haeAsiakasLista(), controller.haeAsiakasLista()[0]);
                    if (tilaaja == null) {
                        break;
                    }
                    tulos = controller.palveluvalinta(palveluval, tilaaja);
                    JOptionPane.showMessageDialog(null, tulos, "Room Service", JOptionPane.DEFAULT_OPTION);

                    break;

                case "Kassa":
                    int uusipin = 0;
                    int uusipin1 = 1;
                    final String[] kassavalinta = {"Laske kassa", "Vaihda PIN"};
                    String kassaval = (String) JOptionPane.showInputDialog(null, "Valitse toiminto", "KASSA", JOptionPane.QUESTION_MESSAGE, null, kassavalinta, kassavalinta[0]);
                    if (kassaval == null) {
                        break;
                    }

                    if ("Vaihda PIN".equals(kassaval)) {
                        try {
                            pin = Integer.parseInt(JOptionPane.showInputDialog(null, null, "Anna vanha PIN", JOptionPane.QUESTION_MESSAGE));
                        } catch (Exception e) {
                            break;
                        }

                        if (controller.tarkistapin(pin) == true) {
                            try {
                                uusipin = Integer.parseInt(JOptionPane.showInputDialog(null, null, "Anna uusi PIN", JOptionPane.QUESTION_MESSAGE));
                            } catch (Exception e) {
                                break;
                            }
                            try {
                                uusipin1 = Integer.parseInt(JOptionPane.showInputDialog(null, null, "Anna uusi PIN uudestaan", JOptionPane.QUESTION_MESSAGE));
                            } catch (Exception e) {
                                break;
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "VÄÄRÄ PIN", "KASSA", JOptionPane.DEFAULT_OPTION);
                        }
                    }else{
                 
                    try {
                        pin = Integer.parseInt(JOptionPane.showInputDialog(null, "ANNA PIN", "KASSA", JOptionPane.QUESTION_MESSAGE));
                    } catch (Exception e) {
                        break;
                    }    
                    if(controller.tarkistapin(pin) == false){
                        JOptionPane.showMessageDialog(null, "VÄÄRÄ PIN", "KASSA", JOptionPane.DEFAULT_OPTION);
                        break;
                    }else{
                    JOptionPane.showMessageDialog(null, controller.kassavalinta(kassaval, uusipin, uusipin1), "KASSA", JOptionPane.DEFAULT_OPTION);
                    break;
                    }
                    }
                    break;

                case "Lopeta":
                    int varma = JOptionPane.showConfirmDialog(null, "Oletko varma?", "LOPETTAMINEN", JOptionPane.YES_NO_OPTION);
                    if (varma == JOptionPane.YES_OPTION) {
                        lopeta = 1;
                    }
                    break;
            }

        }
        return lopeta;
    }
}
