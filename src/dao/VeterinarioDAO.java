/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author karen_b
 */

import config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Veterinario;

public class VeterinarioDAO {
    public void agregarVeterinario(Veterinario veterinario){
        String sql = "INSERT INTO veterinarios(nombre, email, telefono, especialidad) VALUES (?,?,?,?)";
        
        try (Connection connection =  (Connection) DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
           stmt.setString(1, veterinario.getNombre());
           stmt.setString(2, veterinario.getEmail());
           stmt.setString(3, veterinario.getTelefono());
           stmt.setString(4, veterinario.getEspecialidad());

           int filas =  stmt.executeUpdate();
            if (filas >0) {
                try (ResultSet  generatedKeys = stmt.getGeneratedKeys()){
                    if (generatedKeys.next()) {
                        veterinario.setId(generatedKeys.getInt(1));
                    }
                } catch (SQLException sQLException) {
                }
            }
                    
        } catch (SQLException e) {
            System.out.println("Error al agregar el veterinario:" + e.getMessage());
        }
    }
    
     public  List<Veterinario>getVeterinario(){
        List<Veterinario> veterinarios = new ArrayList<>();
        
        String sql = "SELECT * FROM veterinarios WHERE estado = 1";
        
        try (Connection connection =  (Connection) DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            
            while (rs.next()) {
                Veterinario veterinario = new Veterinario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"), rs.getInt("estado"), rs.getString("especialidad"));
                veterinarios.add(veterinario);
                
            }
            
                    
        } catch (SQLException e) {
            System.out.println("Error al obtener los veterinarios:" + e.getMessage());
        }
        return veterinarios;
    }
     
    public void updateVeterinario(int id, String telefono, String especialidad){
        String sql = "UPDATE veterinarios SET telefono = ?, especialidad = ? WHERE id = ?";
        
        try (Connection connection =  (Connection) DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
           stmt.setString(1, telefono);
           stmt.setString(2, especialidad);
           stmt.setInt(3, id);

           stmt.executeUpdate();
           
                    
        } catch (SQLException e) {
            System.out.println("Error al actualizar el veterinario:" + e.getMessage());
        }
    }
     
   
    public void deleteVeterinario(int id, int estado){
        String sql = "UPDATE veterinarios SET estado = ? WHERE id = ?";
        
        try (Connection connection =  (Connection) DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
           stmt.setInt(1, estado);
           stmt.setInt(2, id);

          stmt.executeUpdate();
           
                    
        } catch (SQLException e) {
            System.out.println("Error al eliminar - inactivar el veterinario:" + e.getMessage());
        }
    }
}
