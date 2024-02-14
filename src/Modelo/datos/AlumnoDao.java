/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.datos;

import Modelo.conexion.Conexion;
import Modelo.dao.Dao;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodolfo Elias
 */
public class AlumnoDao implements Dao<Alumno>{
    
    private Conexion conexion; 

    public AlumnoDao(Conexion conexion) {
        this.conexion = conexion;
    }
 
    

    @Override
    public Alumno findOne(Integer id) {
        // todo: implementar luego. 
        return new Alumno("","", "", "");
    }

    @Override
    public List<Alumno> getAll() {
       List<Alumno> result = new ArrayList<>();
        try {
            Connection conn = this.conexion.getConnection();
            Statement st = conn.createStatement();
            String sql = "select * from alumnos;";
            ResultSet  set = st.executeQuery(sql);
            while(set.next()){
               String ci = set.getString("ci");
               String nombre = set.getString("nombre");
               String apellido = set.getString("apellido");
               String anio = set.getString("anioescolar");
               result.add(new Alumno(nombre, apellido, ci, anio));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void save(Alumno t) {
        try { 
            Connection conn = this.conexion.getConnection();
            String sql = "insert into alumnos(ci, nombre, apellido, anioescolar) values(?,?,?,?)";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, t.getCi());
            prep.setString(2, t.getNombre());
            prep.setString(3, t.getApellido());
            prep.setString(4, t.getAnioescolar());
            int rows = prep.executeUpdate();
            System.out.println(rows);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    @Override
    public void update(Alumno t) {
        
        // todo: implementar luego
        
    }

    @Override
    public void delete(Alumno t) {
        // todo: implementar luego
    }
    
}
