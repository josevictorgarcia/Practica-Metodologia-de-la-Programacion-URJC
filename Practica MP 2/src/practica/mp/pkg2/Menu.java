/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
public class Menu {
    
    //pregunta en bubcle que hacer y le dice al usuario que lo haga
    public void inicio (Usuario user) {
        boolean end = false;
        Accion accion;
        while (!end) {
            pedirAccion(accion);
            switch (accion) {
                case DarseBaja:
                    user.darseBaja();
                    break;
                case SalirSistema:
                    end=true;
                    break;
                case ModificarPersonajes:
                    user.modificarPersonajes();
                    break;
                case ElegirEquipo:
                    user.elegirEquipo();
                    break;
                case Desafiar:
                    user.desafiar();
                    break;
                case ResponderDesafios:
                    user.responderDesafios();
                    break;
                case ConsultaCombates:
                    user.consultaCombates();
                    break;
                case ConsultaRanking:
                    user.consultaRanking();
                    break;
            }
        }
    }
}
