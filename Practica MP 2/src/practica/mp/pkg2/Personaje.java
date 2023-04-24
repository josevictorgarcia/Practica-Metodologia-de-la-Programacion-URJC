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
import java.io.Serializable;

public class Personaje implements Serializable, Comparable<Personaje>{
    private String nombre;
    private Habilidad habilidad_especial;
    private List<Equipo> equipo;
    private List<Equipo> armas_activas;
    private Equipo armadura_activa;
    private List<Esbirro> esbirros;
    private int oro;
    private int salud;                                  //Valor entre 0 y 5 --> Determinado por el numero de exitos.
    private int poder;                                  //Valor entre 1 y 5
    private int potencial_ataque;                       //Valor entre 0 y 5 --> Determinado por el numero de exitos.
    private int desafios_ganados;

    public Personaje (String nombre) {
        this.nombre=nombre;
    }
    
    @Override
    public int compareTo(Personaje p) {
        return this.desafios_ganados - p.desafios_ganados;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDesafios_ganados() {
        return desafios_ganados;
    }

    public void setDesafios_ganados(int desafios_ganados) {
        this.desafios_ganados = desafios_ganados;
    }

    public int getPotencialAtaque(){
        return this.potencial_ataque;
    }
    
    public void setSalud(int n){
        this.salud = n;
    }

    public int getSalud(){
        return this.salud;
    }

    public void setPotencialAtaque(int n){       //Usamos polimorfismo de acuerdo a que tipo de personaje nos estamos refiriendo
        this.potencial_ataque = n;
    }

    public void setPoder(int n){
        this.poder = n;
    }

    public int getPoder(){
        return this.poder;
    }

    @Override
    public boolean equals(Object o){ 
        if (o==this) {return true;}
        else if (!(o instanceof Personaje)) {return false;}
        else {
            Personaje p = (Personaje) o;
            return (p.getNombre()==this.getNombre());
        }
    }
}
