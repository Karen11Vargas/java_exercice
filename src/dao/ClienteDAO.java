
package dao;

/**
 *
 * @author karen_b
 */

import config.DatabaseConnection;
import models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    public void agregarCliente(Cliente cliente){
        String sql = "INSERT INTO clientes(nombre, email, telefono, direccion) VALUES (?,?,?,?)";
        
        try (Connection connection =  (Connection) DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
           stmt.setString(1, cliente.getNombre());
           stmt.setString(2, cliente.getEmail());
           stmt.setString(3, cliente.getTelefono());
           stmt.setString(4, cliente.getDireccion());

           int filas =  stmt.executeUpdate();
            if (filas >0) {
                try (ResultSet  generatedKeys = stmt.getGeneratedKeys()){
                    if (generatedKeys.next()) {
                        cliente.setId(generatedKeys.getInt(1));
                    }
                } catch (SQLException sQLException) {
                }
            }
                    
        } catch (SQLException e) {
            System.out.println("Error al agregar el cliente:" + e.getMessage());
        }
    }
    
     public  List<Cliente>getCliente(){
        List<Cliente> clientes = new ArrayList<>();
        
        String sql = "SELECT * FROM clientes WHERE estado = 1";
        
        try (Connection connection =  (Connection) DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"), rs.getInt("estado"), rs.getString("direccion"));
                clientes.add(cliente);
                
            }
            
                    
        } catch (SQLException e) {
            System.out.println("Error al obtener clientes:" + e.getMessage());
        }
        return clientes;
    }
     
    public void updateCliente(int id, String telefono, String email){
        String sql = "UPDATE clientes SET telefono = ?, email = ? WHERE id = ?";
        
        try (Connection connection =  (Connection) DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
           stmt.setString(1, telefono);
           stmt.setString(2, email);
           stmt.setInt(3, id);

           stmt.executeUpdate();
           
                    
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente:" + e.getMessage());
        }
    }
     
   
    public void deleteCliente(int id, int estado){
        String sql = "UPDATE clientes SET estado = ? WHERE id = ?";
        
        try (Connection connection =  (Connection) DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
           stmt.setInt(1, estado);
           stmt.setInt(2, id);

          stmt.executeUpdate();
           
                    
        } catch (SQLException e) {
            System.out.println("Error al eliminar - inactivar el cliente:" + e.getMessage());
        }
    }
     
}
