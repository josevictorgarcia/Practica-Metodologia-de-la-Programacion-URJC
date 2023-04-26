/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
public class Cazador extends Personaje{
    private int voluntad;
    
    public Cazador (String nombre, int poder, Talento talento) {
        super(nombre, poder, talento);
        this.voluntad=3;
    }
}
