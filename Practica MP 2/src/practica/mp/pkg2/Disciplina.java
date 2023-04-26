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
public class Disciplina extends Habilidad implements Serializable{
    private int coste;
    
    public Disciplina (String nombre, int ataque, int defensa, int coste) {
        super(nombre, ataque, defensa);
        this.coste=coste;
    }

    /**
     * @return the coste
     */
    public int getCoste() {
        return coste;
    }

    /**
     * @param coste the coste to set
     */
    public void setCoste(int coste) {
        this.coste = coste;
    }
    
    
}
