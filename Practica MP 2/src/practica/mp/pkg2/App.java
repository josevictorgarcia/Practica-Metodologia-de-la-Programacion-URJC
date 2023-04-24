
package practica.mp.pkg2;

import java.util.*;

/**
 *
 * @author Alex
 */


//Clase principal que inicia el programa.
//No se podia en MetProgUrjcGame porque se usa estático y no se podian invocar objetos
public class App {
    
    private BaseUsuarios baseUsers;
    private Ranking ranking;
    private Menu menu;
    private Usuario usuarioActivo;

    public App() {
        menu = new Menu();
    }
    
    //es el main pero sin ser estático
    public void run() throws InterruptedException {
        menu.inicio();
        //loadBase();
        //loadRanking();
        //while (!inicioSesion(menu, usuarioActivo)) {} //se queda en blucle hasta que el usuario se registre o se loguee
        //menu.inicio(usuarioActivo, baseUsers);
        //ranking.save();
        //baseUsers.save();
        
        
        
    }
    
    //carga los usuarios y contraseñas de memoria con un read
    private void loadBase() {
        baseUsers = new BaseUsuarios();
        baseUsers.load();
    }
    
    //pregunta si es registro o login, y añade o busca en la estructura
    private boolean inicioSesion(Menu menu, Usuario usuarioActivo) {
        String userName;
        String pass;
        if menu.askRegister() {
            menu.askRegisData(userName, pass);
            baseUsers.register(userName, pass);
            usuarioActivo = baseUsers.getUsuario(userName);
            return true;
        }
        else {
            menu.askLoginData(userName, pass);
            if (baseUsers.login(userName, pass)) {
                usuarioActivo= baseUsers.getUsuario(userName);
                return true;
            } 
            else {
                return false;
            }
        }
    }
    
    private void loadRanking() {
        ranking= new Ranking();
        ranking.load();
    }
}
