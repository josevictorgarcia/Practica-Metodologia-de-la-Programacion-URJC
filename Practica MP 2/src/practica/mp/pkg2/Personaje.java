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
    private List<Modificador> modificadores;
    private List<Equipo> equipo;
    private List<Arma> armas_activas;
    private Equipo armadura_activa;
    private List<Esbirro> esbirros;
    private int oro;
    private int salud;                                  //Valor entre 0 y 5 --> Determinado por el numero de exitos.
    private int poder;                                  //Valor entre 1 y 5
    private int potencial_ataque;                       //Valor entre 0 y 5 --> Determinado por el numero de exitos.
    private int desafios_ganados;
    private int salud_esbirros;

    public Personaje (String nombre, Habilidad habilidad) {
        this.nombre=nombre;
        this.habilidad_especial=habilidad;
        
        this.modificadores=new ArrayList();
        this.equipo= new ArrayList();
        Arma arma = new Arma ("por defecto", 1,0,1,2) ; //arma por defecto
        Armadura armadura = new Armadura ("por defecto", 1, 0, 1);
        equipo.add(arma);
        equipo.add(armadura);
        this.armas_activas = new ArrayList();
        armas_activas.add(arma);
        this.armadura_activa=armadura;
        this.esbirros= new ArrayList();
        this.oro=50;  //50 de oro inicial
        this.salud=5;
        this.potencial_ataque=0;
        this.desafios_ganados=0;
        this.salud_esbirros=0;
        
    }
    
    @Override
    public int compareTo(Personaje p) {
        return this.desafios_ganados - p.desafios_ganados;
    }
    
    public void anadirItem(Equipo item){
        equipo.add(item);
    }
    
    public void modificarOro(int cant){
        oro=oro-cant;
    }
    
    public void ponerArmaActiva (Arma arma) {
        if (arma.getManos()==2) {
                armas_activas.clear();
                armas_activas.add(arma);
            }
        else {
            armas_activas.remove(0);
            armas_activas.add(0,arma);
        }
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
    
    public boolean oroSuficiente(int oro){
        if(oro<=this.oro){
            return true;
        }else{
            return false;
        }
    }
    
    
    public void añadirModificador(Modificador mod ) {
        this.modificadores.add(mod);
    }
    
    public void añadirEsbirro(Esbirro es) {
        this.esbirros.add(es);
    }
    
    public void calcularSaludEsbirros() {
        this.setSalud_esbirros(0);
        for (Esbirro i: this.esbirros) {
            this.setSalud_esbirros(this.getSalud_esbirros() + i.getSalud());
        }
    }
    
    
    public int calcularAtaqueEquipo () {
        int result=0;
        for (Arma i: this.armas_activas) {
            result+=i.getAtaque();
        }
        return result;
    }
    
    public int calcularModificadoresAtaque() {
        int result =0;
        for (Modificador i: this.modificadores) {
            if (i.isFortaleza()) {
                result+=i.getSensible();
            }
        }
        return result;
    }
    
    public int calcularModificadoresDefensa() {
        int result=0;
        for (Modificador i: this.modificadores) {
            if (!i.isFortaleza()) {
                result+=i.getSensible();
            }
        }
        return result;
    }
    
    
    
    
    
    //se va a overridear
    public int getPotencialDefensa() {
        return 0;
    }
    
    //getters setters
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
        return this.getPotencial_ataque();
    }
    
    public void setSalud(int n){
        this.salud = n;
    }

    public int getSalud(){
        return this.salud;
    }

    public void setPotencialAtaque(int n){       //Usamos polimorfismo de acuerdo a que tipo de personaje nos estamos refiriendo
        this.setPotencial_ataque(n);
    }

    public void setPoder(int n){
        this.poder = n;
    }

    public int getPoder(){
        return this.poder;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the habilidad_especial
     */
    public Habilidad getHabilidad_especial() {
        return habilidad_especial;
    }

    /**
     * @param habilidad_especial the habilidad_especial to set
     */
    public void setHabilidad_especial(Habilidad habilidad_especial) {
        this.habilidad_especial = habilidad_especial;
    }

    /**
     * @return the equipo
     */
    public List<Equipo> getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(List<Equipo> equipo) {
        this.equipo = equipo;
    }

    /**
     * @return the armas_activas
     */
    public List<Arma> getArmas_activas() {
        return armas_activas;
    }

    /**
     * @param armas_activas the armas_activas to set
     */
    public void setArmas_activas(List<Arma> armas_activas) {
        this.armas_activas = armas_activas;
    }

    /**
     * @return the armadura_activa
     */
    public Equipo getArmadura_activa() {
        return armadura_activa;
    }

    /**
     * @param armadura_activa the armadura_activa to set
     */
    public void setArmadura_activa(Equipo armadura_activa) {
        this.armadura_activa = armadura_activa;
    }

    /**
     * @return the esbirros
     */
    public List<Esbirro> getEsbirros() {
        return esbirros;
    }

    /**
     * @param esbirros the esbirros to set
     */
    public void setEsbirros(List<Esbirro> esbirros) {
        this.esbirros = esbirros;
    }

    /**
     * @return the oro
     */
    public int getOro() {
        return oro;
    }

    /**
     * @param oro the oro to set
     */
    public void setOro(int oro) {
        this.oro = oro;
    }

    /**
     * @return the potencial_ataque
     */
    public int getPotencial_ataque() {
        return potencial_ataque;
    }

    /**
     * @param potencial_ataque the potencial_ataque to set
     */
    public void setPotencial_ataque(int potencial_ataque) {
        this.potencial_ataque = potencial_ataque;
    }

    /**
     * @return the salud_esbirros
     */
    public int getSalud_esbirros() {
        return salud_esbirros;
    }

    /**
     * @param salud_esbirros the salud_esbirros to set
     */
    public void setSalud_esbirros(int salud_esbirros) {
        this.salud_esbirros = salud_esbirros;
    }
    
    
}
