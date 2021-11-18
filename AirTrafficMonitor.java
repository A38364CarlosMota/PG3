package Grupo3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class AirTrafficMonitor{

    private List<Aircraft> aircrafts = new ArrayList<>();
    private CivilAircraft c;

    public List<Aircraft> getAllAircrafts() {
        return aircrafts;
    }

    public List<Aircraft> find (Predicate<Aircraft> filter){
        List<Aircraft> lista = new ArrayList<>();
        for ( Aircraft a: aircrafts ) {
           if (filter.test(a)) lista.add(a);
       }
       return lista;
    }

    public AirTrafficMonitor append(Aircraft a) throws AirTrafficException {

        for (Aircraft ac : aircrafts)
        {
            if(a.getGeoPos().isNear(ac.getGeoPos())) throw new AirTrafficException("não foi adicionada porque"+
                    " está próxima de uma das aeronave monitorizada") ;
        }

        aircrafts.add(a);

        return this;

    }

    public List<Aircraft> checkRouteAltitudes() {

        Predicate<Aircraft> isCheck = new Predicate<Aircraft>() {
            @Override
            public boolean test(Aircraft a) {
                return a.getGeoPos().getAltitude() > a.route.getMaxAltitude() || a.getGeoPos().getAltitude() < a.route.getMinAltitude();
            }
        };
        List<Aircraft> lista = find(isCheck);

        Comparator<Aircraft> aux = new Comparator<Aircraft>() {
            @Override
            public int compare(Aircraft o1, Aircraft o2) {
                return o2.getGeoPos().getAltitude() - o1.getGeoPos().getAltitude();
            }
        };
        lista.sort(aux);
        return lista;
    }

    public void removeCivilNoPassengers(){

       Predicate<Aircraft> aux = new Predicate<Aircraft>() {
           @Override
           public boolean test(Aircraft a) {
               CivilAircraft aux1;
               if( a instanceof CivilAircraft) {
                   aux1 = (CivilAircraft) a;
                   return aux1.getNumberOfPassengers() == 0 ;
               }else return false;
           }
       };
       this.aircrafts.removeIf(aux);
    }

}
