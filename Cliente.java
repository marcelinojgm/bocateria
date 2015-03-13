
/**
 * cliente de una bocateria
 * 
 * @author marcelinojgm
 * @version 1.0
 */
public class Cliente
{
    // instance variables - replace the example below with your own
    private int numeroCliente;
    private Cliente siguienteEnCola;
    private int numeroDeBocadillos;
    private static int numeroClienteActual = 1;

    /**
     * Constructor for objects of class Cliente
     * @param numeroDeBocadillos numerode bocadillos que va acomprar
     */
    public Cliente(int numeroDeBocadillos)
    {
        numeroCliente = 0;
        siguienteEnCola = null;
        this.numeroDeBocadillos = numeroDeBocadillos;

    }

    /**
     * 
     */
    public Cliente getSiguienteEnLaCola(){
        return null;
    }

    /**
     * retorna el numero de bocadillos que compra
     * @return numeroDeBocadillos
     */
    public int getNumeroDeBocadillos(){
        return 0;
    }

    /**
     * numero del cliente
     * @return retorna el numero del cliente
     */
    public int intgetNumeroCliente(){
        return 0;
    }

    /**
     * datos del cleinte
     */
    public String toString(){
        return "";

    }

    /**
     * selecciona el siguiente cliente enla cola
     */
    public void setSiguienteEnLaCola(Cliente cliente){

    }
}
