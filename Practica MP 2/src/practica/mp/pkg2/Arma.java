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


//clase que guarda y maneja la informacion de un arma
public class Arma extends Equipo implements Serializable{
    private int manos;
    
    public Arma(String nombre, int ataque, int defensa, int coste,int manos) {
        super(nombre,ataque,defensa,coste);
        this.manos=manos;
    }

    /**
     * @return the manos
     */
    public int getManos() {
        return manos;
    }

    /**
     * @param manos the manos to set
     */
    public void setManos(int manos) {
        this.manos = manos;
    }
    
}
