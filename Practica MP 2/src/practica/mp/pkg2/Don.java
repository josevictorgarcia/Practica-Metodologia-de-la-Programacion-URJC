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

//clase correspondiente al tipo de habilidad denominado Don
public class Don extends Habilidad implements Serializable{
    private int valorMin;
    
    public Don (String nombre, int ataque, int defensa, int rabia_min) {
        super(nombre, ataque, defensa);
        this.valorMin=rabia_min;
    }

    /**
     * @return the valorMin
     */
    public int getValorMin() {
        return valorMin;
    }

    /**
     * @param valorMin the valorMin to set
     */
    public void setValorMin(int valorMin) {
        this.valorMin = valorMin;
    }
    
    
}
