/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
import java.io.*;
public class Desafio implements Serializable{


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
        //this.id_desafio=generarID();
    }
    
    public void validar() {
        this.setValidado(true);
    }
    
    /*
    public void comenzarDesafio(){
        this.setCombate(new Combate(getDesafiante(), getDesafiado()));
        getCombate().desarrolloCombate();
    } 
    */
    
    public void aceptar(Menu menu) {
        prepararDesafiado(menu);
        this.setCombate(new Combate(this.getDesafiante(), this.getDesafiado()));
        this.getCombate().desarrolloCombate();
        this.setVencedor(this.getCombate().getGanador());
        if (this.getVencedor()==null) {
            menu.empate();}
        else{
            if (this.vencedor.getNombre().equals(this.desafiante.getNombre())) {
                this.desafiado.setOro(this.getDesafiado().getOro()-this.getOro_apostado());  //resta oro apostado a perdedor
                this.desafiante.setOro(this.getDesafiante().getOro()+this.getOro_apostado()); //suma oro apostado a ganador
                this.desafiante.setDesafios_ganados(this.desafiante.getDesafios_ganados()+1); //suma uno a desafios ganados
            }
            else {
                this.getDesafiante().setOro(this.getDesafiante().getOro()-this.getOro_apostado());  //resta oro apostado a perdedor
                this.getDesafiado().setOro(this.getDesafiado().getOro()+this.getOro_apostado()); //suma oro apostado a ganador
                this.desafiado.setDesafios_ganados(this.desafiado.getDesafios_ganados()+1);
            }
            menu.mostrarGanador(this.getVencedor());
        }
    }
    
    public void rechazar() {
        int oro_restante= (int) (this.desafiado.getOro()*0.9);
        this.desafiado.setOro(oro_restante);
    }
    
    private void prepararDesafiado(Menu menu) {
        Arma arma = menu.askArma(this.desafiado.getEquipo(), this.desafiado.getArmas_activas());
        this.desafiado.ponerArmaActiva(arma);
        Armadura armadura= menu.askArmadura(this.desafiado.getEquipo());
        this.desafiado.setArmadura_activa(armadura);
    }
    
    
    
        /**
     * @return the id_desafio
     */
    public String getId_desafio() {
        return id_desafio;
    }

    /**
     * @param id_desafio the id_desafio to set
     */
    public void setId_desafio(String id_desafio) {
        this.id_desafio = id_desafio;
    }

    /**
     * @return the desafiante
     */
    public Personaje getDesafiante() {
        return desafiante;
    }

    /**
     * @param desafiante the desafiante to set
     */
    public void setDesafiante(Personaje desafiante) {
        this.desafiante = desafiante;
    }

    /**
     * @return the desafiado
     */
    public Personaje getDesafiado() {
        return desafiado;
    }

    /**
     * @param desafiado the desafiado to set
     */
    public void setDesafiado(Personaje desafiado) {
        this.desafiado = desafiado;
    }

    /**
     * @return the vencedor
     */
    public Personaje getVencedor() {
        return vencedor;
    }

    /**
     * @param vencedor the vencedor to set
     */
    public void setVencedor(Personaje vencedor) {
        this.vencedor = vencedor;
    }

    /**
     * @return the oro_apostado
     */
    public int getOro_apostado() {
        return oro_apostado;
    }

    /**
     * @param oro_apostado the oro_apostado to set
     */
    public void setOro_apostado(int oro_apostado) {
        this.oro_apostado = oro_apostado;
    }

    /**
     * @return the oro_ganado
     */
    public int getOro_ganado() {
        return oro_ganado;
    }

    /**
     * @param oro_ganado the oro_ganado to set
     */
    public void setOro_ganado(int oro_ganado) {
        this.oro_ganado = oro_ganado;
    }

    /**
     * @return the validado
     */
    public boolean isValidado() {
        return validado;
    }

    /**
     * @param validado the validado to set
     */
    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    /**
     * @return the combate
     */
    public Combate getCombate() {
        return combate;
    }

    /**
     * @param combate the combate to set
     */
    public void setCombate(Combate combate) {
        this.combate = combate;
    }
    
}
