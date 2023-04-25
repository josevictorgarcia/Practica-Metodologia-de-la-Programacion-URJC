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

//guarda una lista de personajes ordenada en funcion de desfios_ganados

public class Ranking {
    private List<User> ranking;

    public Ranking() {
       try {
            FileInputStream archivo = new FileInputStream("ranking.txt");
            ObjectInputStream rankingEntrada = new ObjectInputStream(archivo);
            ranking = (List<Personaje>) rankingEntrada.readObject();
            rankingEntrada.close();
            archivo.close();
       }catch(IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el objeto desde el archivo: " + e.getMessage());
        }
    }
    
    //introduce personaje ordenado por desafios_ganados
    public void añadirPersonaje (Personaje per) {
        Iterator<String> iterator = ranking.iterator();
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
        for (Personaje p : ranking) {
            System.out.println("Nombre: " + p.getNombre() + ", Desafíos ganados: " + p.getDesafios_ganados());
        }
    }
}
