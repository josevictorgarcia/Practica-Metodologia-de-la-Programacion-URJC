/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

import java.lang.*;

/**
 *
 * @author Alex
 */
public class Ronda {
    private String combate;
    private Personaje personaje1, personaje2;
    private int numRonda;
    private Personaje ganador;   //Para guardar al ganador de la ronda

    public Ronda (Combate c){                       
        this.combate = c.getID(); //Se puede poner como un puntero que apunta al combate principal, ya que en esta clase Ronda no modificaremos detalles del combate. Y Si lo hacemos, lo modificaremos en el combate original, mediante this.combate.
        this.personaje1 = c.getPersonaje1();
        this.personaje2 = c.getPersonaje2();
        this.numRonda = c.getRondas().size() + 1;
        this.ganador = null;
    }

    public Personaje getGanador(){
        return this.ganador;
    }

    public void calculoRonda(){                           
        int p1; int p2;
        //turno ataque jugador 1
        p1 = calculoNumExitosAtaque(this.personaje1);
        p2 = calculoNumExitosDefensa(this.personaje2);
        if (p1>p2) {
            if (this.personaje1.getSalud_esbirros()>0) {
                this.personaje1.setSalud(this.personaje1.getSalud()-1);}      //reduce la salud en 1 punto
            }
        else{
            this.personaje1.setSalud_esbirros(this.personaje1.getSalud_esbirros()-1);
        }
        //turno ataque jugador 2
        p1 = calculoNumExitosAtaque(this.personaje2);
        p2 = calculoNumExitosDefensa(this.personaje1);
        if (p1>p2) {
            if (this.personaje2.getSalud_esbirros()>0) {
                this.personaje2.setSalud(this.personaje2.getSalud()-1);}      //reduce la salud en 1 punto
            }
            else{
                this.personaje2.setSalud_esbirros(this.personaje2.getSalud_esbirros()-1);
            }
    }

    //calculoPotencialAtaque(){} no puede ir en esta clase. Debe ir en

    public int calculoNumExitosAtaque(Personaje p){
        int total = 0;
        for(int i=1;i<=p.getPotencialAtaque();i++){        
            int n = ((int)Math.random()*6)+1;      //Calcula un numero random entre 1 y 6
            if ((n==5) || (n==6)) {                       //Si el numero random es 5 o 6, sumamos 1 al valor total del ataque.
                total = total + 1;
            }
        }
        return total;
    }
    
    public int calculoNumExitosDefensa(Personaje p){
        int total = 0;
        for(int i=1;i<=p.getPotencialDefensa();i++){        
            int n = ((int)Math.random()*6)+1;      //Calcula un numero random entre 1 y 6
            if ((n==5) || (n==6)) {                       //Si el numero random es 5 o 6, sumamos 1 al valor total del ataque.
                total = total + 1;
            }
        }
        return total;
    }
}
