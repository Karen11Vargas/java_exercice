/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author karen_b
 */

import dao.VeterinarioDAO;
import java.util.List;
import models.Veterinario;
public class VeterinarioController {
     private VeterinarioDAO vet;

    public VeterinarioController() {
        this.vet = new VeterinarioDAO();
    }
    
    public void agregarVeterinario(String nombre, String email, String telefono, int estado, String especialidad){
        Veterinario veterinario = new Veterinario(nombre, email, telefono, estado, especialidad);
        vet.agregarVeterinario(veterinario);
        System.out.println("Veterinario agregado exitosamente");
    }
    
    public List<Veterinario> obtenerVeterinario(){
       return vet.getVeterinario();
    }
     
    public void updateVeterinario(int id, String telefono,  String especialidad){
        vet.updateVeterinario(id, telefono, especialidad);
        System.out.println("Veterinario actualizado exitosamente");
    }
      
    public void deleteVeterinario(int id, int estado){
        vet.deleteVeterinario(id, estado);
        System.out.println("Veterinario inactivo exitosamente");
    }
}
