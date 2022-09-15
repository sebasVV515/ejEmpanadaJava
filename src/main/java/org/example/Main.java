package org.example;
import clases.Cliente;
import clases.Empanada;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opciones = 0;
        Scanner lea = new Scanner(System.in);
        Empanada empanada = new Empanada("Empanada 1", "Carne", 2000, 5000);
        Cliente cliente = new Cliente();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("MENU");
        System.out.println("1: Agregar empanadas");
        System.out.println("2: Ver empanada");
        System.out.println("3: Editar precio empanada");
        System.out.println("4: Salir");

        while(opciones!=4){
            System.out.println("Ingrese una opcion");
            opciones = lea.nextInt();
            switch(opciones){
                case 1:
                    System.out.println("Ingrese su saldo disponible");
                    cliente.setSaldoDisponible(lea.nextInt());
                    if(cliente.getSaldoDisponible()>=5000){
                        System.out.println("La empanada es: "+empanada.getNombre());
                        System.out.println("El precio es: "+empanada.getPrecioVenta());
                        System.out.println("Cuantas empanadas quiere?");
                        empanada.setCantidad(lea.nextInt());
                        while(empanada.calcularTotal()> cliente.getSaldoDisponible()){
                            System.out.println("Le faltan "+(empanada.calcularTotal()-cliente.getSaldoDisponible()));
                            System.out.println("Ingrese una cantidad menor");
                            empanada.setCantidad(lea.nextInt());
                        }
                        System.out.println("Su total a pagar es: "+empanada.calcularTotal());
                        System.out.println("Su nuevo saldo es: "+(empanada.calcularTotal()-cliente.getSaldoDisponible()));
                    }else{
                        System.out.println("No tiene suficiente dinero");
                    }
                    break;
                case 2:
                    System.out.println("Empanadas Sebastian");
                    System.out.println("Regimen Comun");
                    System.out.println(dtf.format(LocalDateTime.now()));
                    System.out.println("Producto: "+empanada.getNombre());
                    System.out.println("Cantidad: "+empanada.getCantidad());
                    System.out.println("Total: "+empanada.calcularTotal());
                    break;
                case 3:
                    System.out.println("Habitación 3");
                    break;
                case 4:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }
    }
}