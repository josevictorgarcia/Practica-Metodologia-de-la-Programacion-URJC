/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
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
            Arma arma = menu.askArma(this.personaje.getEquipo(), this.personaje.getArmas_activas());
            this.personaje.ponerArmaActiva(arma);  //cambia la última de la lista por la que le pasamos como parámetro
        }
        else {
            Armadura armadura = menu.askArmadura(this.personaje.getEquipo(), this.personaje.getArmadura_activa());
            this.personaje.ponerArmaduraActiva(armadura);
        }
    }
    
    public void desafiar () {
        String desafiado;
        int oro;
        menu.askDesafio(desafiado, oro);
        Desafio des = new Desafio(this.getNombre(), desafiado, oro);
        enviarDesafio(Desafio, desafiado);
    }
    
    public void responderDesafios (BaseDesafiosPendientes base) {
        //mucho texto
    }
    
    public void consultaCombates (BaseCombates base) {
        List<Combate> list = base.getCombates(this.getNombre());
        menu.mostrarCombates(list);
    }
    
    public void consultaRanking (Ranking rank) {
        menu.mostrarRanking(rank);
    }
}
