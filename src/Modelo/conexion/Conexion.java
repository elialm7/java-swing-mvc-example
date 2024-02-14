/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodolfo Elias
 */
public class Conexion {
    
    
    private String jdbcUrl = "jdbc:postgresql://localhost:5432/EjemploAlumnos";
    private String username = "postgres"; 
    private String password = "admin"; 
    
    
    
    public Connection getConnection() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
    
    
    
    
    
}
