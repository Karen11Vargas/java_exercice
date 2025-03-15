
package main;

import java.util.Scanner;
import views.ClienteView;
import views.VeterinarioView;

/**
 *
 * @author karen_b
 */
public class Main {
    
    public static void main(String[] args){
      
        Scanner entrada = new Scanner(System.in);
        int opcion;
         do{
            System.out.println("---- BIENVENIDOS -----");
            System.out.println("---- KAREN LISETH VARGAS -----");
            System.out.println("---- 1011201964 -----");
            System.out.println("---- MENU PRINCIPAL - VETERINARIA -----");
            System.out.println("1. Ver Menu Clientes");
            System.out.println("2. Ver Menu Veterinarios");
            System.out.println("3. Salir");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    ClienteView cliente = new ClienteView();
                    cliente.mostrarMenu();
                break;
                  
                case 2:
                     VeterinarioView vet = new VeterinarioView();
                    vet.mostrarMenu();
                break;

                case 3:
       
                    System.out.println("Gracias por usar nuestros servicios, adios :)");
                break;
                default:
                    System.out.println("Opción invalida");

            }

        }while(opcion  !=3);
    }
}
