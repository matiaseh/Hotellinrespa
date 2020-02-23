/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotellinrespa;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Tommi
 */
public class Controller {

    Näkymä näkymä = new Näkymä(this);
    Huonepalvelu huonepalvelu = new Huonepalvelu();
    Hotellia huone = new Hotellia();
    private Map<String, Lasku> lista = new HashMap();
    private Map<String, Double> tuotteet = new HashMap();
    PIN pin = new PIN();
    Kassa kassa = new Kassa();
    Kauppa kauppa = new Kauppa();

    void Lisäälaskulistaan(String nimi, int hinta) {
        Lasku lasku = new Lasku(hinta);
        lista.put(nimi, lasku);

    }

    public double haelasku(String nimi) {
        Lasku lasku = lista.get(nimi);
        double hinta = lasku.getLasku();



        return hinta;

    }

    public void kasvataLaskua(String asiakas, double hinta) {
        lista.get(asiakas).LisääLaskuun(hinta);
    }

    public String[] haeTuoteLista() {
        int koko = tuotteet.size();

        String[] map = new String[koko];
        int i = 0;
        for (Map.Entry<String, Double> pari : tuotteet.entrySet()) {
            map[i] = pari.getKey();

            i++;

        }
        return map;
    }

    public String[] haeAsiakasLista() {
        int koko = lista.size();

        String[] taulukko = new String[koko];
        int i = 0;
        for (Map.Entry<String, Lasku> pari : lista.entrySet()) {
            taulukko[i] = pari.getKey();

            i++;

        }

        return taulukko;
    }

    public void poistaLasku(String nimi) {
        lista.remove(nimi);
    }

    public int huonevalinta(String tyyppi, int huoneidenmäärä, int kesto) {
        int hinta;

        switch (tyyppi) {

            case "Sviitti":
                hinta = huone.getHuone(1, huoneidenmäärä, kesto);
                break;
            case "Perhehuone":
                hinta = huone.getHuone(2, huoneidenmäärä, kesto);
                break;
            case "Parihuone":
                hinta = huone.getHuone(3, huoneidenmäärä, kesto);
                break;
            default:
                hinta = 0;

        }
        return hinta;
    }

    public String palveluvalinta(String valinta, String asiakas) {
        String tulos;
        double hinta = huonepalvelu.huonepalvelu(valinta);
        if (hinta == 0) {
            tulos = "Huonepalvelun tilaaminen ei onnistunut";
        } else {
            tulos = "Huonepalvelun hinta (" + hinta + "€) lisätty laskuun";
            kasvataLaskua(asiakas, hinta);
        }

        return tulos;
    }

    public int huoneLkm(String type) {
        return huone.getHuonemäärä(type);
    }

    public boolean tarkistapin(int vanhapin) {
        if (pin.koodi(vanhapin)) {
            return true;
        }
        return false;
    }

    public String kassa(int koodi, double hinta) {
        String x;
        if (pin.koodi(koodi)) {
            kassa.setRaha(hinta);
            x = hinta + "€ MAKSETTU";

        } else {
            x = "MAKSU EPÄONNISTUI";
        }
        return x;
    }

    public String kassavalinta(String kassaval, int uusipin, int uusipin1) {
        String tulos = "ASD";

        switch (kassaval) {
            case "Laske kassa":
                tulos = "Kassassa on " + kassa.getRaha() + " euroa";
                break;

            case "Vaihda PIN":
                if (uusipin == uusipin1) {
                    pin.setPIN(uusipin);
                    tulos = "PIN vaihto onnistui";
                } else {
                    tulos = "PIN vaihto ei onnistunut";
                }

        }
        return tulos;
    }

    public double kauppa(String tuote) {
        double hinta = kauppa.getHinta(tuote);

        return hinta;
    }

    private void operoi() {
        int lopeta = 0;
        do {
            lopeta = näkymä.valinta();
        } while (lopeta != 1);

    }

    static public void main(String[] args) {
        Controller controller = new Controller();
        controller.operoi();
        System.exit(0);
    }

}
