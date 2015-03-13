import java.util.HashMap;
import java.lang.Integer;
/**
 * simula una bocateria donde se reparten bocadillos a clientes en una cola
 * 
 * @author marcelinojgm
 * @version 1.0
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

    public void llegaNuevoClienteALaCola(){
        
        
    }
}
