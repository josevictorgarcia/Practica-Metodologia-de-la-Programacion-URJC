/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
import java.util.*;
import java.io.*;

public class Demonio extends Esbirro implements Serializable{
    private String pacto;
    private List<Esbirro> esbirros;
    
    public Demonio(String nombre, int salud, String pacto) {
        super(nombre, salud);
        this.pacto=pacto;
        this.esbirros=new ArrayList();
    }
    
    public void anadirEsbirro(Esbirro es) {
        this.esbirros.add(es);
    }
    
}
