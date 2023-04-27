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
        this.ranking.add(user);
        actualizarRanking();
    }
    public void actualizarRanking () {
        int i, j;
        for (i = 0; i < ranking.size() - 1; i++) {
            for (j = 0; j < ranking.size() - i - 1; j++) {
                Usuario user1= ranking.get(j);
                Usuario user2= ranking.get(j+1);
                Usuario aux=null;
                if (!(user1 instanceof Cliente)){
                    aux=user1;
                    ranking.set(j, user2);
                    ranking.set(j+1, aux);
                }
                else {
                    if (user2 instanceof Cliente) {
                        Cliente cliente1= (Cliente) user1;
                        Cliente cliente2= (Cliente) user2;
                        if (cliente2.getPersonaje().getDesafios_ganados() > cliente1.getPersonaje().getDesafios_ganados()) {
                            aux=user1;
                            ranking.set(j, user2);
                            ranking.set(j, aux);
                        }
                    }
                }
            }
        }
    }
    
    //ya lo muestra el menu
    public void mostrarRanking(){
        System.out.println("\nRanking:");
        for (Usuario u : getRanking()) {
            System.out.println("Nombre: " + u.getNombre() + ", Desafíos ganados: " + u.getPersonaje().getDesafios_ganados());
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
        /*
    }
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
        */

        // Buscar el usuario que deseas eliminar
        Usuario usuarioEliminado = null;
        int pos=0;
        int index=-1;
        for (Usuario usuario : ranking) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                usuarioEliminado = usuario;
                index=pos;
                break;
            }
            pos++;
        }

        if (usuarioEliminado == null) {
            System.out.println("No se encontró un usuario con ese nombre.");
        } else {
            ranking.remove(index); // Eliminar el usuario de la lista
            //Collections.sort(ranking); CRASHEA
            actualizarRanking();
            /*
            // Escribir las instancias actualizadas de la clase Usuario en el fichero
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ranking.txt"))) {
                for (Usuario usuario : ranking) {
                    out.writeObject(usuario);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
            System.out.println("El usuario ha sido eliminado correctamente.");
        }
    }
    
    
    
//getters setters
    /**
     * @return the ranking
     */
    public List<Usuario> getRanking() {
        return ranking;
    }

    /**
     * @param ranking the ranking to set
     */
    public void setRanking(List<Usuario> ranking) {
        this.ranking = ranking;
    }
}
