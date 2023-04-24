/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
public class Desafio {
    private String id_desafio;
    private Personaje desafiante;
    private Personaje desafiado;
    private Personaje vencedor;
    private int oro_apostado;
    private int oro_ganado;
    private boolean validado;
    
    public Desafio(String desafiante, String desafiado, int oro) {
        this.validado=false;
        this.desafiante= desafiante;
        this.desafiado=desafiado;
        this.oro_apostado=oro;
    }
    
    public void validar() {
        this.validado=true;
    }
    
}
