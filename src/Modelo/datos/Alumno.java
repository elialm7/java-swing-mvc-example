
package Modelo.datos;

/**
 *
 * @author Rodolfo Elias
 */
public class Alumno {
    
    
    private String nombre;
    private String apellido; 
    private String ci;
    private String anioescolar;

    public Alumno(String nombre, String apellido, String ci, String anioescolar) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.anioescolar = anioescolar;
    }

    public Alumno(String nombre, String apellido, String anioescolar) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioescolar = anioescolar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getAnioescolar() {
        return anioescolar;
    }

    public void setAnioescolar(String anioescolar) {
        this.anioescolar = anioescolar;
    }
    
    
    
    
    
}
