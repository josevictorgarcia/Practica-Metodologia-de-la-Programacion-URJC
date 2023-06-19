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
//import java.util.logging.Logger;

/**
 *
 * @author Alex
 */

//estructura encargada de guardar una lista de personajes ordenada en funcion de desfios_ganados
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
    
    //ordena los usuarios
    public void actualizarRanking () {
        if (ranking.size()>1) {
            int i, j;
            for (i = 0; i < ranking.size() - 1; i++) {
                for (j = 0; j < ranking.size() - i - 2; j++) {
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
                                ranking.set(j+1, aux);
                            }
                        }
                    }
                }
            }
        }
    }
   
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
    
    //devuelve el usuario con el mismo nickname
    public Usuario getUsuario (String nickname) {
        for (Usuario i: this.ranking) {
            if (i.getNickname().equals(nickname)) {
                return i;
            }
        }
        return null;
    }
    
    //elimina el usuario con el nombre deteminado
    public void eliminarUsuario(String nombreUsuario){
        
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
            actualizarRanking();
            System.out.println("El usuario ha sido eliminado correctamente.");
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
