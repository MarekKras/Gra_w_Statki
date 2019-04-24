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
class Portal {

private ArrayList<String> polaPolozenia;                    
  // int iloscTrafien; (już niepotrzebne)

  private String nazwa;
	

  public void setPolaPolozenia(ArrayList<String> ppol) {
    polaPolozenia = ppol;
  }

  public void setNazwa(String nzwPortalu) {
    nazwa = nzwPortalu;  
  }

  
  public String sprawdz(String ruch) {
  
    String wynik = "pudło";

    int indeks = polaPolozenia.indexOf(ruch);
    
    if (indeks >= 0) {
    
      polaPolozenia.remove(indeks);
      
      if (polaPolozenia.isEmpty()) {
        wynik = "zatopiony";
      } else {
        wynik = "trafiony";
      } // koniec if
      
    } // koniec if
    
    return wynik;
  } // koniec metody
} // koniec klasy
