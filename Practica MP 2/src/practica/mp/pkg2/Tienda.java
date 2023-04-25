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
public class Tienda {
    private Equipos items;
    
    public void comprar(Personaje personaje){
        items.mostrarEquipos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del equipo a comprar:");
        String nombreEquipo = scanner.nextLine();

        // Buscar el equipo que deseas modificar
        Equipo equipoBuscado = null;
        for (Equipo equipo : items) {
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
            }
            else{
            System.out.println("No tiene dinero suficiente");
            }
        }
    }
}
