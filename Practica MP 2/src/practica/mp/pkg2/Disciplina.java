/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
public class Disciplina extends Habilidad{
    private int coste;
    
    public Disciplina (String nombre, int ataque, int defensa, int coste) {
        super(nombre, ataque, defensa);
        this.coste=coste;
    }
}
