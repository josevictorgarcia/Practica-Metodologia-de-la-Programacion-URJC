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
    private int salud;
    private int poder;
    private int potencial_ataque; 
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
    
}
