/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Equipo implements Serializable{
    private String nombre;
    private int ataque;
    private int defensa;
    private int coste;

    public Equipo(String nombre, int ataque, int defensa, int coste) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.coste = coste;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getCoste() {
        return coste;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }
    
    
}
