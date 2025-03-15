
package models;

/**
 *
 * @author karen_b
 */
public abstract class BaseModel {
    protected int id;
    protected String nombre;
    protected String email;
    protected String telefono;
    protected int estado;

    public BaseModel(int id, String nombre, String email, String telefono, int estadp) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.estado = estadp;
    }

    public BaseModel(String nombre, String email, String telefono, int estadp) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.estado = estadp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "BaseModel{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", estado=" + estado + '}';
    }

    
    
    
    
}
