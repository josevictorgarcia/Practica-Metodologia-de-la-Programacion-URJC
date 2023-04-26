
package practica.mp.pkg2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        ranking = loadRanking();
        menu = new Menu();
    }
    
    //es el main pero sin ser estático
    public void run() throws InterruptedException {
        Usuario user = null;
        while (user==null || user.isBaneado()){
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
                if (cliente.hayDesafios()) { //comprueba si hay desafios validados que deba responder inmediatamente
                    cliente.responderDesafios();
                }
                else {
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
                            cliente.desafiar(ranking);
                            break;
                        case ResponderDesafios:
                            cliente.responderDesafios();
                            break;
                        case ConsultaCombates:
                            cliente.consultaCombates();
                            break;
                        case ConsultaRanking:
                            cliente.consultaRanking(ranking);
                            break;
                    }
                }
            }
        } 
        else {
            OperadorSistema op= (OperadorSistema) user;
            AccionOp accionOp;
            while (!end) { //bucle hasta que se elija DarseBaja o SalirSistema
                menu.pedirAccionOperador(accionOp);
                switch (accionOp) {
                    case DarseBaja:
                        op.darseBaja(ranking);
                        end=true;
                        break;
                    case SalirSistema:
                        end=true;
                        break;
                    case EditarPersonaje:
                        op.editarPersonaje(ranking, menu);
                        break;
                    case CompletarPersonaje:
                        op.completarPersonaje(ranking, menu);
                        break;
                    case ValidarDesafios:
                        op.validarDesafios(ranking,menu);
                        break;
                    case Banear:
                        op.banear(menu);
                        break;
                    case Desbanear:
                        op.desbanear(menu);
                        break;
                }
            }
        }    
    }
    
    public Ranking loadRanking() {
        try {
            FileInputStream archivo = new FileInputStream("ranking.ser");
            ObjectInputStream rankingEntrada = new ObjectInputStream(archivo);
            Ranking rank = (Ranking) rankingEntrada.readObject();
            rankingEntrada.close();
            archivo.close();
            return rank;
        }
        catch(IOException | ClassNotFoundException e) {
           //lo creamos pues no hay archivo
            return new Ranking();
        }
    }
    
    public void saveRanking() {
        try {
            FileOutputStream archivo = new FileOutputStream("ranking.ser");
            ObjectOutputStream rankingSalida = new ObjectOutputStream(archivo);
            rankingSalida.writeObject(ranking);
            rankingSalida.close();
            archivo.close();
        }
        catch (Exception ex) {
        System.out.println("Error clase App method saveRanking");}
    }
   
}
