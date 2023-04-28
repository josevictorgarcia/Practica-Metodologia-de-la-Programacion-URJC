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

//guarda la informacion del Cliente y contiene la logica de las acciones a las que tiene derecho
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
    
    //cambia el personaje del cliente a uno nuevo decidido por el usuario
    public void cambiarPersonaje(Habilidades habilidades) throws FileNotFoundException {
        setPersonaje(menu.askPersonajeNuevo(habilidades));
    }
    
    //elege que armas o armaduras quiere tener activas
    public void elegirEquipo() {
        String equipo= getMenu().askElegirEquipo(); //elegir si quiere cambiar un arma o una armadura
        if (equipo.equals("armas")) {
            Arma arma = getMenu().askArma(this.getPersonaje().getEquipo(), this.getPersonaje().getArmas_activas()); //muestra todas las armas activas y no activas y pide que elija una para poner activa
            if (arma !=null) {
                this.getPersonaje().ponerArmaActiva(arma);  //cambia la última arma de la lista por la que le pasamos como parámetro
            }
        }
        else {
            Armadura armadura = getMenu().askArmadura(this.getPersonaje().getEquipo()); //muestra armaduras y pide elegir una para ponerla activa
            if (armadura != null) {
                this.getPersonaje().setArmadura_activa(armadura);
            }
        }
    }
    
    //crea un desafio según el usuario y lo envia al usuario desafiado esperando que un Operador lo valide y después que el desafiado lo acepte o rechace
    public void desafiar (Ranking ranking, GeneradorIDs generador) {
        Cliente desafiado= getMenu().askDesafiado(ranking);
        int oro=getMenu().askOroApostado(this.getPersonaje().getOro(), desafiado.getPersonaje().getOro());
        Desafio des = new Desafio(this.getPersonaje(), desafiado.getPersonaje(), oro, generador, this);
        enviarDesafio(des, desafiado); //añade el desafio a desafiosPendientes del desafiado
    }
    
    
    //se muestra al usuario los Desafios a los que ha sido retado, pide una respuesta y los ejecuta
    public void responderDesafios (Ranking ranking) {
        List<Integer> list = new ArrayList();
        int pos=0;
        for (Desafio i: this.desafiosPendientes) {
            if (i.isValidado()) {
                boolean respuesta = getMenu().askDesafio(i); //pide si quiere responder el desafio o no
                if (respuesta) {
                    i.aceptar(getMenu());
                    this.ultimosCombates.add(i.getCombate());
                    i.getUserDesafiante().añadirCombate(i.getCombate());
                    ranking.actualizarRanking();
                }
                else {
                    i.rechazar();
                }
                list.add(pos);
                
            }
            pos++;
        }
        
        for (int i=list.size()-1; i>=0; i--) {
            this.desafiosPendientes.remove((int)list.get(i));
        }
    }
    
    //devuelve si el usuario tiene desafios pendientes que responder
    public boolean hayDesafios () {
        boolean result=false;
        for (Desafio i: this.desafiosPendientes) {
            if (i.isValidado()) {
                result=true;
            }
        }
        return result;
    }
    
    //añade el combate el registro de los últimos combates
    public void añadirCombate (Combate comb) {
        this.ultimosCombates.add(comb);
    }
    
    //consulta los ultimos combates guardados
    public void consultaCombates () {
        getMenu().mostrarCombates(this.ultimosCombates);
    }
    
    
    public void consultaRanking (Ranking rank) {
        rank.mostrarRanking();
    }
    
    //añade el desafio a desafiosPendientes del desafiado
    public void enviarDesafio(Desafio des, Cliente desafiado) {
        desafiado.desafiosPendientes.add(des);
    }
    
    //ejecuta la compra del item que se elija
    public void comprarItem (Tienda tienda) {
        getMenu().mostrarString("El oro que tienes es: " + this.getPersonaje().getOro());
        Equipo item= getMenu().pedirItemTienda(tienda);
        if (item!=null) {
            if (item.getCoste() <= this.getPersonaje().getOro()) {
                this.getPersonaje().setOro(this.getPersonaje().getOro()-item.getCoste());
                this.getPersonaje().anadirItem(item);
                getMenu().mostrarString("Comprado");
            }
            else {
                getMenu().mostrarString("No tienes suficiente oro");
            }
        }
    }
    
    
    
    //getters y setters
    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }
   
    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public List<Desafio> getDesafiosPendientes() {
        return desafiosPendientes;
    }

    public void setDesafiosPendientes(List<Desafio> desafiosPendientes) {
        this.desafiosPendientes = desafiosPendientes;
    }

    public List<Combate> getUltimosCombates() {
        return ultimosCombates;
    }

    public void setUltimosCombates(List<Combate> ultimosCombates) {
        this.ultimosCombates = ultimosCombates;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
