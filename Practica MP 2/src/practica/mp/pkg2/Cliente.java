/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */

//guarda la informacion del Cliente y se le llama para hacer las acciones a las que tiene derecho
public class Cliente extends Usuario{
    private String numRegistro;
    private Personaje personaje;
    
    public Cliente () {
        super();
        personaje= new Personaje(this.getNombre()); //por defecto crea un personaje con su mismo nombre
    }
    
    public void cambiarPersonaje() {
        String nombrePersonaje;
        menu.askPersonajeDatos(nombrePersonaje);
        //ranking.eliminar(personaje) ??? Si cambias de personaje lo eliminamos del ranking?
        personaje = new Personaje(nombrePersonaje);
        //baseUsuarios.save() ?? para que el cambio quede reflejado a los que le desafien despues mientras aun no ha finalizado el programa?  En general en cualquier cambio a 
        //personaje también
        
    }
    
    //elegir armas o armaduras activas
    public void elegirEquipo() {
        String equipo= menu.askElegirEquipo(); //elegir si quiere cambiar un arma o una armadura
        if (equipo=="armas") {
            Arma arma = menu.askArma(this.personaje.getEquipo(), this.personaje.getArmas_activas()); //muestra todas las armas activas y no activas y pide que elija una para poner activa
            this.personaje.ponerArmaActiva(arma);  //cambia la última arma de la lista por la que le pasamos como parámetro
        }
        else {
            Armadura armadura = menu.askArmadura(this.personaje.getEquipo(), this.personaje.getArmadura_activa()); //muestra armaduras y pide elegir una para ponerla activa
            this.personaje.ponerArmaduraActiva(armadura);
        }
    }
    
    public void desafiar () {
        String desafiado;
        int oro;
        menu.askDesafio(desafiado, oro); //pide el nombre de usuario y el oro que desea apostar
        Desafio des = new Desafio(this.getNombre(), desafiado, oro);
        enviarDesafio(Desafio, desafiado); //sube el desafio a baseDesafiosPendientes
    }
    
    
    //el usuario solo acepta desafios, no los rechaza. Si no quiere 
    public void responderDesafios (BaseDesafiosPendientes base) {
        des.aceptar();
    }
    
    public void consultaCombates (BaseCombates base) {
        List<Combate> list = base.getCombates(this.getNombre());
        menu.mostrarCombates(list);
    }
    
    public void consultaRanking (Ranking rank) {
        menu.mostrarRanking(rank);
    }
}
