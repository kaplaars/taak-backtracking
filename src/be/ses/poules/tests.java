package be.ses.poules;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class tests {
    @Test
    public void pouleDelingTestDeelbaar(){
        //aantal ploegen per poule
        //arrange
        Poule poule = new Poule();
        //act
        int verdelingresult=Indeling.poulegrote(9, 3);
        //assert
        assertEquals(verdelingresult,3);
    }

    @Test
    public void pouleDelingTestOnDeelbaar(){
        //aantal ploegen per poule
        //arrange
        Poule poule = new Poule();
        //act
        int verdelingresult=Indeling.poulegrote(10, 3);
        //assert
        assertEquals(verdelingresult,4);
    }

    @Test
    public void maxPloegenPerLandPerPouleBereikt() {
        //1 Arrange
        Poule poule = new Poule();
        Land land = new Land("BE", 2);
        Ploeg ploeg1 = new Ploeg("Ploeg1", land);
        Ploeg ploeg2 = new Ploeg("Ploeg2", land);
        Ploeg ploeg3 = new Ploeg("Ploeg3", land);

        poule.voegtoe(ploeg1);
        poule.voegtoe(ploeg2);
        //2 Act
        boolean resultaat = poule.magInPoule(ploeg3);
        //3 Assert
        assertFalse(resultaat);
    }

    @Test
    public void maxPloegenPerLandPerPouleNietBereikt() {
        //1 Arrange
        Poule poule = new Poule();
        Land land = new Land("BE", 2);
        Ploeg ploeg1 = new Ploeg("Ploeg1", land);
        Ploeg ploeg2 = new Ploeg("Ploeg2", land);

        poule.voegtoe(ploeg1);
        //2 Act
        boolean resultaat = poule.magInPoule(ploeg2);
        //3 Assert
        assertTrue(resultaat);
    }

    //Test voor: isPloegCompatibelMetPloegenUitPoule

    //Test of uitkomst geldig is

}