/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

import java.io.*;
import java.util.List;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class Ranking {
    private List<Usuario> ranking;

    public Ranking() {
       try {
            FileInputStream archivo = new FileInputStream("ranking.txt");
            ObjectInputStream rankingEntrada = new ObjectInputStream(archivo);
            ranking = (List<Usuario>) rankingEntrada.readObject();
            rankingEntrada.close();
            archivo.close();
       }catch(IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el objeto desde el archivo: " + e.getMessage());
        }
    }
    
    public void añadirUsuario (Usuario user) {
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
            System.out.println("Nombre: " + u.getNickname() + ", Desafíos ganados: " + u.getPersonaje().getDesafios_ganados());
        }
    }
    public Usuario buscarUsuario(String nickname){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ranking.txt"))) {
            ranking = (List<Usuario>) ois.readObject(); // Lee la lista de objetos Usuario desde el archivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Busca el usuario con el nickname especificado en la lista
        //boolean encontrado = false;
        for (Usuario usuario : ranking) {
            if (usuario.getNickname().equals(nickname)) {
                //encontrado = true;
                return usuario;
            }else{
                return null;
            }
        }
        return null;
    }
}
