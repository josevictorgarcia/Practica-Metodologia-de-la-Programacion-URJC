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
public class OperadorSistema extends Usuario implements Serializable{
    
    private Menu menu;
    public OperadorSistema (String nombre, String nick, String contrasena, Menu menu){
        super(nombre, nick, contrasena);
        this.menu= menu;
    }
    
    public void editarPersonaje(Ranking rank) {
        Personaje per;
        per= menu.askEditarPersonaje(rank);  //muestra ranking y pide que elija un personaje
        menu.askDatosPersonaje(per); //pide los datos (nombre, etc) para cambiar al personaje y los cambia
    }
    
    public void completarPersonaje (Ranking rank, Equipos equipos) {
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
            default:
                boolean vampiro = per instanceof Vampiro;
                Esbirro esbirro = menu.askEsbirroNuevo(vampiro);
                per.añadirEsbirro(esbirro);
                break;
        }
    }
    
    
    public void validarDesafios (Ranking ranking) {
        Desafio des =menu.askDesafioValidar(ranking); //muestra desafios pendientes no validados y pide que elija uno para validarlo
        if (des!=null) {
            des.validar();
        }
    }
    
    public void banear(Ranking ranking) {
        Usuario user = menu.askUsuarioBanear(ranking); //elige un usuario a banear
        if (user!=null) {
            user.setBaneado(true);
        }
    }
    
    public void desbanear(Ranking ranking) {
        Usuario user = menu.askUsuarioDesbanear(ranking);
        if (user!=null) {
            user.setBaneado(false);
        }
    }
    
    public void añadirItemTienda(Equipos equipos) {
        Equipo equipo = menu.askItemNuevo();
        equipos.anadirEquipo(equipo);
    }
    
     public void añadirHabilidad(Habilidades habilidades) throws FileNotFoundException{
        System.out.println(habilidades.getHabilidades().size());
        String respuesta = menu.pedirString("Escriba lo que quiera añadir: 'disciplina', 'don' o cualquier otra cosa para talento");
        Habilidad habilidad;
        if (respuesta.equals("disciplina")){
            habilidad=menu.askDisciplinaNueva();
        } else if(respuesta.equals("don")){
            habilidad=menu.askDonNuevo();
        }else {
            habilidad=menu.askTalentoNuevo();
        }
        habilidades.añadirHabilidad(habilidad);
        System.out.println(habilidades.getHabilidades().size());
     }
    
}
