/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 */
public class Habilidades {
    private List<Habilidad> habilidades;
    
    public Habilidades(){
        this.habilidades= new ArrayList();
    }
    
    public void imprimirInfo(Habilidad habilidad){
        System.out.println("Nombre: " + habilidad.getNombre());
        System.out.println("Valor de ataque: " + habilidad.getAtaque());
        System.out.println("Valor de defensa: " + habilidad.getDefensa());
    }
    
    public void mostrarDisciplinas(){
        System.out.println("\nDisciplinas:");
        Disciplina disciplina;
        for (Habilidad u :this.habilidades) {
            if(u.getClass()==Disciplina.class)                
                imprimirInfo(u);
                disciplina = (Disciplina) u;
                System.out.println("Coste: "+disciplina.getCoste());
        }
    }
    
    public void mostrarDones(){
        System.out.println("\nDones:");
        Don don;
        for (Habilidad u :this.habilidades) {
            if(u.getClass()==Don.class)                
                imprimirInfo(u);
                don = (Don) u;
                System.out.println("Rabia minima: "+don.getValorMin());
        }
    }
    
    public void mostrarTalentos(){
        System.out.println("\nTalentos:");
        for (Habilidad u :this.habilidades) {
            if(u.getClass()==Disciplina.class)                
                imprimirInfo(u);
        }
    }
    
    public void añadirHabilidad(Habilidad habilidad){
        this.habilidades.add(habilidad);
    }
}
