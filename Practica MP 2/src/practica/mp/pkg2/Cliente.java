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
//guarda la informacion del Cliente y se le llama para hacer las acciones a las que tiene derecho
public class Cliente extends Usuario{
    private String numRegistro;
    private Personaje personaje;
    private List<Desafio> desafiosPendientes;
    private List<Combate> ultimosCombates;
    
    public Cliente (String nombre, String nickname, String contrasena) {
        super(nombre, nickname,contrasena);
        this.numRegistro=generarNumRegistro();
        personaje= new Personaje(this.getNombre()); //por defecto crea un personaje con su mismo nombre
    }
    
    public void cambiarPersonaje() {
        String nombrePersonaje;
        nombrePersonaje= menu.askNombrePersonaje();
        //ranking.eliminar(personaje) ??? Si cambias de personaje lo eliminamos del ranking?
        setPersonaje(new Personaje(nombrePersonaje));
        //baseUsuarios.save() ?? para que el cambio quede reflejado a los que le desafien despues mientras aun no ha finalizado el programa?  En general en cualquier cambio a 
        //personaje también
        
    }
    
    //elegir armas o armaduras activas
    public void elegirEquipo() {
        String equipo= menu.askElegirEquipo(); //elegir si quiere cambiar un arma o una armadura
        if (equipo.equals("armas")) {
            Arma arma = menu.askArma(this.getPersonaje().getEquipo(), this.getPersonaje().getArmas_activas()); //muestra todas las armas activas y no activas y pide que elija una para poner activa
            this.getPersonaje().ponerArmaActiva(arma);  //cambia la última arma de la lista por la que le pasamos como parámetro
        }
        else {
            Armadura armadura = menu.askArmadura(this.getPersonaje().getEquipo(), this.getPersonaje().getArmadura_activa()); //muestra armaduras y pide elegir una para ponerla activa
            this.getPersonaje().setArmadura_activa(armadura);
        }
    }
    
    public void desafiar () {
        Cliente desafiado= menu.askDesafiado();
        int oro=menu.askOroApostado(this.getPersonaje().getOro());
        Desafio des = new Desafio(this.getPersonaje(), desafiado.getPersonaje(), oro);
        enviarDesafio(des, desafiado); //añade el desafio a desafiosPendientes del desafiado
    }
    
    
    //el usuario solo acepta desafios, no los rechaza. Si no quiere 
    public void responderDesafios () {
        Desafio des= menu.mostrarDesafios(this.getDesafiosPendientes());
        des.aceptar();
    }
    
    public void consultaCombates () {
        menu.mostrarCombates(this.ultimosCombates);
    }
    
    public void consultaRanking (Ranking rank) {
        menu.mostrarRanking(rank);
    }
    
    public void enviarDesafio(Desafio des, Cliente desafiado) {
        desafiado.desafiosPendientes.add(des);
    }

    /**
     * @return the numRegistro
     */
    public String getNumRegistro() {
        return numRegistro;
    }

    /**
     * @param numRegistro the numRegistro to set
     */
    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    /**
     * @return the personaje
     */
    public Personaje getPersonaje() {
        return personaje;
    }

    /**
     * @param personaje the personaje to set
     */
    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    /**
     * @return the desafiosPendientes
     */
    public List<Desafio> getDesafiosPendientes() {
        return desafiosPendientes;
    }

    /**
     * @param desafiosPendientes the desafiosPendientes to set
     */
    public void setDesafiosPendientes(List<Desafio> desafiosPendientes) {
        this.desafiosPendientes = desafiosPendientes;
    }

    /**
     * @return the ultimosCombates
     */
    public List<Combate> getUltimosCombates() {
        return ultimosCombates;
    }

    /**
     * @param ultimosCombates the ultimosCombates to set
     */
    public void setUltimosCombates(List<Combate> ultimosCombates) {
        this.ultimosCombates = ultimosCombates;
    }
}
