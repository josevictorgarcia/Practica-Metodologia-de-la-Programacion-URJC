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
        super(nombre, nick, contrasena);
    }
    
    public void editarPersonaje(Ranking rank, Menu menu) {
        Personaje per;
        per= menu.askEditarPersonaje(rank);  //muestra ranking y pide que elija un personaje
        menu.askDatosPersonaje(per); //pide los datos (nombre, etc) para cambiar al personaje y los cambia
    }
    
    public void completarPersonaje (Ranking rank, Menu menu) {
        Personaje per;
        per= menu.askPersonaje(rank);  //muestra ranking y pide que elija un personaje para completar
        String opcion = menu.askAñadirAPersonaje();
        switch (opcion) {
            case "armas":
                Arma arma = menu.askArmaNueva(); //pide datos para el arma nueva y la devuelve como objeto
                per.anadirItem(arma);
                equipos.anadirEquipo(arma);
                break;
            case "armaduras":
                Armadura armadura = menu.askArmaduraNueva();
                per.anadirItem(armadura);
                equipos.anadirEquipo(armadura);
                break;
            case "modificador":
                Modificador mod = menu.askModificadorNuevo();
                per.añadirModificador(mod);
                break;
            case "esbirros":
                boolean vampiro = per instanceof Vampiro;
                Esbirro esbirro = menu.askEsbirroNuevo(vampiro);
                per.añadirEsbirro(esbirro);
                break;
        }
    }
    
    
    public void validarDesafios (Ranking ranking, Menu menu) {
        Desafio des =menu.askDesafioValidar(ranking); //muestra desafios pendientes no validados y pide que elija uno para validarlo
        if (des!=null) {
            des.validar();
        }
    }
    
    public void banear(Menu menu) {
        Usuario user = menu.askUsuarioBanearranking); //elige un usuario a banear
        if (user!=null) {
            user.setBaneado(true);
        }
    }
    
    public void desbanear(Menu menu) {
        Usuario user = menu.askUsuarioDesbanear(ranking);
        if (user!=null) {
            user.setBaneado(false);
        }
    }
    
}
