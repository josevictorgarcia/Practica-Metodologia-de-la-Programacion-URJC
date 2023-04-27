/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
import java.io.*;
import java.util.*;
//guarda la informacion del Cliente y se le llama para hacer las acciones a las que tiene derecho
public class Cliente extends Usuario implements Serializable{
    private String numRegistro;
    private Personaje personaje;
    private List<Desafio> desafiosPendientes;
    private List<Combate> ultimosCombates;
    private Menu menu;
    
    public Cliente (String nombre, String nickname, String contrasena, Menu menu, GeneradorIDs generador) {
        super(nombre, nickname,contrasena);
        this.menu=menu;
        this.desafiosPendientes=new ArrayList();
        this.ultimosCombates= new ArrayList();
        this.numRegistro=generador.getID();
        personaje= new Personaje(this.getNombre(), new Habilidad("por defecto",0,0)); //por defecto crea un personaje con su mismo nombre
    }
    
    public void cambiarPersonaje() {
        //ranking.eliminar(personaje) ??? Si cambias de personaje lo eliminamos del ranking?
        setPersonaje(menu.askPersonajeNuevo());
        //baseUsuarios.save() ?? para que el cambio quede reflejado a los que le desafien despues mientras aun no ha finalizado el programa?  En general en cualquier cambio a 
        //personaje también
        
    }
    
    //elegir armas o armaduras activas
    public void elegirEquipo() {
        String equipo= menu.askElegirEquipo(); //elegir si quiere cambiar un arma o una armadura
        if (equipo.equals("armas")) {
            Arma arma = menu.askArma(this.getPersonaje().getEquipo(), this.getPersonaje().getArmas_activas()); //muestra todas las armas activas y no activas y pide que elija una para poner activa
            if (arma !=null) {
                this.getPersonaje().ponerArmaActiva(arma);  //cambia la última arma de la lista por la que le pasamos como parámetro
            }
        }
        else {
            Armadura armadura = menu.askArmadura(this.getPersonaje().getEquipo()); //muestra armaduras y pide elegir una para ponerla activa
            if (armadura != null) {
                this.getPersonaje().setArmadura_activa(armadura);
            }
        }
    }
    
    public void desafiar (Ranking ranking, GeneradorIDs generador) {
        Cliente desafiado= menu.askDesafiado(ranking);
        int oro=menu.askOroApostado(this.getPersonaje().getOro(), desafiado.getPersonaje().getOro());
        Desafio des = new Desafio(this.getPersonaje(), desafiado.getPersonaje(), oro, generador);
        enviarDesafio(des, desafiado); //añade el desafio a desafiosPendientes del desafiado
    }
    
    
    //el usuario solo acepta desafios, no los rechaza. Si no quiere 
    public void responderDesafios () {
        List<Integer> list = new ArrayList();
        int pos=0;
        for (Desafio i: this.desafiosPendientes) {
            if (i.isValidado()) {
                boolean respuesta = menu.askDesafio(i); //pide si quiere responder el desafio o no
                if (respuesta) {
                    i.aceptar(menu);
                }
                else {
                    i.rechazar();
                }
                list.add(pos);
                
            }
            pos++;
        }
        
        for (int i=list.size()-1; i>=0; i--) {
            System.out.println(this.desafiosPendientes.size());
            this.desafiosPendientes.remove((int)list.get(i));
            System.out.println(i); //debugging
            System.out.println(this.desafiosPendientes.size());
        }
    }
    
    public boolean hayDesafios () {
        boolean result=false;
        for (Desafio i: this.desafiosPendientes) {
            if (i.isValidado()) {
                result=true;
            }
        }
        return result;
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
    
    public void comprarItem (Tienda tienda) {
        menu.mostrarString("El oro que tienes es: " + this.getPersonaje().getOro());
        Equipo item= menu.pedirItemTienda(tienda);
        if (item!=null) {
            if (item.getCoste() <= this.getPersonaje().getOro()) {
                this.getPersonaje().setOro(this.getPersonaje().getOro()-item.getCoste());
                this.getPersonaje().anadirItem(item);
                menu.mostrarString("Comprado");
            }
            else {
                menu.mostrarString("No tienes suficiente oro");
            }
        }
    }
    
   

    
    
    
    
    //getters y setters
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
