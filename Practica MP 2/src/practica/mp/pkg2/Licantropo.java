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
    
    private int rabia;
    
    public Licantropo (String nombre, int poder, Don don) {
        super(nombre, poder, don);
        this.rabia=0;
    }
    
    public int getPotencialAtaque() {
        int extra_don=0;
        Don don = (Don) this.getHabilidad_especial();
        if (rabia>=don.getValorMin()) {
            extra_don=don.getAtaque();
        }
        int result= this.getPoder() + extra_don + this.calcularAtaqueEquipo() + rabia + this.calcularModificadoresAtaque();
        return result;
    }
    
    public int getPotencialDefensa() {
        int extra_don=0;
        Don don = (Don) this.getHabilidad_especial();
        if (rabia>=don.getValorMin()) {
            extra_don=don.getDefensa();
        }
        int result= this.getPoder() + extra_don + this.getArmadura_activa().getDefensa()+ rabia + this.calcularModificadoresDefensa();
        return result;
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
