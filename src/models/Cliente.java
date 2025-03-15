
package models;

/**
 *
 * @author karen_b
 */
public class Cliente extends BaseModel{
    
    private String direccion;

    public Cliente(int id, String nombre, String email, String telefono, int estado, String direccion ) {
        super(id, nombre, email, telefono, estado);
        this.direccion = direccion;
    }

    public Cliente( String nombre, String email, String telefono, int estado, String direccion) {
        super(nombre, email, telefono, estado);
        this.direccion = direccion;
    }

    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", estado=" + estado + ", direccion=" + direccion + '}';
    }

  
    
    
}
