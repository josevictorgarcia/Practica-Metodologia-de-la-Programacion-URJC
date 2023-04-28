/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Combate implements Serializable{
    private String id_combate;
    private Date fecha;
    private int n_desafios;
    private List<Ronda> rondas;
    private Personaje personaje1;       //Personaje 1 que participa en el combate
    private Personaje personaje2;       //Personaje 2 que participa en el combate
    private Personaje ganador;
    
    public Combate(Personaje p1, Personaje p2) {
        this.ganador=null;
        this.personaje1=p1;
        this.personaje2=p2;
        this.fecha= new Date();
        this.id_combate= generarID(p1,p2,fecha);
        this.rondas= new ArrayList();
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
        return this.getId_combate();
    }

    //crea una ronda y la ejecuta
    public void nuevaRonda(){
        Ronda r = new Ronda(this);
        r.calculoRonda();
        this.rondas.add(r);                     //Añadimos la ronda a la lista
    }

    //metodo principal que incluye la logica del combate. El combate se compone de sucesivas rondas hasta que al menos un personaje tiene salud 0
    public void desarrolloCombate(){
        condicionesIniciales();
        while (this.personaje1.getSalud()>0 && this.personaje2.getSalud()>0){     //Bucle. Hasta que la salud de alguno de los personajes no sea cero:
            nuevaRonda();
            }
        if (this.personaje1.getSalud()==0 && this.personaje2.getSalud()==0) {
            this.setGanador(null);
        }
        else {
            if (this.personaje1.getSalud()==0) {
                this.setGanador(this.personaje2);
            }
            else{
                this.setGanador(this.personaje1);
            }
        }
    }
    
    //genera un ID unico en funcion de la fecha y los personajes implicados
    private String generarID(Personaje p1, Personaje p2, Date fecha){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(fecha);
        return p1.getNombre()+p2.getNombre()+strDate;
    }
    
    //pone a los personajes con los parametros iniciales necesarios
    private void condicionesIniciales() {
        this.personaje1.prepararCombate();
        this.personaje2.prepararCombate();
    }
    
    
    
    /**
     * @return the id_combate
     */
    public String getId_combate() {
        return id_combate;
    }

    /**
     * @param id_combate the id_combate to set
     */
    public void setId_combate(String id_combate) {
        this.id_combate = id_combate;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the n_desafios
     */
    public int getN_desafios() {
        return n_desafios;
    }

    /**
     * @param n_desafios the n_desafios to set
     */
    public void setN_desafios(int n_desafios) {
        this.n_desafios = n_desafios;
    }

    /**
     * @param rondas the rondas to set
     */
    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }

    /**
     * @param personaje1 the personaje1 to set
     */
    public void setPersonaje1(Personaje personaje1) {
        this.personaje1 = personaje1;
    }

    /**
     * @param personaje2 the personaje2 to set
     */
    public void setPersonaje2(Personaje personaje2) {
        this.personaje2 = personaje2;
    }

    /**
     * @return the ganador
     */
    public Personaje getGanador() {
        return ganador;
    }

    /**
     * @param ganador the ganador to set
     */
    public void setGanador(Personaje ganador) {
        this.ganador = ganador;
    }
}
