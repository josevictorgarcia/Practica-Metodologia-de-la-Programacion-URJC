/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
public class Humano extends Esbirro{
    private Lealtad lealtad;
    
    public Humano (String nombre, int salud, Lealtad lealtad) {
        super(nombre, salud);
        this.lealtad=lealtad;
    }
}
