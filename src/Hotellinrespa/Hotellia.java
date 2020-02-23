/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotellinrespa;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Hotellia {

    static Scanner sc = new Scanner(System.in);

    final int huoneA = 240;
    final int huoneB = 100;
    final int huoneC = 70;

    int määräA = 10;
    int määräB = 50;
    int määräC = 100;

    private int hinta;

    public int getHuone(int tyyppi, int määrä, int kesto) {

        switch (tyyppi) {

            case 1:
                if (määrä <= määräA) {

                    hinta = huoneA * määrä * kesto;
                    määräA -= määrä;

                } else {
                    hinta = 0;
                }
                break;

            case 2:
                if (määrä <= määräB) {
                    hinta = huoneB * määrä * kesto;
                    määräB -= määrä;

                } else {
                    hinta = 0;

                }
                break;

            case 3:
                if (määrä <= määräC) {

                    hinta = (huoneC * määrä * kesto);
                    määräC -= määrä;
                } else {
                    hinta = 0;
                }

        }
        return hinta;
    }

    public int getHuonemäärä(String tyyppi) {
        int tulos =1;
        switch (tyyppi) {

            case "Sviitti":
                tulos = määräA;
                break;
            case "Perhehuone":
                tulos = määräB;
                break;
            case "Parihuone":
                tulos = määräC;
                break;
        }
        return tulos;
    }

}
