import java.util.HashMap;
import java.lang.Integer;
import java.util.Iterator;
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

    /**
     * llegada un nuevo cliente a la cola
     */
    public void llegaNuevoClienteALaCola(int numeroDeBocadillos){
        if(primeraPersonaEnCola == null){
            primeraPersonaEnCola = new Cliente(numeroDeBocadillos);
        }
        else{
            //si solo hay una persona en la cola
            if(primeraPersonaEnCola.getSiguienteEnLaCola() == null){
                primeraPersonaEnCola.setSiguienteEnLaCola(new Cliente(numeroDeBocadillos));
            }
            //si hay mas de uno buscamos al ultimo y se lo asignamoscomo sigueinte en la cola
            else{
                Cliente ultimo = primeraPersonaEnCola.getSiguienteEnLaCola();
                while(ultimo.getSiguienteEnLaCola()!= null){
                    ultimo = ultimo.getSiguienteEnLaCola();
                }
                ultimo.setSiguienteEnLaCola(new Cliente(numeroDeBocadillos));
            }
        }

    }

    public void visualizaDatosClientesEnCola(){
        Cliente cliente = primeraPersonaEnCola;
        while(cliente != null){
            System.out.println(cliente.toString() + " ("+ cliente.getNumeroDeBocadillos()* PRECIO_BOCADILLO + ")");
            cliente = cliente.getSiguienteEnLaCola();
        }

    }

    public void despacharClienteActual(){
        //si hay gente en la cola
        if(primeraPersonaEnCola != null){
            //actulizar facturacion
            facturacionActual += primeraPersonaEnCola.getNumeroDeBocadillos() * PRECIO_BOCADILLO;
            //agregamos a despachados
            clientesDespachados.put(primeraPersonaEnCola.getNumeroCliente(),primeraPersonaEnCola);
            //avance dela cola
            primeraPersonaEnCola = primeraPersonaEnCola.getSiguienteEnLaCola();
        }
    }

    public void visualizaDatosBocateria(){
        System.out.println("Facturacion actual: " + facturacionActual + " euros");
        if(primeraPersonaEnCola != null){
            System.out.println("Estado de la cola:");
            visualizaDatosClientesEnCola();
        }

        if(!clientesDespachados.isEmpty()){

            System.out.println("Clientes despachados:" );
            //recorremos cada cliente ya despachado
            for (Cliente cliente : clientesDespachados.values() ) {
                System.out.println(cliente.toString());
            }
        }
    }

    /**
     *@return numero delprimercliente con mas bocadillos
     */
    public int getPosicionPrimerClienteConMasBocadillos(){
        return 0;

    }

    public void clienteAbandonaCola(int id){

    }

    public void ordenarColaPorNumeroDeBocadillos(){

    }
}
