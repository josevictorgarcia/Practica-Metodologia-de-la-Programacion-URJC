/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
public class OperadorSistema extends Usuario{
    
    public void editarPersonaje(Ranking rank) {
        Personaje per;
        per= menu.askPersonaje(rank);
        menu.askCambiarPersonaje(per);
    }
    
    public void completarPersonaje (Ranking rank ) {
        Personaje per;
        per= menu.askPersonaje(rank);
        String opcion = menu.askAñadir();
        switch (opcion) {
            case "armas":
                Arma arma = menu.askArmaNueva();
                per.añadirArma(arma);
                break;
            case "armaduras":
                Armadura armadura = menu.askArmaduraNueva();
                per.añadirArmadura(armadura);
                break;
            case "modificador":
                Modificador mod = menu.askModificadorNuevo();
                per.añadirModificador(mod);
                break;
            case "esbirros":
                Esbirro esbirro = menu.askEsbirroNuevo();
                per.añadirEsbirro(esbirro);
                break;
        }
    }
    
    public void validarDesafios () {
        
    }
    
    
}
