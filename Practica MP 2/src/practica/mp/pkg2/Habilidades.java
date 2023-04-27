/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 *
 * @author migue
 */

public class Habilidades implements Serializable {

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
        for (Habilidad u :this.getHabilidades()) {
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
        for (Habilidad u :this.getHabilidades()) {
            if(u instanceof Don) {
                imprimirInfo(u);
                don = (Don) u;
                System.out.println("Rabia minima: "+don.getValorMin());
            }
        }
    }
    
    public void mostrarTalentos(){
        System.out.println("\nTalentos:");
        System.out.println(getHabilidades().size());
        for (Habilidad u :this.getHabilidades()) {
            if(u instanceof Talento) {            
                imprimirInfo(u);
            }
        }
    }
    
    public void añadirHabilidad(Habilidad habilidad){
        this.habilidades.add(habilidad);
    }
    
     public Disciplina getDisciplina (String nombre) {
        for (Habilidad i: this.getHabilidades()) {
            if ((i.getClass()==Disciplina.class) && (i.getNombre().equals(nombre))) {
                Disciplina disciplina=(Disciplina) i;
                return disciplina;
            }
        }
        return null;
    }
    
    public Talento getTalento (String nombre) {
        for (Habilidad i: this.getHabilidades()) {
            if ((i.getClass()==Talento.class) && (i.getNombre().equals(nombre))) {
                Talento talento=(Talento) i;
                return talento;
            }
        }
        return null;
    }
    
    public Don getDon (String nombre) {
        for (Habilidad i: this.getHabilidades()) {
            if ((i.getClass()==Don.class) && (i.getNombre().equals(nombre))) {
                Don don=(Don) i;
                return don;
            }
        }
        return null;
    }
    

    /**
     * @return the habilidades
     */
    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    /**
     * @param habilidades the habilidades to set
     */
    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }
 
}
