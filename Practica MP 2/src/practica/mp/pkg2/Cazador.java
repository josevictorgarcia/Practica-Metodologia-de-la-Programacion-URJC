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
public class Cazador extends Personaje implements Serializable{

    private int voluntad;
    
    public Cazador (String nombre, Talento talento) {
        super(nombre, talento);
        setPoder(4);
        this.voluntad=3;
    }
    
    public int getPotencialAtaque() {
        int result=0;
        result= this.getPoder() + this.getHabilidad_especial().getAtaque() + this.calcularAtaqueEquipo() + voluntad + this.calcularModificadoresAtaque();
        return result;
    }
    
    public int getPotencialDefensa() {
        int result=0;
        result= this.getPoder() + this.getHabilidad_especial().getDefensa()+ this.getArmadura_activa().getDefensa()+ voluntad + this.calcularModificadoresDefensa();
        return result;
    }
    
    public void prepararCombate () {
        this.setSalud(5);
        calcularSaludEsbirros();
        this.voluntad=3;
    }
    
    
    
    
    /**
     * @return the voluntad
     */
    public int getVoluntad() {
        return voluntad;
    }

    /**
     * @param voluntad the voluntad to set
     */
    public void setVoluntad(int voluntad) {
        this.voluntad = voluntad;
    }
}
