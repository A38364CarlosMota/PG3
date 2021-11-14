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
        return geoPos;
    }

    public final boolean isFligthId(String id){
        return this.flightId.equals(id);
    }

    public String toString(){
        return flightId + " at " + geoPos;
    }
}
