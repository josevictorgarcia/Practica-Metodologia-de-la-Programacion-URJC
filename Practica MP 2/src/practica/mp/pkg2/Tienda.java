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
    
    public Tienda (Equipos equipos) {
        this.items= equipos;
    }
    
    public void comprar(Personaje personaje){
        getItems().mostrarEquipos();
        Scanner scanner = new Scanner(System.in);
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
            }
            else{
            System.out.println("No tiene dinero suficiente");
            }
        }
    }

    /**
     * @return the items
     */
    public Equipos getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(Equipos items) {
        this.items = items;
    }
    
    
}
