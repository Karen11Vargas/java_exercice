/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.VeterinarioController;
import java.util.List;
import java.util.Scanner;
import models.Veterinario;
/**
 *
 * @author karen_b
 */
public class VeterinarioView {
    private VeterinarioController vet;
    private Scanner entrada;

    public VeterinarioView() {
        this.vet = new VeterinarioController();
        this.entrada = new Scanner(System.in);
    }

    
    public void mostrarMenu(){
        int opcion;
        do{
            System.out.println("---- BIENVENIDOS -----");
            System.out.println("---- KAREN LISETH VARGAS -----");
            System.out.println("---- 1011201964 -----");
            System.out.println("---- MENU VETETINARIOS - VETERINARIA -----");
            System.out.println("1. Agregar Veterinario");
            System.out.println("2. Mostrar Veterinarios");
            System.out.println("3. Actualizar Veterinario");
            System.out.println("4. Inactivar Veterinario");
            System.out.println("5. Salir");
            opcion = entrada.nextInt();
            entrada.nextLine();
            
            switch (opcion) {
                case 1:
                    agregarVeterinario();
                break;
               
                case 2:
                    mostrarVeterinario();
                break;
                
                case 3:
                    actualizarVeterinario();
                break;
                
                case 4:
                    inactivarVeterinario();
                break;
                case 5:
                    System.out.println("Gracias por usar nuestros servicios, adios :)");
                break;
                default:
                    System.out.println("Opción invalida");

            }

        }while(opcion  !=5);
    }
    
    public void agregarVeterinario(){
        System.out.println(" -------- Agregar Veterinario -------");
        System.out.println(" Nombre: ");
        String nombre = entrada.nextLine();
        System.out.println(" Email: ");
        String email = entrada.nextLine();
        System.out.println(" Telefono: ");
        String telefono = entrada.nextLine();
        System.out.println(" Especialidad: ");
        String esp = entrada.nextLine();
        
        vet.agregarVeterinario(nombre, email, telefono, 1, esp);
        System.out.println("Veterinario agregado con exito");

    }
    
    public void mostrarVeterinario(){
        System.out.println(" -------- Mostrar Veterinarios -------");
        List<Veterinario> veterinarios = vet.obtenerVeterinario();
        if (veterinarios.isEmpty()) {
            System.out.println("No hay Veterinarios registrados");
        }else{
            for (Veterinario vet : veterinarios) {
                System.out.println(vet);
            }
            
        }
 
    }
    
     public void actualizarVeterinario(){
        System.out.println(" -------- Actualizar Veterinario -------");
        System.out.println(" id Veterinario: ");
        int  id = Integer.parseInt(entrada.nextLine());
        System.out.println(" Especialidad: ");
        String esp = entrada.nextLine();
        System.out.println(" Telefono: ");
        String telefono = entrada.nextLine();
      
        vet.updateVeterinario(id, telefono, esp);
        System.out.println("Veterinario Actualizado con exito");
        
    }
    
    public void inactivarVeterinario(){
        System.out.println(" -------- Inactivar Veterinario -------");
        System.out.println(" id Veterinario: ");
        int  id = Integer.parseInt(entrada.nextLine());
      
        vet.deleteVeterinario(id, 0);
        System.out.println("Veterinario Eliminado con exito");
    }
    
}
