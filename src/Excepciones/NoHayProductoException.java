package Excepciones;

public class NoHayProductoException extends Exception{
    
    public NoHayProductoException(String txt){
        super(txt);
    }
}
