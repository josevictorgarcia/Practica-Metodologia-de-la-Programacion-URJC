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
        
public class Personaje {
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
    
    public Personaje (String nombre) {
        this.nombre=nombre;
    }
    
    
}
