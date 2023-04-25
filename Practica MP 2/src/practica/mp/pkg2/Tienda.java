/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

import java.util.List;

/**
 *
 * @author migue
 */
public class Tienda {
    private List<String> items;
    
    public void mostrarItems(){
        for(String i:items){
            System.out.println(i);
        }
        
    }
    public void comprar(int oro, String item, Personaje personaje){
        if (personaje.oroSuficiente(oro)==true){
            personaje.anadirItem(item);
            personaje.modificarOro(oro);
        }
        else{
            mostrarMensajeError();
        }
    }
    public void mostrarMensajeError(){
        System.out.println("No tiene dinero suficiente");
    }
}
