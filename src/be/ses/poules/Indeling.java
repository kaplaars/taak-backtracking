/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ses.poules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

/**
 *
 * @author u0002531
 */
public class Indeling {
    private ArrayList<Ploeg> ploegen;
    private ArrayList<Land> landen;
    private ArrayList<Poule> poules;

    private Indeling(int aantalPoules) {
        poules = new ArrayList<>();
        for (int i=0; i<aantalPoules; i++) {
            poules.add(new Poule());
        }
    }
    
    public Indeling(ArrayList<Ploeg> ploegen, ArrayList<Land> landen, int aantalPoules) {
        this(aantalPoules);
        this.ploegen = ploegen;
        this.landen = landen;
    }
    
    public Indeling(ArrayList<String> namenLand, ArrayList<Integer> maxima, 
                    ArrayList<ArrayList<String>> incompatibel, ArrayList<Integer> aantallen, int aantalPoules) {
        this(aantalPoules);
        ploegen = new ArrayList<>();
        landen = new ArrayList<>();
        
        
        for (int i = 0; i<namenLand.size(); i++) {
            String naam = namenLand.get(i);
            Land l = new Land(naam, maxima.get(i));
            landen.add(l);
            for (int j=1; j<aantallen.get(i)+1; j++) {
                ploegen.add(new Ploeg(naam+j, l));                
            }
        }
        
        for (int i = 0; i<incompatibel.size(); i++) {
            ArrayList<Land> incompat = new ArrayList<>();
            for (String landNaam : incompatibel.get(i)) {
                Optional<Land> land = getLandOpNaam(landNaam);
                if (land.isPresent()) {
                    incompat.add(land.get());
                }
            }
            landen.get(i).setIncompatibel(incompat);
        }        

        /*zet eens uit commentaar:  Collections.reverse(ploegen);*/
    }

    public Optional<Land> getLandOpNaam(String naam) {
        for (Land l : landen) {
           if (l.getNaam().equals(naam)) {
               return Optional.of(l);
           }    
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "Indeling{" + "ploegen=" + ploegen + ", landen=" + landen + ", poules=" + poules + '}';
    }

    /**
     * @return the ploegen
     */
    public ArrayList<Ploeg> getPloegen() {
        return ploegen;
    }

    /**
     * @return the landen
     */
    public ArrayList<Land> getLanden() {
        return landen;
    }

    /**
     * @return the poules
     */
    public ArrayList<Poule> getPoules() {
        return poules;
    }

    public  void Pouledeler() {
        int route = 0;
        poules.get(0).voegtoe(ploegen.get(0));                      //zet ploeg 1 in poule 1
        for (int i = 1; i < ploegen.size(); i++) {
            System.out.println("ik check nu ploegnr" + i);
            if (poules.get(0).magInPoule(ploegen.get(i)) && route % 10 < 1){
                System.out.println("ik zet nu ploegnr " + i + "in poule 1");
                poules.get(0).voegtoe(ploegen.get(i));
                route = route * 10;
                route = +1;
            }else if(poules.get(1).magInPoule(ploegen.get(i)) && route % 10 < 2){
                System.out.println("ik zet nu ploegnr " + i + " in poule 2");
                poules.get(1).voegtoe(ploegen.get(i));
                route = route * 10;
                route = +2;
            }else if(poules.get(2).magInPoule(ploegen.get(i)) && route % 10 < 3) {
                System.out.println("ik zet nu ploegnr " + i + " in poule 3");
                poules.get(2).voegtoe(ploegen.get(i));
                route = route * 10;
                route = +3;
            }else if(poules.get(3).magInPoule(ploegen.get(i)) && route % 10 < 4) {
                System.out.println("ik zet nu ploegnr " + i + " in poule 4");
                poules.get(3).voegtoe(ploegen.get(i));
                route = route * 10;
                route = +4;
            }else if(poules.get(4).magInPoule(ploegen.get(i)) && route % 10 < 5) {
                System.out.println("ik zet nu ploegnr " + i + " in poule 5");
                poules.get(4).voegtoe(ploegen.get(i));
                route = route * 10;
                route = +5;
            }else if(poules.get(5).magInPoule(ploegen.get(i)) && route % 10 < 6) {
                System.out.println("ik zet nu ploegnr " + i + " in poule 6");
                poules.get(5).voegtoe(ploegen.get(i));
                route = route * 10;
                route = +6;
            }else{
                System.out.println("ik ga een stap terug in de boom");
                route = route/10;
                route = +1;
                i = i-1;
            }
        }
    }
    
}
