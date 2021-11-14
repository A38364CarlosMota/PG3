import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AirTrafficMonitor {

    private List<Aircraft> aircrafts = new ArrayList<>();

    public List<Aircraft> getAllAircrafts() {
        return aircrafts;
    }

    /*public List<Aircraft> find (Predicate<Aircraft> filter){

    }*/
    public AirTrafficMonitor append(Aircraft a) {
        if (aircrafts.isEmpty()) {
            aircrafts.add(a);
        }
        for (Aircraft ac : aircrafts)
        {
        if(a.getGeoPos().isNear(ac.getGeoPos())) throw AirTrafficException("Aviso: Não foi adicionada " +
                "porque está proxima de uma das aeronaves monotorizada") ;
        }
        return AirTrafficMonitor ;

        }
    }
}
