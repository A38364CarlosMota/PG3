package Grupo3;

public class MilitaryAircraft extends Aircraft{

    private final boolean armed;

    public MilitaryAircraft(String flightId, GeoPos p, Route r, boolean armed) throws AirTrafficException{
        super(flightId, p, r);
        this.armed = armed;
    }
    public MilitaryAircraft(String flighId, GeoPos p, Route r) throws AirTrafficException{
        super(flighId,p,r);
        this.armed = false;
    }

    public boolean isArmed(){
        return this.armed;
    }

    public String toString(){
        if(isArmed()){
            return ("Military "+ super.toString() + " (armed)");
        }
        return ("Military "+ super.toString());
    }
}
