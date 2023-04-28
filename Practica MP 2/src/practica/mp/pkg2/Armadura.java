/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
import java.io.*;


//clase correspondiente al objeto Armadura
public class Armadura extends Equipo implements Serializable{
    public Armadura (String nombre, int defensa, int ataque, int coste) {
        super(nombre,ataque,defensa,coste);
    }
}
