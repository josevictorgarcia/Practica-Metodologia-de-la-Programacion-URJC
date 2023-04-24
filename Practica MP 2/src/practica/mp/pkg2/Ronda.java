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

    public void calculoGanadorRonda(){              //Asigna el ganador de la ronda                            
        int p1; int p2;
        p1 = calculoNumExitos(this.personaje1);
        p2 = calculoNumExitos(this.personaje2);
        if (p1>p2) {this.ganador = this.personaje1;}             //Si el numero de exitos fuera igual en los dos personajes, el ganador seria null. Y al calcular a cual de los dos se le resta salud, no seria ninguno porque el metodo equals devolveria false
        else {this.ganador = this.personaje2;}
    }

    //calculoPotencialAtaque(){} no puede ir en esta clase. Debe ir en

    public int calculoNumExitos(Personaje p){
        int total = 0;
        for(int i=1;i<=p.getPotencialAtaque();i++){        
            int n = (((int)Math.random()*10)%6)+1;      //Calcula un numero random entre 1 y 6
            if ((n==5) || (n==6)) {                       //Si el numero random es 5 o 6, sumamos 1 al valor total del ataque.
                total = total + 1;
            }
        }
        return total;
    }
}
