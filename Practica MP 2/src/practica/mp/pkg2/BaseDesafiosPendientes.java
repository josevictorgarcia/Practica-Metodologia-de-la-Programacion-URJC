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

public class BaseDesafiosPendientes {
    private Map< List<Desafio> , String > desafiosUsuarios;
    
    public void load() {
        
    }
    
    public void save() {
        
    }
    
    public void añadirDesafio (Desafio des, String userName) {
        if (desafiosUsuarios.containsKey(userName)) {
            desafiosUsuarios.get(userName).add(des);
        }
        else {
            List<Desafio> list = new ArrayList<Desafio>();
            list.add(des);
            desafiosUsuarios.add(list, des);
        }
    }
    
    public void eliminarDesafio (String userName) {
        if (desafiosUsuarios.containsKey(userName)) {
            desafiosUsuarios.get(userName).remove(); //elimina el último desafio
        }
    }
    
    public List<Desafio> getDesafios (String userName){
        desafiosUsuarios.get(userName);
    }
    
    
}
