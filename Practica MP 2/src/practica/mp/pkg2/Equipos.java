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
import java.util.*;

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
        // Leer el fichero y cargar las instancias en una lista
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

        // Pedir los atributos del nuevo equipo
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del nuevo equipo:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el ataque del nuevo equipo:");
        int ataque = scanner.nextInt();

        System.out.println("Introduce la defensa del nuevo equipo:");
        int defensa = scanner.nextInt();

        System.out.println("Introduce el coste del nuevo equipo:");
        int coste = scanner.nextInt();

        // Crear una nueva instancia de la clase Equipo con los atributos introducidos
        Equipo nuevoEquipo = new Equipo(nombre, ataque, defensa, coste);

        // Agregar el nuevo equipo a la lista
        equipos.add(nuevoEquipo);

        // Escribir las instancias actualizadas de la clase Equipo en el fichero
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("equipos.dat"))) {
            for (Equipo equipo : equipos) {
                out.writeObject(equipo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("El nuevo equipo ha sido añadido correctamente.");
    }
    
    public void modificarEquipo(){
        
        // Leer el fichero y cargar las instancias en una lista
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
        // Pedir el nombre del equipo a modificar
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del equipo a modificar:");
        String nombreEquipo = scanner.nextLine();

        // Buscar el equipo que deseas modificar
        Equipo equipoModificado = null;
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                equipoModificado = equipo;
                break;
            }
        }
        if (equipoModificado == null) {
            System.out.println("No se encontró un equipo con ese nombre.");
        } else {
            // Pedir el atributo a modificar
            System.out.println("¿Qué atributo deseas modificar? (ataque, defensa, coste)");
            String atributo = scanner.nextLine();

            // Actualizar el atributo correspondiente
            switch (atributo) {
                case "ataque":
                    System.out.println("Introduce el nuevo valor de ataque:");
                    int nuevoAtaque = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea vacía después del entero
                    equipoModificado.setAtaque(nuevoAtaque);
                    break;
                case "defensa":
                    System.out.println("Introduce el nuevo valor de defensa:");
                    int nuevaDefensa = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea vacía después del entero
                    equipoModificado.setDefensa(nuevaDefensa);
                    break;
                case "coste":
                    System.out.println("Introduce el nuevo valor de coste:");
                    int nuevoCoste = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea vacía después del entero
                    equipoModificado.setCoste(nuevoCoste);
                    break;
                default:
                    System.out.println("Atributo inválido.");
                    break;
            }

            // Escribir las instancias actualizadas de la clase Equipo en el fichero
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("equipos.txt"))) {
                for (Equipo equipo : equipos) {
                    out.writeObject(equipo);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void eliminarEquipo(){
        
        // Leer el fichero y cargar las instancias en una lista
        List<Equipo> equipos = new List<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("equipos.dat"))) {
            while (true) {
                Equipo equipo = (Equipo) in.readObject();
                equipos.add(equipo);
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Pedir el nombre del equipo a eliminar
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del equipo a eliminar:");
        String nombreEquipo = scanner.nextLine();

        // Buscar el equipo que deseas eliminar
        Equipo equipoEliminado = null;
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                equipoEliminado = equipo;
                break;
            }
        }

        if (equipoEliminado == null) {
            System.out.println("No se encontró un equipo con ese nombre.");
        } else {
            equipos.remove(equipoEliminado); // Eliminar el equipo de la lista

            // Escribir las instancias actualizadas de la clase Equipo en el fichero
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("equipos.dat"))) {
                for (Equipo equipo : equipos) {
                    out.writeObject(equipo);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("El equipo ha sido eliminado correctamente.");
        }
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
        // Leer el fichero y cargar las instancias en una lista
        List<Equipo> equipos = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("equipos.dat"))) {
            while (true) {
                Equipo equipo = (Equipo) in.readObject();
                equipos.add(equipo);
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Mostrar los equipos almacenados en el archivo
        for (Equipo equipo : equipos) {
            System.out.println("Nombre: " + equipo.getNombre());
            System.out.println("Ataque: " + equipo.getAtaque());
            System.out.println("Defensa: " + equipo.getDefensa());
            System.out.println("Coste: " + equipo.getCoste());
            System.out.println("-------------");
        }
    }
}
