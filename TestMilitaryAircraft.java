package Grupo3;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMilitaryAircraft {
    private static final  GeoPos GEO_POS1 = new GeoPos(32.4534, 85.5687, 10100);
    private static final GeoPos GEO_POS2 = new GeoPos(32.5534, 87.5689, 10250);
    private static final Route ROUTE = new AltitudeRoute(10000, 11500);

    private void testGetters(MilitaryAircraft c, String  flightId, GeoPos g, Route r, boolean armed) {
        assertTrue(c.isFlightId(new String(flightId)));
        assertEquals(armed, c.isArmed());
        assertSame( g, c.getGeoPos() );
        assertEquals( r,  c.route );
    }

    @Test
    public void testConstruct() throws AirTrafficException {
        MilitaryAircraft m1 = new MilitaryAircraft("FAPT357", GEO_POS1, ROUTE, true);
        testGetters(m1, "FAPT357", GEO_POS1, ROUTE, true );
        MilitaryAircraft m2 = new MilitaryAircraft("FAPT357", GEO_POS1, ROUTE, false);
        testGetters(m2, "FAPT357", GEO_POS1, ROUTE, false );
        MilitaryAircraft m3 = new MilitaryAircraft("FAPT380", GEO_POS2, ROUTE);
        testGetters(m3, "FAPT380", GEO_POS2, ROUTE, false );
    }

    @Test
    public void testToString() throws AirTrafficException{
        Aircraft m1 = new MilitaryAircraft("FAPT357", GEO_POS1, ROUTE, true);
        assertEquals("Military FAPT357 at 32.4534-85.5687, 10100m (armed)", m1.toString() );
        MilitaryAircraft m2 = new MilitaryAircraft("FAPT380", GEO_POS2, ROUTE);
        assertEquals("Military FAPT380 at 32.5534-87.5689, 10250m", m2.toString() );
    }

    @Test
    public void testSetPosGeo() throws AirTrafficException{
            MilitaryAircraft m = new MilitaryAircraft("FAPT357", GEO_POS1, ROUTE, true);
            assertSame(GEO_POS1, m.getGeoPos() );
            assertSame(GEO_POS1,  m.setGeoPos(GEO_POS2));
            assertSame(GEO_POS2, m.getGeoPos() );
    }

    @Test
    public void testExpectedAirTrafficException() {
        AirTrafficException e =assertThrows(AirTrafficException.class, ()->
                new MilitaryAircraft("FAPT357", GEO_POS1, new AltitudeRoute(10000, 10050), true));
        assertEquals("Aviso: aeronave fora da rota", e.getMessage());
    }

}
