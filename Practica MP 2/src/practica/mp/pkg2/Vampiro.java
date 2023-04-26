/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
public class Vampiro extends Personaje {

    private int sangre;

    public Vampiro(String nombre, int poder, Disciplina disciplina){
        super(nombre, poder, disciplina);
        this.sangre = 0;
    }

    /*
    @Override
    public void setPotencialAtaque(){
        int potencial = this.getSangre() + super.getPoder();     //Aqui habria que anadir el valor de ataque de su disciplina, equipo etc.
        super.setPotencialAtaque(potencial);                //Tambien habria que anadir el correspondiente calculo del potencial de ataque en las clases que extienden (heredan) de personaje
    }
    */
    
    public int getPotencialAtaque() {
        Disciplina disciplina = (Disciplina) this.getHabilidad_especial();
        int potencial=  this.getPoder() + disciplina.getAtaque() + this.calcularAtaqueEquipo() + 
    }
    
    
    
    /**
     * @return the sangre
     */
    public int getSangre() {
        return sangre;
    }

    /**
     * @param sangre the sangre to set
     */
    public void setSangre(int sangre) {
        this.sangre = sangre;
    }

}
