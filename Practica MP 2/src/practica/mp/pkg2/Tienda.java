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
public class Tienda implements Serializable{
    private Equipos items;
    
    public Tienda (Equipos equipos) {
        this.items= equipos;
    }
    
    public Equipo pedirItemTienda() {
        System.out.println("Los items de la tienda son:");
        int pos=0;
        for (Equipo i: items.getEquipos()) {
            System.out.println(pos+": Nombre: "+i.getNombre() + " Oro: "+ i.getCoste()+ " Ataque: " + i.getAtaque() + " Defensa: " + i.getDefensa());
            pos++;
        }
        int size=items.getEquipos().size();
        System.out.println("Escribe el numero para comprar, o escribe "+size+" para salir");
        Scanner scanner = new Scanner(System.in);
        
        int respuesta =  scanner.nextInt();
        if (respuesta ==size) {
            return null;
        }
        else {
            return items.getEquipos().get(respuesta);
        }
    }
    
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
