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

public class BaseCombates {
    private Map <List<Combate>, String> combates;
    
    public void load() {
        
    }
    public void save() {
        
    }
    public void añadirCombate (Combate comb, String userName) {
        if (combates.containsKey(userName)) {
            List<Combate> list = combates.get(userName)
            if (list.size()>=10) {
                list.remove(); //elimina el mas antiguo
            }
            list.add(comb);
        }
        else {
            ArrayList<Combate> list2 = new ArrayList<Combate>();
            list2.add(comb);
            combates.add(list2, userName);
        }
    }
    public List<Combate> getCombates (String userName) {
        return combates.get(userName);
    }
}
