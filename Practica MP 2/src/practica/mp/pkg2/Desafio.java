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
    private Combate combate;
    
    public Desafio(Personaje desafiante, Personaje desafiado, int oro) {
        this.validado=false;
        this.desafiante= desafiante;
        this.desafiado= desafiado;
        this.oro_apostado= oro;
        this.id_desafio=generarID();
    }
    
    public void validar() {
        this.validado=true;
    }
    
    public void aceptar() {
        this.combate = new Combate(this.desafiante, this.desafiado);
        this.combate.desarrolloCombate();
        this.vencedor = this.combate.getGanador();
        if (this.vencedor==null) {
            menu.empate();}
        else{
            if (this.vencedor.getNombre() == this.desafiante.getNombre()) {
                this.desafiado.setOro(this.desafiado.getOro()-this.oro_apostado);  //resta oro apostado a perdedor
                this.desafiante.setOro(this.desafiante.getOro()+this.oro_apostado); //suma oro apostado a ganador
            }
            else {
                this.desafiante.setOro(this.desafiante.getOro()-this.oro_apostado);  //resta oro apostado a perdedor
                this.desafiado.setOro(this.desafiado.getOro()+this.oro_apostado); //suma oro apostado a ganador
            }
            menu.mostrarGanador(this.vencedor);
        }
    }
    
}
