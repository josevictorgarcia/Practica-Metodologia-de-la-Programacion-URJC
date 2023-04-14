/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

import java.util.*;

/**
 *
 * @author Alex
 */
public class App {
    
    private BaseUsuarios baseUsers;
    private Ranking ranking;
    private Menu menu;
    private Usuario usuarioActivo;
    
    //es el main pero sin ser estático
    public void run() {
        loadBase();
        loadRanking();
        while (!inicioSesion(menu, usuarioActivo)) {} //se queda en blucle hasta que el usuario se registre o se loguee
        menu.inicio(usuarioActivo);
        ranking.save();
        baseUsers.save();
        
        
        
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
            if baseUsers.login(userName, pass) {
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
