/*
package trab1.grupo3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class TestAirTrafficMonitor {

   private static final Route ROUTE = new AltitudeRoute(10000, 19000);

    private static Aircraft[] allAircrafts;
    private static Aircraft[] militaryAircrafts;

    private Aircraft[] getAircrafts() throws AirTrafficException {
        if ( allAircrafts != null) return allAircrafts;
        militaryAircrafts = new Aircraft[]{
            new MilitaryAircraft("FAPT357", new GeoPos(32.4534, 85.5687, 15457), ROUTE, true),
            new MilitaryAircraft("FAPT380", new GeoPos(32.4534, 85.5687, 16457), ROUTE),
        };
        return allAircrafts = new Aircraft[]{
            new CivilAircraft("FR", 6067, new GeoPos(32.4534, 85.5687, 10457), ROUTE, 0),
            new CivilAircraft("Tap", 320, new GeoPos(32.4534, 85.5687, 12457), ROUTE, 100),
            new CivilAircraft("LH", 1778, new GeoPos(32.4534, 85.5687, 14457), ROUTE, 0),
            militaryAircrafts[0],
            militaryAircrafts[1],
            new CivilAircraft("AF", 1624, new GeoPos(32.4534, 85.5687, 18457), ROUTE, 0),
        };
    }

    @Test
    public void testAppend() throws AirTrafficException{
        AirTrafficMonitor monitor = new AirTrafficMonitor();
        Aircraft[] aircrafts = getAircrafts();
        int size = 0;
        for( Aircraft a: aircrafts ) {
            ++size;
            monitor.append( a );
            assertEquals( size, monitor.getAircrafts().size());
            assertTrue(monitor.getAircrafts().contains( a ));
        }
        assertEquals( Arrays.asList( aircrafts ), monitor.getAircrafts() );
    }

    private AirTrafficMonitor getAirTraficMonitor( ) throws AirTrafficException {
        AirTrafficMonitor monitor = new AirTrafficMonitor();
        for (Aircraft a : getAircrafts())
                monitor.append(a);
        return monitor;
    }

    @Test
    public void testFind() throws AirTrafficException {
        AirTrafficMonitor monitor = getAirTraficMonitor();
        List<Aircraft> l = monitor.find( a -> a instanceof MilitaryAircraft );
       // assertTrue(l.equals( militaryAircrafts ));
        assertEquals(Arrays.asList(militaryAircrafts), l );
    }

    @Test
    public void testcheckRouteAltitudes() throws AirTrafficException {
        AirTrafficMonitor monitor = getAirTraficMonitor();
        List<Aircraft> aircrafts = monitor.getAircrafts();
        aircrafts.get( 0 ).setGeoPos(new GeoPos(32.4534, 85.5687, ROUTE.getMinAltitude()-1000));
        aircrafts.get(aircrafts.size()-1 ).setGeoPos(new GeoPos(32.4534, 85.5687, ROUTE.getMaxAltitude()+1000));
        List<Aircraft> l = monitor.checkRouteAltitudes( );
        assertEquals( Arrays.asList( aircrafts.get(aircrafts.size()-1 ), aircrafts.get(0)) , l);
    }

    @Test
    public void testRemoveCivilNoPassengers() throws AirTrafficException {
        AirTrafficMonitor monitor = getAirTraficMonitor();
        List<Aircraft> aircrafts = monitor.getAircrafts();
        int size= aircrafts.size();
        monitor.removeCivilNoPassengers();
        assertEquals( size-3, aircrafts.size());
        for ( Aircraft a:aircrafts ) {
            if ( a instanceof CivilAircraft c)
                assertTrue( c.getPassengersNum() != 0 );
        }
    }

    @Test
    public void testExpectedAirTrafficException() throws AirTrafficException {
        AirTrafficMonitor monitor = getAirTraficMonitor();
        AirTrafficException e =assertThrows(AirTrafficException.class, ()-> monitor.append( allAircrafts[0]));
        assertEquals("Aviso: não foi adicionada porque está próxima de uma das aeronave monitorizada", e.getMessage());
        assertThrows(AirTrafficException.class, ()-> monitor.append( allAircrafts[allAircrafts.length/2]));
        assertThrows(AirTrafficException.class, ()-> monitor.append( allAircrafts[allAircrafts.length-1]));
    }

}
*/