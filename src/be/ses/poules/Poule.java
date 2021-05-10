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

    /**
     *
     * @param huidigploeg
     * @return true/false
     */
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

    /**
     *
     * @param huidigePloeg
     * @return true/false
     */
    public boolean magInPoule(Ploeg huidigePloeg) {
        // mag deze ploeg met de andere ploegen in de poule
        for (Ploeg ploeg : this.ploegen) {      //elke ploeg die in poule zit chekken
            for (Land incompatibleLand : ploeg.getLand().getIncompatibel()) {   //elk incompatibel land van die ploeg
                if(huidigePloeg.getLand().getNaam() == incompatibleLand.getNaam()){
                    return false;
                }
            }
        }
        // mogen de landen in deze poule met de nieuwe ploeg
        for (Ploeg ploeg : this.ploegen){
            for(Land huidigincompatible : huidigePloeg.getLand().getIncompatibel()){
                if(ploeg.getLand().getNaam() == huidigincompatible.getNaam()){
                    return false;
                }
            }
        }
        return issMaxCountryBereikt(huidigePloeg);
    }

    @Override
    public String toString() {
        return "Poule{" + "ploegen=" + ploegen + '}';
    }



}
