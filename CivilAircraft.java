package Grupo3;

public class CivilAircraft extends Aircraft{

    private int passengerNum;

    public CivilAircraft(String operatorId, int flightNumber, GeoPos p, Route r, int passengersNum) throws AirTrafficException{
        super(operatorId + flightNumber, p, r);
        this.passengerNum = passengersNum;
    }

    public boolean isArmed(){
        return false;
    }
    public int getNumberOfPassengers(){
        return passengerNum;
    }

}
