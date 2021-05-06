/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ses.poules;

import java.util.ArrayList;

/**
 *
 * @author u0002531
 */
public class Poule {
    private ArrayList<Ploeg> ploegen;

    public Poule() {
        ploegen = new ArrayList<>();
    }



    /**
     * @return the ploegen
     */
    public ArrayList<Ploeg> getPloegen() {
        return ploegen;
    }

    public void voegtoe(Ploeg p) {
        ploegen.add(p);
    }
    
    public void verwijder(Ploeg p) {
        ploegen.remove(p);
    }
    
    public int getAantal() {
        return ploegen.size();
    }

    public boolean issMaxCountryBereikt(Ploeg huidigploeg){
        //check of max landen in poule bereikt
        int count = 0;
        for (Ploeg ploeg : this.ploegen){
            if(ploeg.getLand() == huidigploeg.getLand()){
                count++;
            }
        }
        if(count < huidigploeg.getLand().getMaxAantal()){
            return true;
        }else{
            return false;
        }
    }

    public boolean magInPoule(Ploeg huidigePloeg){
        //check of landen samen mogen
        for(Ploeg ploeg : this.ploegen){
            if (ploeg.getLand().getIncompatibel().contains(huidigePloeg.getLand())) {
                System.out.println("false");
                return false;
            }
        }
        return issMaxCountryBereikt(huidigePloeg);
    }

    @Override
    public String toString() {
        return "Poule{" + "ploegen=" + ploegen + '}';
    }

    public int pouledeler(int aantalploegen){
        if(aantalploegen % 3 == 0 ){
            return aantalploegen/3;
        }else {
            return (aantalploegen / 3) + 1;
        }
    }

}
