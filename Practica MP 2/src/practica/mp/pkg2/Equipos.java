/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author eloys
 */
public class Equipos {
    private List<Equipo> equipos;
    
    public Equipos() {
       try {
            FileInputStream archivo = new FileInputStream("equipos.txt");
            ObjectInputStream equiposEntrada = new ObjectInputStream(archivo);
            equipos = (List<Equipo>) equiposEntrada.readObject();
            equiposEntrada.close();
            archivo.close();
       }catch(IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el objeto desde el archivo: " + e.getMessage());
        }
    }
    public void anadirEquipo(){
        System.out.println("Nombre del nuevo equipo: ");
        
    }
    public void modificarEquipo(String nombre){
        List<Equipo> equipos = new List<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("equipos.txt"))) {
            while (true) {
                Equipo equipo = (Equipo) in.readObject();
                equipos.add(equipo);
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombre)) {
                System.out.println("¿Qué atributo desea modificar?");
                
                equipo.setAtaque(12); ///falta generalizar
                break;
            }
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("equipos.txt"))) {
            for (Equipo equipo : equipos) {
                out.writeObject(equipo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void eliminarEquipo(){
        
    }
    
    public void actualizarEquipos () {
        try {
            FileOutputStream archivo = new FileOutputStream("equipos.txt");
            ObjectOutputStream equipoSalida = new ObjectOutputStream(archivo);
            equipoSalida.writeObject(equipos);
            equipoSalida.close();
            System.out.println("La lista de equipos ha sido actalizado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void mostrarEquipos(){
        System.out.println("\nEquipos disponibles:");
        int i=1;
        for (Equipo e : equipos) {
            System.out.println(i + "Nombre: " + e.getNombre() + ", Puntos ataque: " + e.getAtaque() + ", Puntos defensa: " + e.getDefensa() + ", Coste: " + e.getCoste());
            i++;
        }
    }
}
