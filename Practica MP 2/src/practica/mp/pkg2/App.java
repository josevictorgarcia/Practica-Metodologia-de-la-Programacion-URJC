
package practica.mp.pkg2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    private Tienda tienda;
    private Equipos equipos;
    private GeneradorIDs generador;
    private Habilidades habilidades;

    public App() {
        ranking = loadRanking();
        //ranking = new Ranking();
        //ranking.loadRanking();
        equipos = loadEquipos();
        //equipos = new Equipos();
        //equipos.loadEquipos();                
        generador = loadGenerador();
        this.menu = new Menu();
        tienda = new Tienda(equipos);
        habilidades= loadHabilidades();
        //System.out.println("habil: "+habilidades.getHabilidades().size());
    }
    
    //es el main pero sin ser estático
    public void run() throws InterruptedException, FileNotFoundException {
        Usuario user = null;
        while (user==null || user.isBaneado()){
            user = menu.inicio(ranking, generador, habilidades);
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
            while (!end) {  //bucle hata que se elija DarseBaja o SalirSistema
                if (cliente.hayDesafios()) { //comprueba si hay desafios validados que deba responder inmediatamente
                    cliente.responderDesafios(ranking);
                }
                else {
                    AccionCliente accionCliente= menu.pedirAccionCliente(); //pide al usuario que elija una accion
                    switch (accionCliente) {
                        case DarseBaja:
                            cliente.darseBaja(ranking);
                            end=true;
                            break;
                        case SalirSistema:
                            end=true;
                            break;
                        case CambiarPersonaje:
                            cliente.cambiarPersonaje(habilidades);
                            break;
                        case ElegirEquipo:
                            cliente.elegirEquipo();
                            break;
                        case Desafiar:
                            cliente.desafiar(ranking, generador);
                            break;
                        case ResponderDesafios:
                            cliente.responderDesafios(ranking);
                            break;
                        case ConsultaCombates:
                            cliente.consultaCombates();
                            break;
                        case ConsultaRanking:
                            cliente.consultaRanking(ranking);
                            break;
                        case ComprarItem:
                            cliente.comprarItem(tienda);
                            break;
                    }
                }
            }
        } 
        else {
            OperadorSistema op= (OperadorSistema) user;
            while (!end) { //bucle hasta que se elija DarseBaja o SalirSistema
                AccionOp accionOp=menu.pedirAccionOperador();
                switch (accionOp) {
                    case DarseBaja:
                        op.darseBaja(ranking);
                        end=true;
                        break;
                    case SalirSistema:
                        end=true;
                        break;
                    case EditarPersonaje:
                        op.editarPersonaje(ranking);
                        break;
                    case CompletarPersonaje:
                        op.completarPersonaje(ranking, equipos);
                        break;
                    case ValidarDesafios:
                        op.validarDesafios(ranking);
                        break;
                    case Banear:
                        op.banear(ranking);
                        break;
                    case Desbanear:
                        op.desbanear(ranking);
                        break;
                    case AñadirItemTienda:
                        op.añadirItemTienda(equipos);
                        break;
                    case AnadirHabilidad:
                        op.añadirHabilidad(habilidades);
                        break;
                }
            }
        }
        saveRanking();
        saveEquipos();
        saveGenerador();
        saveHabilidades();
    }
    
    public Ranking loadRanking() {
        try {
            FileInputStream archivo = new FileInputStream("ranking.ser");
            ObjectInputStream rankingEntrada = new ObjectInputStream(archivo);
            Ranking rank = (Ranking) rankingEntrada.readObject();
            rankingEntrada.close();
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
            rankingSalida.writeObject(this.ranking);
            rankingSalida.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error clase App method saveRanking");
        }
    }
    
    public Equipos loadEquipos() {
        try {
            FileInputStream archivo = new FileInputStream("equipos.ser");
            ObjectInputStream rankingEntrada = new ObjectInputStream(archivo);
            Equipos equip = (Equipos) rankingEntrada.readObject();
            rankingEntrada.close();
            return equip;
        }
        catch(IOException | ClassNotFoundException e) {
           //lo creamos pues no hay archivo
            return new Equipos();
        }
    }
    
    public void saveEquipos() {
        try {
            FileOutputStream archivo = new FileOutputStream("equipos.ser");
            ObjectOutputStream rankingSalida = new ObjectOutputStream(archivo);
            rankingSalida.writeObject(equipos);
            rankingSalida.close();
        }
        catch (Exception ex) {
        System.out.println("Error clase App method saveEquipos");}
    }
    
    public GeneradorIDs loadGenerador() {
        try {
            FileInputStream archivo = new FileInputStream("generador.ser");
            ObjectInputStream rankingEntrada = new ObjectInputStream(archivo);
            GeneradorIDs generador = (GeneradorIDs) rankingEntrada.readObject();
            rankingEntrada.close();
            return generador;
        }
        catch(IOException | ClassNotFoundException e) {
           //lo creamos pues no hay archivo
            return new GeneradorIDs();
        }
    }
    
    public void saveGenerador() {
        try {
            FileOutputStream archivo = new FileOutputStream("generador.ser");
            ObjectOutputStream rankingSalida = new ObjectOutputStream(archivo);
            rankingSalida.writeObject(generador);
            rankingSalida.close();
        }
        catch (Exception ex) {
        System.out.println("Error clase App method saveGenerador");}
    }

    public Habilidades loadHabilidades(){
        try {
            FileInputStream archivo = new FileInputStream("Habilidades.ser");
            ObjectInputStream habilidadesEntrada = new ObjectInputStream(archivo);
            Habilidades habilidades = (Habilidades) habilidadesEntrada.readObject();
            habilidadesEntrada.close();
            return habilidades;
        }
        catch(IOException | ClassNotFoundException e) {
           //lo creamos pues no hay archivo
            Habilidades habilidades = new Habilidades();
            habilidades.añadirHabilidad(new Disciplina("por defecto",1,1,1));
            habilidades.añadirHabilidad(new Don("por defecto",1,1,1));
            habilidades.añadirHabilidad(new Talento("por defecto",1,1));
            return habilidades;
        }
    }
    
    public void saveHabilidades() {
        try {
            FileOutputStream archivo = new FileOutputStream("Habilidades.ser");
            ObjectOutputStream rankingSalida = new ObjectOutputStream(archivo);
            rankingSalida.writeObject(habilidades);
            rankingSalida.close();
        }
        catch (Exception ex) {
        System.out.println("Error clase App method saveHabilidades");}
    }
   
}
