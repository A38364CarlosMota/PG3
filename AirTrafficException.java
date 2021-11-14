public class AirTrafficException extends Exception{

    public AirTrafficException(){
        super("Aviso: aeronave fora da rota");
    }

    public AirTrafficException(String msg){
        super("Aviso: " + msg);
    }

}