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
            if(u instanceof Disciplina) {
                imprimirInfo(u);
                disciplina = (Disciplina) u;
                System.out.println("Coste: "+disciplina.getCoste());
            }
        }
    }
    
    public void mostrarDones(){
        System.out.println("\nDones:");
        Don don;
        for (Habilidad u :this.habilidades) {
            if(u instanceof Don) {
                imprimirInfo(u);
                don = (Don) u;
                System.out.println("Rabia minima: "+don.getValorMin());
            }
        }
    }
    
    public void mostrarTalentos(){
        System.out.println("\nTalentos:");
        for (Habilidad u :this.habilidades) {
            if(u instanceof Talento) {            
                imprimirInfo(u);
            }
        }
    }
    
    public void añadirHabilidad(Habilidad habilidad){
        this.habilidades.add(habilidad);
    }
    
     public Disciplina getDisciplina (String nombre) {
        for (Habilidad i: this.habilidades) {
            if ((i.getClass()==Disciplina.class) && (i.getNombre().equals(nombre))) {
                Disciplina disciplina=(Disciplina) i;
                return disciplina;
            }
        }
        return null;
    }
    
    public Talento getTalento (String nombre) {
        for (Habilidad i: this.habilidades) {
            if ((i.getClass()==Talento.class) && (i.getNombre().equals(nombre))) {
                Talento talento=(Talento) i;
                return talento;
            }
        }
        return null;
    }
    
    public Don getDon (String nombre) {
        for (Habilidad i: this.habilidades) {
            if ((i.getClass()==Don.class) && (i.getNombre().equals(nombre))) {
                Don don=(Don) i;
                return don;
            }
        }
        return null;
    }
}
