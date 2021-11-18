package Grupo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCivitAircraft {
    private static final GeoPos GEO_POS = new GeoPos(32.4534, 85.5687, 10457);
    private static final Route ROUTE = new AltitudeRoute(10000, 11500);

    @Test
    public void testConstruct() throws AirTrafficException {
        CivilAircraft plain = new CivilAircraft("Tap", 320, GEO_POS, ROUTE, 100);
        assertTrue( plain.isFlightId("Tap320") );
        assertFalse( plain.isArmed() );
        assertSame( GEO_POS, plain.getGeoPos() );
        assertEquals( new AltitudeRoute(10000, 11500),  plain.route );
        assertEquals( 100,  plain.getNumberOfPassengers() );
    }

    @Test
    public void testToString() throws AirTrafficException{
            CivilAircraft plain = new CivilAircraft("Tap", 320, GEO_POS, ROUTE, 100);
            assertEquals("Tap320 at 32.4534-85.5687, 10457m", plain.toString() );
     }

    @Test
    public void testExpectedAirTrafficException() {
         AirTrafficException e =assertThrows(AirTrafficException.class, ()->
                new CivilAircraft("Tap", 320, GEO_POS, new AltitudeRoute(10000, 10050), 300));
        assertEquals("Aviso: aeronave fora da rota", e.getMessage());
    }
}