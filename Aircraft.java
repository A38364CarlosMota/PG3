package Grupo3;

public abstract class  Aircraft {
    private String flightId;
    private GeoPos geoPos;
    public final Route route;

    public Aircraft ( String flightId, GeoPos p, Route r ) throws AirTrafficException{
        this.flightId = flightId;
        this.geoPos = p;
        this.route = r;
        if( p.getAltitude() > r.getMaxAltitude() || p.getAltitude() < r.getMinAltitude()) throw new AirTrafficException() ;
    }
    public abstract boolean isArmed();

    public GeoPos getGeoPos(){
        return this.geoPos;
    }

    public final boolean isFlightId(String id){
        return this.flightId.equals(id);
    }

    public String toString(){
        return flightId + " at " + geoPos;
    }

    public GeoPos setGeoPos(GeoPos p){
        GeoPos aux = getGeoPos();
        this.geoPos = p;

        return aux;
    }
}
