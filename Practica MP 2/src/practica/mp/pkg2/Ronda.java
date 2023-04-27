/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

import java.lang.*;
import java.util.*;

/**
 *
 * @author Alex
 */
import java.io.*;
public class Ronda implements Serializable{
    private String combate;
    private Personaje personaje1, personaje2;
    private int numRonda;
    private Personaje ganador;   //Para guardar al ganador de la ronda
    private int ataqueAPersonaje1;
    private int ataqueAPersonaje2;

    public Ronda (Combate c){                       
        this.combate = c.getID(); //Se puede poner como un puntero que apunta al combate principal, ya que en esta clase Ronda no modificaremos detalles del combate. Y Si lo hacemos, lo modificaremos en el combate original, mediante this.combate.
        this.personaje1 = c.getPersonaje1();
        this.personaje2 = c.getPersonaje2();
        this.numRonda = c.getRondas().size() + 1;
        this.ganador = null;
        this.ataqueAPersonaje1=0;
        this.ataqueAPersonaje2=0;
    }

    public Personaje getGanador(){
        return this.ganador;
    }

    public void calculoRonda(){                           
        int p1; int p2;
        System.out.println("Ronda: "+this.numRonda);
        //turno ataque jugador 1
        p1 = calculoNumExitosAtaque(this.getPersonaje1());
        p2 = calculoNumExitosDefensa(this.getPersonaje2());
        if (p1>p2) {
            if (this.personaje2.getSalud_esbirros()<1) {
                this.getPersonaje2().setSalud(this.getPersonaje2().getSalud()-1);      //reduce la salud en 1 punto
                System.out.println("daño de 1 a p2. Salud p2: "+this.personaje2.getSalud());
            }
            else{
                this.getPersonaje2().setSalud_esbirros(this.getPersonaje2().getSalud_esbirros()-1);
                System.out.println("daño de 1 a esbirros de p2. Salud esbirros de p2: "+this.personaje2.getSalud_esbirros()); 
            }
            if (getPersonaje1() instanceof Vampiro) {
                Vampiro vampiro= (Vampiro) getPersonaje1();
                vampiro.setSangre(vampiro.getSangre()+4);
            }
            this.setAtaqueAPersonaje2(1);
        }
        //turno ataque jugador 2
        p1 = calculoNumExitosAtaque(this.getPersonaje2());
        p2 = calculoNumExitosDefensa(this.getPersonaje1());
        if (p1>p2) {
            if (this.getPersonaje1().getSalud_esbirros()<1) {
                this.getPersonaje1().setSalud(this.getPersonaje1().getSalud()-1);      //reduce la salud en 1 punto
                System.out.println("daño de 1 a p1. Salud p1: "+this.personaje1.getSalud());
            }
            else{
                this.getPersonaje1().setSalud_esbirros(this.getPersonaje1().getSalud_esbirros()-1);
                System.out.println("daño de 1 a  esbirros de p1. Salud esbirros de p1: "+this.personaje1.getSalud_esbirros());
            }
            if (getPersonaje2() instanceof Vampiro) {
                    Vampiro vampiro= (Vampiro) getPersonaje2();
                    vampiro.setSangre(vampiro.getSangre()+4);
                }
            this.setAtaqueAPersonaje1(1);
        }
    }

    //calculoPotencialAtaque(){} no puede ir en esta clase. Debe ir en

    public int calculoNumExitosAtaque(Personaje p){
        Random rand = new Random();
        int total = 0;
        for(int i=1;i<=p.getPotencialAtaque();i++){        
            int n = rand.nextInt(1,6);      //Calcula un numero random entre 1 y 6
            if ((n==5) || (n==6)) {                       //Si el numero random es 5 o 6, sumamos 1 al valor total del ataque.
                total = total + 1;
            }
        }
        return total;
    }
    
    public int calculoNumExitosDefensa(Personaje p){
        Random rand = new Random();
        int total = 0;
        for(int i=1;i<=p.getPotencialDefensa();i++){        
            int n = rand.nextInt(1,6);      //Calcula un numero random entre 1 y 6
            if ((n==5) || (n==6)) {                       //Si el numero random es 5 o 6, sumamos 1 al valor total del ataque.
                total = total + 1;
            }
        }
        return total;
    }

    
    
    
    //getters setters
    /**
     * @return the combate
     */
    public String getCombate() {
        return combate;
    }

    /**
     * @param combate the combate to set
     */
    public void setCombate(String combate) {
        this.combate = combate;
    }

    /**
     * @return the personaje1
     */
    public Personaje getPersonaje1() {
        return personaje1;
    }

    /**
     * @param personaje1 the personaje1 to set
     */
    public void setPersonaje1(Personaje personaje1) {
        this.personaje1 = personaje1;
    }

    /**
     * @return the personaje2
     */
    public Personaje getPersonaje2() {
        return personaje2;
    }

    /**
     * @param personaje2 the personaje2 to set
     */
    public void setPersonaje2(Personaje personaje2) {
        this.personaje2 = personaje2;
    }

    /**
     * @return the numRonda
     */
    public int getNumRonda() {
        return numRonda;
    }

    /**
     * @param numRonda the numRonda to set
     */
    public void setNumRonda(int numRonda) {
        this.numRonda = numRonda;
    }

    /**
     * @param ganador the ganador to set
     */
    public void setGanador(Personaje ganador) {
        this.ganador = ganador;
    }

    /**
     * @return the ataqueAPersonaje1
     */
    public int getAtaqueAPersonaje1() {
        return ataqueAPersonaje1;
    }

    /**
     * @param ataqueAPersonaje1 the ataqueAPersonaje1 to set
     */
    public void setAtaqueAPersonaje1(int ataqueAPersonaje1) {
        this.ataqueAPersonaje1 = ataqueAPersonaje1;
    }

    /**
     * @return the ataqueAPersonaje2
     */
    public int getAtaqueAPersonaje2() {
        return ataqueAPersonaje2;
    }

    /**
     * @param ataqueAPersonaje2 the ataqueAPersonaje2 to set
     */
    public void setAtaqueAPersonaje2(int ataqueAPersonaje2) {
        this.ataqueAPersonaje2 = ataqueAPersonaje2;
    }
    
    
}
