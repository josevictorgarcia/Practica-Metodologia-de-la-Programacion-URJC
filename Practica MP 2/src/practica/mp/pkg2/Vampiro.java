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

//clase corespondiente a los personajes de tipo vampiro
public class Vampiro extends Personaje implements Serializable{

    private int sangre;

    public Vampiro(String nombre, Disciplina disciplina){
        super(nombre, disciplina);
        setPoder(5);
        this.sangre = 0;
    }
    
    //calcula el potencial de ataque en una ronda
    public int getPotencialAtaque() {
        Disciplina disciplina = (Disciplina) this.getHabilidad_especial();
        int extra_sangre =0;
        if (sangre>=5) {
            extra_sangre=2;
        }
        int extra_disciplina=0;
        if (sangre>=disciplina.getCoste()) {
            extra_disciplina=disciplina.getAtaque();
            sangre-= disciplina.getCoste();
        }
        int potencial=  this.getPoder() + extra_disciplina + this.calcularAtaqueEquipo() + extra_sangre + this.calcularModificadoresAtaque();
        return potencial;
    }
    
    public int getPotencialDefensa() {
        Disciplina disciplina = (Disciplina) this.getHabilidad_especial();
        int extra_sangre =0;
        if (sangre>=5) {
            extra_sangre=2;
        }
        int extra_disciplina=0;
        if (sangre>=disciplina.getCoste()) {
            extra_disciplina=disciplina.getDefensa();
            sangre-= disciplina.getCoste();
        }
        int potencial=  this.getPoder() + extra_disciplina + this.getArmadura_activa().getDefensa()+ extra_sangre + this.calcularModificadoresDefensa();
        return potencial;
    }
    
    //inicializa el personaje antes de un combate
    public void prepararCombate () {
        this.setSalud(5);
        calcularSaludEsbirros();
        this.sangre=0;
    }
    
    
    
    /**
     * @return the sangre
     */
    public int getSangre() {
        return sangre;
    }

    /**
     * @param sangre the sangre to set
     */
    public void setSangre(int sangre) {
        this.sangre = sangre;
    }

}
