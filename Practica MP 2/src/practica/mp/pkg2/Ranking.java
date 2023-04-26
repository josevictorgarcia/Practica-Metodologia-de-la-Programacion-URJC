/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */

//guarda una lista de personajes ordenada en funcion de desfios_ganados

public class Ranking implements Serializable{
    private List<Usuario> ranking;

    public Ranking() {
       
    }

    //introduce personaje ordenado por desafios_ganados
    public void añadirUsuario (Usuario user) {
        /*Iterator<String> iterator = ranking.iterator();
        boolean end = true;
        Personaje aux;
        int pos = 0;
        while (iterator.hasNext() & end){
            aux=iterator.next();
            if (aux.getDesafios_ganados() < per.getDesafios_ganados()) {
                end=false;
            }
            pos++;   
        }
        if (pos==0) {
            ranking.add(per); 
        }
        else {
            ranking.add(pos-1, per);
        }
        */
        ranking.add(user);
        actualizarRanking();
        
        
    }
    public void actualizarRanking () {
        Collections.sort(ranking);
        try {
            FileOutputStream archivo = new FileOutputStream("ranking.txt");
            ObjectOutputStream rankingSalida = new ObjectOutputStream(archivo);
            rankingSalida.writeObject(ranking);
            rankingSalida.close();
            System.out.println("El ranking ha sido actalizado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void mostrarRanking(){
        System.out.println("\nRanking:");
        for (Usuario u : ranking) {
            System.out.println("Nombre: " + u.getNombre() + ", Desafíos ganados: " + u.getPersonaje().getDesafios_ganados());
        }
    }
    public Usuario getUsuario (String nickname) {
        for (Usuario i: ranking) {
            if (i.getNickname()==nickname) {
                return i;
            }
        }
        return null;
    
    public void eliminarUsuario(String nombreUsuario){
        List<Usuario> ranking = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("ranking.txt"))) {
            while (true) {
                Usuario usuario = (Usuario) in.readObject();
                ranking.add(usuario);
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Buscar el usuario que deseas eliminar
        Usuario usuarioEliminado = null;
        for (Usuario usuario : ranking) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                usuarioEliminado = usuario;
                break;
            }
        }

        if (usuarioEliminado == null) {
            System.out.println("No se encontró un usuario con ese nombre.");
        } else {
            ranking.remove(usuarioEliminado); // Eliminar el usuario de la lista
            Collections.sort(ranking);

            // Escribir las instancias actualizadas de la clase Usuario en el fichero
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ranking.txt"))) {
                for (Usuario usuario : ranking) {
                    out.writeObject(usuario);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("El usuario ha sido eliminado correctamente.");
        }
    }
}
