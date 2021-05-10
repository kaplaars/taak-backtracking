package test;

import be.ses.poules.Indeling;
import be.ses.poules.Land;
import be.ses.poules.Ploeg;
import be.ses.poules.Poule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class tests {

    @Test
    public void pouleDelingTestDeelbaar(){
        //aantal ploegen per poule
        //arrange
        Poule poule = new Poule();
        //act
        int verdelingresult= Indeling.poulegrote(9, 3);
        //assert
        Assertions.assertEquals(verdelingresult,3);
    }

    @Test
    public void pouleDelingTestOnDeelbaar(){
        //aantal ploegen per poule
        //arrange
        Poule poule = new Poule();
        //act
        int verdelingresult=Indeling.poulegrote(10, 3);
        //assert
        Assertions.assertEquals(verdelingresult,4);
    }

    @Test
    public void maxPloegenPerLandPerPouleBereikt() {
        //1 Arrange
        Poule poule = new Poule();
        Land land = new Land("BE", 2);
        Ploeg ploeg1 = new Ploeg("Ploeg1", land);
        Ploeg ploeg2 = new Ploeg("Ploeg2", land);
        Ploeg ploeg3 = new Ploeg("Ploeg3", land);
        Land land2 = new Land("NL", 2);
        land.setIncompatibel(new ArrayList<Land>(List.of(land2)));

        poule.voegtoe(ploeg1);
        poule.voegtoe(ploeg2);
        //2 Act
        boolean resultaat = poule.magInPoule(ploeg3);
        //3 Assert
        Assertions.assertFalse(resultaat);
    }

    @Test
    public void maxPloegenPerLandPerPouleNietBereikt() {
        //1 Arrange
        Poule poule = new Poule();
        Land land = new Land("BE", 2);
        Land land2 = new Land("NL", 2);
        land.setIncompatibel(new ArrayList<Land>(List.of(land2)));

        Ploeg ploeg1 = new Ploeg("Ploeg1", land);
        Ploeg ploeg2 = new Ploeg("Ploeg2", land);

        poule.voegtoe(ploeg1);
        //2 Act
        boolean resultaat = poule.magInPoule(ploeg2);
        //3 Assert
        Assertions.assertTrue(resultaat);
    }

    @Test
    public void incompatibleLandWilInPoule() {
        //1 Arrange
        Poule poule = new Poule();
        Land land = new Land("BE", 2);
        Land land2 = new Land("NL", 1);

        land.setIncompatibel(new ArrayList<Land>(List.of(land2)));

        Ploeg ploeg1 = new Ploeg("BE1", land);
        Ploeg ploeg2 = new Ploeg("NL1", land2);

        poule.voegtoe(ploeg1);
        //2 Act
        boolean resultaat = poule.magInPoule(ploeg2);
        //3 Assert
        Assertions.assertFalse(resultaat);
    }
    @Test
    public void compatibleLandWilInPoule() {
        //1 Arrange
        Poule poule = new Poule();
        Land land = new Land("BE", 2);
        Land land2 = new Land("FR", 2);
        Land land3 = new Land("NL", 1);

        land.setIncompatibel(new ArrayList<Land>(List.of(land3)));
        land2.setIncompatibel(new ArrayList<Land>(List.of()));


        Ploeg ploeg1 = new Ploeg("BE1", land);
        Ploeg ploeg2 = new Ploeg("FR1", land2);

        poule.voegtoe(ploeg1);
        //2 Act
        boolean resultaat = poule.magInPoule(ploeg2);
        //3 Assert
        Assertions.assertTrue(resultaat);
    }

    @Test
    public void LandWilMetIncompatiblePloegenInPoule() {
        //1 Arrange
        Poule poule = new Poule();
        Land land = new Land("BE", 2);
        Land land2 = new Land("NL", 1);
        Land land3 = new Land("D", 3);

        land.setIncompatibel(new ArrayList<Land>(List.of(land2)));
        land2.setIncompatibel(new ArrayList<Land>(List.of(land3)));

        Ploeg ploeg1 = new Ploeg("BE1", land);
        Ploeg ploeg2 = new Ploeg("NL1", land2);

        poule.voegtoe(ploeg2);
        //2 Act
        boolean resultaat = poule.magInPoule(ploeg1);
        //3 Assert
        Assertions.assertFalse(resultaat);
    }
}