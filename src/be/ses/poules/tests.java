package be.ses.poules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class tests {
    @Test
    public void pouleDelingTestDeelbaar(){
        //aantal ploegen per poule
        //arrange
        Poule poule = new Poule();
        //act
        int verdelingresult=poule.pouledeler(9);
        //assert
        assertEquals(verdelingresult,3);
    }

    @Test
    public void pouleDelingTestOnDeelbaar(){
        //aantal ploegen per poule
        //arrange
        Poule poule = new Poule();
        //act
        int verdelingresult=poule.pouledeler(10);
        //assert
        assertEquals(verdelingresult,4);
    }

}