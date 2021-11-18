package Grupo3;

import Grupo1.City;
import Grupo2.CompoundPath;
import Grupo2.Path;
import Grupo2.Place;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//Realizar os três testes para a classe AltitudeRoute
public class TestAltitudeRoute {

    private static final AltitudeRoute Um= new AltitudeRoute(10, 100);



    @Test
    public void testEquals() {
        assertTrue(Um.equals(new AltitudeRoute(10,100)));
    }

    @Test
    public void testConstruct() {
        int a = 12000;
        AltitudeRoute teste = new AltitudeRoute(800, 12000);
        assertTrue(teste.getMaxAltitude());
    }

    @Test
    public void testToString() {
    }
}
