
package views;

/**
 *
 * @author karen_b
 */

import controllers.ClienteController;
import java.util.List;
import java.util.Scanner;
import models.Cliente;
public class ClienteView {
    private ClienteController clienteController;
    private Scanner entrada;

    public ClienteView() {
        this.clienteController = new ClienteController();
        this.entrada = new Scanner(System.in);
    }

    
    public void mostrarMenu(){
        int opcion;
        do{
            System.out.println("---- BIENVENIDOS -----");
            System.out.println("---- KAREN LISETH VARGAS -----");
            System.out.println("---- 1011201964 -----");
            System.out.println("---- MENU CLIENTES - VETERINARIA -----");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Mostrar Cliente");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Inactivar Cliente");
            System.out.println("5. Salir");
            opcion = entrada.nextInt();
            entrada.nextLine();
            
            switch (opcion) {
                case 1:
                    agregarCliente();
                break;
               
                case 2:
                    mostrarCliente();
                break;
                
                case 3:
                    actualizarCliente();
                break;
                
                case 4:
                    inactivarCliente();
                break;
                case 5:
                    System.out.println("Gracias por usar nuestros servicios, adios :)");
                break;
                default:
                    System.out.println("Opción invalida");

            }

        }while(opcion  !=5);
    }
    
    public void agregarCliente(){
        System.out.println(" -------- Agregar Cliente -------");
        System.out.println(" Nombre: ");
        String nombre = entrada.nextLine();
        System.out.println(" Email: ");
        String email = entrada.nextLine();
        System.out.println(" Telefono: ");
        String telefono = entrada.nextLine();
        System.out.println(" Dirección: ");
        String direccion = entrada.nextLine();
        
        clienteController.agregarCliente(nombre, email, telefono, 1, direccion);
        System.out.println("Cliente agregado con exito");

    }
    
    public void mostrarCliente(){
        System.out.println(" -------- Mostrar Cliente -------");
        List<Cliente> clientes = clienteController.obtenerCliente();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        }else{
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
            
        }
 
    }
    
     public void actualizarCliente(){
        System.out.println(" -------- Actualizar Cliente -------");
        System.out.println(" id Cliente: ");
        int  id = Integer.parseInt(entrada.nextLine());
        System.out.println(" Email: ");
        String email = entrada.nextLine();
        System.out.println(" Telefono: ");
        String telefono = entrada.nextLine();
      
        clienteController.updateCliente(id, telefono, email);
        System.out.println("Cliente Actualizado con exito");
        
    }
    
    public void inactivarCliente(){
        System.out.println(" -------- Inactivar Cliente -------");
        System.out.println(" id Cliente: ");
        int  id = Integer.parseInt(entrada.nextLine());
      
        clienteController.deleteCliente(id, 0);
        System.out.println("Cliente Eliminado con exito");
    }
    
    
}
