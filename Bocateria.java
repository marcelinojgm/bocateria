import java.util.HashMap;
import java.lang.Integer;
/**
 * Write a description of class Bocateria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bocateria
{
   private Cliente primeraPersonaEnCola; 
   private int facturacionActual;
   private HashMap<Integer,Cliente> clientesDespachados;
   private int PRECIO_BOCADILLO = 5;

    /**
     * Constructor for objects of class Bocateria
     */
    public Bocateria()
    {
        primeraPersonaEnCola = null;
        facturacionActual = 0;
        clientesDespachados = new HashMap<>();
      
    }

    
}
