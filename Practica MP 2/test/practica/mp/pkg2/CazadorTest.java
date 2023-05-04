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
        Cazador instance = new Cazador("prueba", talento);
        int expResult = 9;
        int result = instance.getPotencialAtaque();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPotencialDefensa() {
        System.out.println("getPotencialDefensa");
        Talento talento= new Talento("prueba", 1, 3);
        Cazador instance = new Cazador("prueba", talento);
        int expResult = 11;
        int result = instance.getPotencialDefensa();
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

    @Test
    public void testGetVoluntad() {
        System.out.println("getVoluntad");
        Talento talento= new Talento("prueba", 1, 3);
        Cazador instance = new Cazador("prueba", talento);
        int expResult = 3;
        int result = instance.getVoluntad();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetVoluntad() {
        System.out.println("setVoluntad");
        int voluntad = 2;
        Talento talento= new Talento("prueba", 1, 3);
        Cazador instance = new Cazador("prueba", talento);
        instance.setVoluntad(voluntad);
        assertEquals(instance.getVoluntad(), 2);
    }
    
}
