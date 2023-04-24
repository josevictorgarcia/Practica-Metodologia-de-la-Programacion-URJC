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

public class Combate {
    private String id_combate;
    private Date fecha;
    private int n_desafios;
    private List<Ronda> rondas;
    private Personaje personaje1;       //Personaje 1 que participa en el combate
    private Personaje personaje2;       //Personaje 2 que participa en el combate

    public Personaje getPersonaje1(){
        return this.personaje1;
    }

    public Personaje getPersonaje2(){
        return this.personaje2;
    }

    public List<Ronda> getRondas(){
        return this.rondas;
    }

    public String getID(){
        return this.id_combate;
    }

    public void nuevaRonda(){
        Ronda r = new Ronda(this);              //Creamos una nueva ronda
        this.rondas.add(r);                     //Añadimos la ronda a la lista
    }

    public void desarrolloCombate(){
        while (this.personaje1.getSalud()!=0 && this.personaje2.getSalud()!=0){     //Bucle. Hasta que la salud de alguno de los personajes no sea cero:
            nuevaRonda();
            if (this.rondas.get(this.rondas.size()).getGanador().equals(this.personaje1))  {                 //Si el ganador de la ronda es el personaje 1, restamos 1 de salud al personaje     
                this.personaje1.setSalud(this.personaje1.getSalud() - 1);
            }
            else if (this.rondas.get(this.rondas.size()).getGanador().equals(this.personaje2)){
                this.personaje2.setSalud(this.personaje2.getSalud() - 1);
            }   //Puede ocurrir que el ganador de una ronda sea null (empate). En ese caso no se entraria por ninguna rama del if-else
        }
    }
}
