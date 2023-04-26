/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
public class Licantropo extends Personaje {

    /**
     * @return the rabia
     */
    public int getRabia() {
        return rabia;
    }

    /**
     * @param rabia the rabia to set
     */
    public void setRabia(int rabia) {
        this.rabia = rabia;
    }
    private int rabia;
    
    public Licantropo (String nombre, int poder, Don don) {
        super(nombre, poder, don);
        this.rabia=0;
    }
}
