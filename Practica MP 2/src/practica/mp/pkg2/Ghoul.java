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

//clase correspondiente al tipo de esbirro llamado Ghoul
public class Ghoul extends Esbirro implements Serializable{
    private int dependencia;
    
    public Ghoul (String nombre, int salud, int dependencia) {
        super(nombre, salud);
        this.dependencia=dependencia;
    }
}
