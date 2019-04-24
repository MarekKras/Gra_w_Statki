/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gra_w_statki;

import java.util.ArrayList;

/**
 *
 * @author Marek
 */
public class PortalGraMax {
     private PomocnikGry pomocnik = new PomocnikGry();
  private ArrayList<Portal> listaPortali = new ArrayList<Portal>(); 
  private int iloscRuchow = 0; 

  private void przygotujGre() {   
    // najpierw tworzymy portale i określamy ich położenie
    Portal pierwszy = new Portal();
    pierwszy.setNazwa("onet.pl");
    Portal drugi = new Portal();
    drugi.setNazwa("wp.com");
    Portal trzeci = new Portal();
    trzeci.setNazwa("Go2.com");
    listaPortali.add(pierwszy);
    listaPortali.add(drugi);
    listaPortali.add(trzeci);

    System.out.println("Twoim celem jest zatopienie trzech portali.");
    System.out.println("onet.pl, wp.pl, Go2.com");
    System.out.println("Każdy z portali ma wymiar 3 kratek i znajdują się one na planszy o wymiarach 7x7( A-G),(0-6) ");
    System.out.println("Postaraj się je zatopić w jak najmniejszej ilości ruchów.");
     
    for (Portal rozmieszczanyPortal : listaPortali) {                 
      ArrayList<String> nowePolozenie = pomocnik.rozmiescPortal(3);   
      rozmieszczanyPortal.setPolaPolozenia(nowePolozenie);
    } // koniec pętli for
  } // koniec metody

  private void rozpocznijGre() { 
    while(!listaPortali.isEmpty()) {
      String ruchGracza = pomocnik.pobierzDaneWejsciowe("Podaj pole:"); 
      sprawdzRuchGracza(ruchGracza);
    } // koniec while
    zakonczGre();
  } // koniec metody

  private void sprawdzRuchGracza(String ruch) {
    iloscRuchow++;
    String wynik  = "pudło"; // początkowo zakładamy że gracz spudłował
    for (Portal portalDoSprawdzenia : listaPortali) {     
      wynik = portalDoSprawdzenia.sprawdz(ruch);   
      if (wynik.equals("trafiony")) {
        break;
      }
      if (wynik.equals("zatopiony")) {
        listaPortali.remove(portalDoSprawdzenia); // już po nim !
        break;
      }  
    } // koniec pętli for
    System.out.println(wynik);
  }

  private void zakonczGre() {
    System.out.println("Wszystkie Portale zostały zatopione! Teraz Twoje informacje nie mają znaczenia.");
    if (iloscRuchow <= 18) {
      System.out.println("Wykonałeś jedynie " + iloscRuchow + " ruchów.");
      System.out.println("Wydostałeś się, zanim Twoje informacje zatonęły.");
    } else {
      System.out.println("Ale się grzebałeś! Wykonałeś aż "+ iloscRuchow + " ruchów.");
      System.out.println("Teraz rybki pływają pomiędzy Twoimi informacjami.");
    }
  }  // koniec metody
   
  
  public static void main (String[] args) {
    PortalGraMax gra = new PortalGraMax();
    gra.przygotujGre();
    gra.rozpocznijGre();
  }
}

