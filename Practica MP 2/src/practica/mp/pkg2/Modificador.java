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
public class Modificador implements Serializable{
    private String nombre;
    private int sensible;
    private boolean fortaleza; //true = fortaleza, false=debilidad
    
    public Modificador (String nombre, int sensible, boolean fortaleza) {
        this.nombre=nombre;
        this.sensible=sensible;
        this.fortaleza=fortaleza;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sensible
     */
    public int getSensible() {
        return sensible;
    }

    /**
     * @param sensible the sensible to set
     */
    public void setSensible(int sensible) {
        this.sensible = sensible;
    }

    /**
     * @return the fortaleza
     */
    public boolean isFortaleza() {
        return fortaleza;
    }

    /**
     * @param fortaleza the fortaleza to set
     */
    public void setFortaleza(boolean fortaleza) {
        this.fortaleza = fortaleza;
    }
    
    
    
}
