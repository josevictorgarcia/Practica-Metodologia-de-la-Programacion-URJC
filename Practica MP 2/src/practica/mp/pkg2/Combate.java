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
    private Personaje ganador;
    
    public Combate(Personae p1, Personaje p2) {
        this.ganador=null;
        this.personaje1=p1;
        this.personaje2=p2;
        this.fecha= new Date();
        this.id_combate= generarID();
    }

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
        r.calculoRonda();
        this.rondas.add(r);                     //Añadimos la ronda a la lista
    }

    public void desarrolloCombate(){
        while (this.personaje1.getSalud()!=0 && this.personaje2.getSalud()!=0){     //Bucle. Hasta que la salud de alguno de los personajes no sea cero:
            nuevaRonda();
            }
        if (this.personaje1.getSalud()==0 && this.personaje2.getSalud()==0) {
            this.ganador=null;
        }
        else {
            if (this.personaje1.getSalud()==0) {
                this.ganador=this.personaje1;
            }
            else{
                this.ganador=this.personaje2;
            }
        }
    }
}
