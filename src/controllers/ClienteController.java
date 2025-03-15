
package controllers;

/**
 *
 * @author karen_b
 */
import dao.ClienteDAO;
import java.util.List;
import models.Cliente;

public class ClienteController {
    
    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }
    
    public void agregarCliente(String nombre, String email, String telefono, int estado, String direccion){
        Cliente cliente = new Cliente(nombre, email, telefono, estado, direccion);
        clienteDAO.agregarCliente(cliente);
        System.out.println("Cliente agregado exitosamente");
    }
    
    public List<Cliente> obtenerCliente(){
       return clienteDAO.getCliente();
    }
     
    public void updateCliente(int id, String telefono,  String email){
        clienteDAO.updateCliente(id, telefono, email);
        System.out.println("Cliente actualizado exitosamente");
    }
      
    public void deleteCliente(int id, int estado){
        clienteDAO.deleteCliente(id, estado);
        System.out.println("Cliente inactivo exitosamente");
    }
}
