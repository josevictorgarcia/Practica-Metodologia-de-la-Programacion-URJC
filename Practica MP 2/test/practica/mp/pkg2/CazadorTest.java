/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practica.mp.pkg2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author migue
 */
public class CazadorTest {
    
    public CazadorTest() {
    }

    @Test
    public void testGetPotencialAtaque() {
        System.out.println("getPotencialAtaque");
        Talento talento= new Talento("prueba", 1, 3);
        Cazador personaje1 = new Cazador("prueba", talento);
        personaje1.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        personaje1.anadirItem(arma);
        personaje1.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        personaje1.anadirItem(armadura);
        personaje1.setArmadura_activa(armadura);
        
        int expResult = 8;
        int result = personaje1.getPotencialAtaque();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPotencialDefensa() {
        System.out.println("getPotencialAtaque");
        Talento talento= new Talento("prueba", 1, 3);
        Cazador personaje1 = new Cazador("prueba", talento);
        personaje1.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        personaje1.anadirItem(arma);
        personaje1.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        personaje1.anadirItem(armadura);
        personaje1.setArmadura_activa(armadura);
        
        int expResult = 10;
        int result = personaje1.getPotencialDefensa();
        assertEquals(expResult, result);
    }

    @Test
    public void testPrepararCombate() {
        System.out.println("prepararCombate");
        Talento talento= new Talento("prueba", 1, 3);
        Cazador instance = new Cazador("prueba", talento);
        instance.prepararCombate();
        assertEquals(instance.getSalud(), 5);
        assertEquals(instance.getVoluntad(), 3);
        assertEquals(instance.getSalud_esbirros(), 0);
    }
    
}
