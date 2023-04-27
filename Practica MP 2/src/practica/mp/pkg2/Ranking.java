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
       this.ranking= new ArrayList();
    }

    //introduce personaje ordenado por desafios_ganados
    public void añadirUsuario (Usuario user) {
        this.ranking.add(user);
        actualizarRanking();
        
        
    }
    public void actualizarRanking () {
    }
    
    //ya lo muestra el menu
    /*public void mostrarRanking(){
        System.out.println("\nRanking:");
        for (Usuario u : getRanking()) {
            System.out.println("Nombre: " + u.getNombre() + ", Desafíos ganados: " + u.getPersonaje().getDesafios_ganados());
        }
    }*/
    public void mostrarRanking () {
        int pos =0;
        for (Usuario i: ranking) {
            pos++;
            System.out.println(pos+ ": " + i.getNickname());
            if (i instanceof Cliente) {
                Cliente cliente= (Cliente) i;
                System.out.println("Desafios ganados: " + cliente.getPersonaje().getDesafios_ganados());
            }
        }
    }
    public Usuario getUsuario (String nickname) {
        for (Usuario i: this.ranking) {
            if (i.getNickname().equals(nickname)) {
                return i;
            }
        }
        return null;
    }
    
    public void eliminarUsuario(String nombreUsuario){
        
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
            System.out.println("El usuario ha sido eliminado correctamente.");
        }
    }
    public Ranking loadRanking() {
        try {
            FileInputStream archivo = new FileInputStream("ranking.ser");
            ObjectInputStream rankingEntrada = new ObjectInputStream(archivo);
            Ranking rank = (Ranking) rankingEntrada.readObject();
            rankingEntrada.close();
            return rank;
        }
        catch(IOException | ClassNotFoundException e) {
           //lo creamos pues no hay archivo
            return new Ranking();
        }
    }
    
    public void saveRanking() {
        try {
            FileOutputStream archivo = new FileOutputStream("ranking.ser");
            ObjectOutputStream rankingSalida = new ObjectOutputStream(archivo);
            rankingSalida.writeObject(this.ranking);
            rankingSalida.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error clase App method saveRanking");
        }
    }
    
//getters setters
    public List<Usuario> getRanking() {
        return ranking;
    }

    public void setRanking(List<Usuario> ranking) {
        this.ranking = ranking;
    }
    
}
