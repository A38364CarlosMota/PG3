public class AltitudeRoute implements Route {

    public int min;
    public int max;

    public AltitudeRoute(int min, int max){
       this.min = min;
       this.max = max;
    }

    public int getMinAltitude(){
        return this.min;
    }

    public int getMaxAltitude(){
        return this.max;
    }
}
