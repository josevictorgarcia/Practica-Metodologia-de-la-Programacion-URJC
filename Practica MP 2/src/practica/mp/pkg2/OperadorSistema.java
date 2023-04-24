/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */


public class OperadorSistema extends Usuario{
    
    public void editarPersonaje(Ranking rank) {
        Personaje per;
        per= menu.askPersonaje(rank);  //muestra ranking y pide que elija un personaje
        menu.askCambiarPersonaje(per); //pide los datos (nombre, etc) para cambiar al personaje y los cambia
    }
    
    public void completarPersonaje (Ranking rank ) {
        Personaje per;
        per= menu.askPersonaje(rank);  //muestra ranking y pide que elija un personaje para completar
        String opcion = menu.askAñadir();
        switch (opcion) {
            case "armas":
                Arma arma = menu.askArmaNueva(); //pide datos para el arma nueva y la devuelve como objeto
                per.añadirArma(arma);
                break;
            case "armaduras":
                Armadura armadura = menu.askArmaduraNueva();
                per.añadirArmadura(armadura);
                break;
            case "modificador":
                Modificador mod = menu.askModificadorNuevo();
                per.añadirModificador(mod);
                break;
            case "esbirros":
                Esbirro esbirro = menu.askEsbirroNuevo();
                per.añadirEsbirro(esbirro);
                break;
        }
    }
    
    public void validarDesafios () {
        Desafio des =menu.askDesafioValidar(baseDesafiosPendientes); //muestra desafios pendientes no validados y pide que elija uno para validarlo
        des.validar();
    }
    
    
}
