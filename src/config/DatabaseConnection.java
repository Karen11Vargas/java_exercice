/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author karen_b
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/veterinaria";
    private static final String USER ="root";
    private static final String PASSWORD ="";
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD); 
        } catch (SQLException e) {
            System.out.println("Error al conectar la bd:" + e.getMessage());
            return null;
        } 
        
    }
}

   