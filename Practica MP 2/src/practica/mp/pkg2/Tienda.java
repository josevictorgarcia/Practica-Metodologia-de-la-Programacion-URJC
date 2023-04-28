/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

import java.util.*;

/**
 *
 * @author migue
 */
import java.io.*;

//clase encargada de las compras de articulos
public class Tienda implements Serializable{
    private Equipos items;
    
    public Tienda (Equipos equipos) {
        this.items= equipos;
    }
    
    //pide y realiza la compra
    public void comprar(Personaje personaje){
        Scanner scanner = new Scanner(System.in);
        getItems().mostrarEquipos();
        System.out.println("Introduce el nombre del equipo a comprar:");
        String nombreEquipo = scanner.nextLine();

        // Buscar el equipo que deseas modificar
        Equipo equipoBuscado = null;
        for (Equipo equipo : getItems().getEquipos()) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                equipoBuscado = equipo;
                break;
                }
            }
        if (equipoBuscado == null) {
            System.out.println("No se encontró un equipo con ese nombre.");
        } else {
            if (personaje.oroSuficiente(equipoBuscado.getCoste())==true){
                personaje.anadirItem(equipoBuscado);
                personaje.modificarOro(equipoBuscado.getCoste());
            } else{
                System.out.println("No tiene dinero suficiente");
            }
        }
    }

    public Equipos getItems() {
        return items;
    }

    public void setItems(Equipos items) {
        this.items = items;
    }  
}
