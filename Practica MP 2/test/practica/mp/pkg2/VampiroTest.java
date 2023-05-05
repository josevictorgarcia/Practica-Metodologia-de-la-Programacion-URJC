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
public class VampiroTest {
    
    public VampiroTest() {
    }

    @Test
    public void testGetPotencialAtaque() {
        System.out.println("getPotencialAtaque");
        Disciplina disciplina= new Disciplina("prueba", 1, 3, 2);
        Vampiro instance = new Vampiro("prueba", disciplina);
        int expResult = 6;
        int result = instance.getPotencialAtaque();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPotencialDefensa() {
        System.out.println("getPotencialDefensa");
        Disciplina disciplina= new Disciplina("prueba", 1, 3, 2);
        Vampiro instance = new Vampiro("prueba", disciplina);
        int expResult = 6;
        int result = instance.getPotencialDefensa();
        assertEquals(expResult, result);
    }

    @Test
    public void testPrepararCombate() {
        System.out.println("prepararCombate");
        Disciplina disciplina= new Disciplina("prueba", 1, 3, 2);
        Vampiro instance = new Vampiro("prueba", disciplina);
        instance.prepararCombate();
        assertEquals(instance.getSalud(), 5);
        assertEquals(instance.getSangre(), 0);
        assertEquals(instance.getSalud_esbirros(), 0);
    }
}
