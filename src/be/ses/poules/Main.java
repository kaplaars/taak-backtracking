/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ses.poules;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author u0002531
 */
public class Main {
    public static void main(String[] args) {
        Indeling actie = new Indeling(new ArrayList<String>(List.of("B","NL","D","FR")),
                                      new ArrayList<Integer>(List.of(2,1,5,2)),
                                      new ArrayList<ArrayList<String>>(
                                           List.of(   
                                              new ArrayList<String>(List.of("NL")),
                                              new ArrayList<String>(List.of("D")),
                                              new ArrayList<String>(List.of("FR")),
                                              new ArrayList<String>()
                                           )
                                      ),
                                      new ArrayList<Integer>(List.of(3,3,5,4)),
                6  
        );
        actie.Pouledeler();
        System.out.println(actie);        
    }
}
