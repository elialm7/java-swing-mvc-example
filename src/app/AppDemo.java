
package app;

import Controlador.AgregarAlumnoControlador;
import Modelo.datos.AlumnoDao;
import Vista.*;
import Modelo.conexion.*;
/**
 *
 * @author Rodolfo Elias
 */
public class AppDemo {
    
    
    public static void main(String[] args){
        
        
        
        //clases del modelo 
        Conexion con = new Conexion();
        AlumnoDao dao = new AlumnoDao(con);
        //clases de la vista
        AgregarAlumnoVista vista = new AgregarAlumnoVista();
        //clases del controlador
        AgregarAlumnoControlador controlador = new AgregarAlumnoControlador(vista, dao);
        controlador.start();
      
        
    }
    
}
