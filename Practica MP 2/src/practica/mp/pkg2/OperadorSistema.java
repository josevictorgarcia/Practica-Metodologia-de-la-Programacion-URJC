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
    
    public OperadorSistema (String nombre, String nick, String contrasena){
        this.setNombre(nombre);
        this.setNickname(nick);
        this.setContrasena(contrasena);
    }
    
    public void editarPersonaje(Ranking rank, Menu menu) {
        Personaje per;
        per= menu.askEditarPersonaje(rank);  //muestra ranking y pide que elija un personaje
        menu.askDatosPersonaje(per); //pide los datos (nombre, etc) para cambiar al personaje y los cambia
    }
    
    public void completarPersonaje (Ranking rank, Menu menu) {
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
    
    
    public void validarDesafios (Menu menu) {
        Desafio des =menu.askDesafioValidar(baseDesafiosPendientes); //muestra desafios pendientes no validados y pide que elija uno para validarlo
        des.validar();
    }
    
    public void banear(Menu menu) {
        Usuario user = menu.mostrarRanking(ranking); //elige un usuario a banear
        user.setBaneado(true);
    }
    
    public void desbanear(Menu menu) {
        Usuario user = menu.mostrarRanking(ranking);
        user.setBaneado(false);
    }
    
}
