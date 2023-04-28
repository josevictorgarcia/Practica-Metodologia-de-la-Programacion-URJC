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

//clase correspondiente al pesonaje de tipo Licantropo
public class Licantropo extends Personaje implements Serializable{
    
    private int rabia;
    
    public Licantropo (String nombre, Don don) {
        super(nombre, don);
        setPoder(3);
        this.rabia=0;
    }
   
    //devuelve el potencial de ataque en una ronda
    public int getPotencialAtaque() {
        int extra_don=0;
        Don don = (Don) this.getHabilidad_especial();
        if (rabia>=don.getValorMin()) {
            extra_don=don.getAtaque();
        }
        int result= this.getPoder() + extra_don + this.calcularAtaqueEquipo() + rabia + this.calcularModificadoresAtaque();
        return result;
    }
    
    //devuelve el potencial de defensa
    public int getPotencialDefensa() {
        int extra_don=0;
        Don don = (Don) this.getHabilidad_especial();
        if (rabia>=don.getValorMin()) {
            extra_don=don.getDefensa();
        }
        int result= this.getPoder() + extra_don + this.getArmadura_activa().getDefensa()+ rabia + this.calcularModificadoresDefensa();
        return result;
    }
    
    //inicializa al personaje antes de un combate
    public void prepararCombate () {
        this.setSalud(5);
        calcularSaludEsbirros();
        this.rabia=0;
    }
    
    
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
}
