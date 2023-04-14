/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
import java.util.*;
public class BaseUsuarios {
    private Map <Usuario, String> usuarios;
    private Map<String, String> contras;
    
    public void load () {
        
    }
    
    public boolean login (String userName, String pass) {
        if (contras.containsValue(userName)) {
            return (contras.get(userName) == pass);
        }
        else {
            return false;
        }
    }
    
    public Usuario getUsuario (String userName) {
        if (usuarios.containsKey(userName)) {
            return usuarios.get(userName);
        }
    }
    
    public void register (String userName, String pass) {
        contras.add(userName, pass);
        Usuario user = new Usuario(userName, pass);
        usuario.add(user, userName);
    }
    
    public void eliminar (String userName) {
        usuarios.remove(userName);
    }
            
    
}
