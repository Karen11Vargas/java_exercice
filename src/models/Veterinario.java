/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author karen_b
 */
public class Veterinario extends BaseModel{
      
    private String especialidad;

    public Veterinario(int id, String nombre, String email, String telefono, int estado, String especialidad ) {
        super(id, nombre, email, telefono, estado);
        this.especialidad = especialidad;
    }

    public Veterinario( String nombre, String email, String telefono, int estado, String especialidad) {
        super(nombre, email, telefono, estado);
        this.especialidad = especialidad;
    }

    
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", estado=" + estado + ", Especialidad=" + especialidad + '}';
    }

  
    
}
