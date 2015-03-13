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
    
    /**
     * visualiza los datos de bocateria 
     * facturacion
     * datos de las personas en cola
     * datos de las peronas ya depachadas
     */
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
     *@return numero del primercliente con mas bocadillos si no hay nadie en cola -1
     */
    public int getPosicionPrimerClienteConMasBocadillos(){
        int num = -1;
        //si hay gente en la cola
        if(primeraPersonaEnCola != null){
            Cliente cliente = primeraPersonaEnCola;
            //mayor numero de bocadillos
            int bocadillos = 0;
            //recorremos todos los clientes en lacola
            while(cliente != null){
                //bocadillos delcliente actual
                int newBocadillos = cliente.getNumeroDeBocadillos();
                //si tiene mayor numero de bocadillos que el gurdado guardamos su numero
                if (bocadillos < newBocadillos){
                    bocadillos = newBocadillos;
                    num = cliente.getNumeroCliente();
                }
                cliente = cliente.getSiguienteEnLaCola();
            }

        }
        return num;
    }

    public void clienteAbandonaCola(int id){

    }

    public void ordenarColaPorNumeroDeBocadillos(){

    }
}
