package Grupo3;

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

    public boolean equals( Object o){
        if( o instanceof AltitudeRoute a){
          //  AltitudeRoute a = (AltitudeRoute)o ;
            return this.min==a.min && this.max == a.max ;
        }
        return false;
    }
}
