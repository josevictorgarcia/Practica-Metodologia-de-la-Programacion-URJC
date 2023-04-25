
package practica.mp.pkg2;

import java.util.*;

/**
 *
 * @author Alex
 */


//Clase principal que inicia el programa.
//No se podia en MetProgUrjcGame porque se usa estático y no se podian invocar objetos
public class App {
    
    private Ranking ranking;
    private Menu menu;
    private Usuario usuarioActivo;

    public App() {
        menu = new Menu();
    }
    
    //es el main pero sin ser estático
    public void run() throws InterruptedException {
        Usuario user = null;
        while (user==null){
            user = menu.inicio();
        }
        //loadBase();
        //loadRanking();
        //while (!inicioSesion(menu, usuarioActivo)) {} //se queda en blucle hasta que el usuario se registre o se loguee
        //menu.inicio(usuarioActivo, baseUsers);
        //ranking.save();
        //baseUsers.save();
        //pregunta en bucle que hacer y le dice al usuario que lo haga
        
        boolean end=false;
        if (user instanceof Cliente) { //acciones diferentes dependiendo de si es cliente o operadorSistema
            Cliente cliente= (Cliente) user;
            AccionCliente accionCliente;
            while (!end) {  //bucle hata que se elija DarseBaja o SalirSistema
                menu.pedirAccionCliente(accionCliente); //pide al usuario que elija una accion
                switch (accionCliente) {
                    case DarseBaja:
                        cliente.darseBaja(ranking);
                        end=true;
                        break;
                    case SalirSistema:
                        end=true;
                        break;
                    case CambiarPersonaje:
                        cliente.cambiarPersonaje();
                        break;
                    case ElegirEquipo:
                        cliente.elegirEquipo();
                        break;
                    case Desafiar:
                        cliente.desafiar();
                        break;
                    case ResponderDesafios:
                        cliente.responderDesafios();
                        break;
                    case ConsultaCombates:
                        cliente.consultaCombates();
                        break;
                    case ConsultaRanking:
                        cliente.consultaRanking();
                        break;
                }
            }
        } 
        else {
            OperadorSistema op= (OperadorSistema) user;
            while (!end) { //bucle hasta que se elija DarseBaja o SalirSistema
                pedirAccionOperador(accionOp);
                switch (accionOp) {
                    case DarseBaja:
                        op.darseBaja(base);
                        end=true;
                        break;
                    case SalirSistema:
                        end=true;
                        break;
                    case EditarPersonaje:
                        op.cambiarPersonaje();
                        break;
                    case CompletarPersonaje:
                        op.elegirEquipo();
                        break;
                    case ValidarDesafios:
                        op.desafiar();
                        break;
                    case Banear:
                        op.responderDesafios();
                        break;
                    case Desbanear:
                        op.consultaCombates();
                        break;
                }
            }
        }    
    }
        
        
        
    }
    
    //carga los usuarios y contraseñas de memoria con un read
    private void loadBase() {
        baseUsers = new BaseUsuarios();
        baseUsers.load();
    }
    
    
    
    private void loadRanking() {
        ranking= new Ranking();
        ranking.mostrarRanking();
    }
}
