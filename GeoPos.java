public class GeoPos {

    private double la, lo;
    private int al;

    public GeoPos(double la, double lo, int al ){
        this.la = la;
        this.lo = lo;
        this.al = al;
    }
    public int getAltitude(){
        return this.al;
    }
    public double getLongitude(){
        return this.lo;
    }
    public double getLatitude(){
        return this.la;
    }

    public boolean isNear ( GeoPos p){
        return Math.abs(this.al - al) < 1000;
    }

    public String toString(){
        return ( this.la + "-" + this.lo + ", " + this.al+"m");
    }


}
