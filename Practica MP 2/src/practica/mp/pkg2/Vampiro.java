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
        this.sangre = 5;            //NOTA: Hay que inicializar el valor de la sangre a algun numero. No se puede quedar como constante 5
    }

    @Override
    public void setPotencialAtaque(){
        int potencial = this.sangre + super.getPoder();     //Aqui habria que anadir el valor de ataque de su disciplina, equipo etc.
        super.setPotencialAtaque(potencial);                //Tambien habria que anadir el correspondiente calculo del potencial de ataque en las clases que extienden (heredan) de personaje
    }

}
