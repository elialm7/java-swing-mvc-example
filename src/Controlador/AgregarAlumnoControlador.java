/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.datos.*;
import Vista.AgregarAlumnoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodolfo Elias
 */
public class AgregarAlumnoControlador {
    
    private AgregarAlumnoVista vista;
    private AlumnoDao dao;
    
    public AgregarAlumnoControlador(AgregarAlumnoVista vista, AlumnoDao dao){
        this.vista = vista; 
        this.dao = dao;
    }
    
    public void start(){
        this.vista.setVisible(true);
        bindEvents();
        updateTable();
    }
    
    private void bindEvents(){
        vista.getGuardarAlumno().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                   saveAction(); 
                   updateTable();
                   resetFields();
            } 
        });
    }
    private void saveAction(){
       Alumno alumno = getNewAlumno();
       this.dao.save(alumno);
    }
    
    private void resetTable(){
        DefaultTableModel tablemodel = (DefaultTableModel) this.vista.getAlumnoTabla().getModel();
        if(tablemodel.getRowCount()>0){
            tablemodel.setRowCount(0);
        }
    }
    private void resetFields(){
      
        this.vista.getAlumnoCI().setText("");
        this.vista.getAlumnoNombre().setText("");
        this.vista.getAlumnoApellido().setText("");
        this.vista.getAlumnoAnio().setText("");
        
    }
    
    private void updateTable(){
        List<Alumno> data = this.dao.getAll();
        resetTable();
        DefaultTableModel tablemodel = (DefaultTableModel) this.vista.getAlumnoTabla().getModel();
        for(Alumno al: data){
            String[] row = new String[]{
                al.getCi(),
                al.getNombre(), 
                al.getApellido(), 
                al.getAnioescolar()
            };
            tablemodel.addRow(row);
        }
    }
    
    private Alumno getNewAlumno(){
        String ci = this.vista.getAlumnoCI().getText();
        String nombre = this.vista.getAlumnoNombre().getText();
        String apellido = this.vista.getAlumnoApellido().getText();
        String anioescolar = this.vista.getAlumnoAnio().getText();
        return new Alumno(nombre, apellido, ci, anioescolar); 
    }
    
}
