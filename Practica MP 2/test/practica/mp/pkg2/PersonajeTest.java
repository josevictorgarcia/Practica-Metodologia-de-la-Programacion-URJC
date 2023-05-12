/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package practica.mp.pkg2;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Alex
 */
public class PersonajeTest {
    
    public PersonajeTest() {
    }

    /**
     * Test of anadirItem method, of class Personaje.
     */
    @Test
    public void testAnadirItem() {
        System.out.println("anadirItem");
        Equipo item = new Arma("arma", 1, 0, 0, 2);
        Personaje instance = new Licantropo("lican", new Don("don", 1,1,1));
        instance.anadirItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarOro method, of class Personaje.
     */
    @Test
    public void testModificarOro() {
        System.out.println("modificarOro");
        int cant = 0;
        Personaje instance = new Licantropo("lican", new Don("don", 1,1,1));
        instance.modificarOro(cant);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.getOro()==cant);
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerArmaActiva method, of class Personaje.
     */
    @Test
    public void testPonerArmaActiva() {
        System.out.println("ponerArmaActiva");
        Arma arma = new Arma("arma",1,0,1,2);
        Personaje instance = new Licantropo("lican", new Don("don", 1,1,1));
        instance.ponerArmaActiva(arma);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertTrue(instance.getArmas_activas().get(0).getNombre().equals(arma.getNombre())); //si el nombre del primer arma activa coincide con el del arma que acabamos de poner como activa
    }

    /**
     * Test of oroSuficiente method, of class Personaje.
     */
    @Test
    public void testOroSuficiente() {
        System.out.println("oroSuficiente");
        int oro = 5;
        Personaje instance = new Licantropo("lican", new Don("don", 1,1,1));
        boolean expResult = true;
        boolean result = instance.oroSuficiente(oro); //por defecto tiene 50 de oro
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of añadirModificador method, of class Personaje.
     */
    @Test
    public void testAñadirModificador() {
        System.out.println("a\u00f1adirModificador");
        int ataque =2;
        Modificador mod = new Modificador("mod", ataque, true);
        Personaje instance = new Licantropo("lican", new Don("don", 1,1,1));
        instance.añadirModificador(mod);
        
        assertTrue(instance.calcularModificadoresAtaque()== ataque); 
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of añadirEsbirro method, of class Personaje.
     */
    @Test
    public void testAñadirEsbirro() {
        System.out.println("a\u00f1adirEsbirro");
        Esbirro es = new Humano("humano", 1, Lealtad.ALTA);
        Personaje instance = new Licantropo("lican", new Don("don", 1,1,1));
        instance.añadirEsbirro(es);
        
        assertTrue(instance.getEsbirros().size() >0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularSaludEsbirros method, of class Personaje.
     */
    @Test
    public void testCalcularSaludEsbirros() {
        System.out.println("calcularSaludEsbirros");
        int salud=1;
        Esbirro es = new Humano("humano", salud, Lealtad.ALTA);
        Personaje instance = new Licantropo("lican", new Don("don", 1,1,1));
        instance.añadirEsbirro(es);
        instance.calcularSaludEsbirros();
        
        assertTrue(instance.getSalud_esbirros()==salud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularAtaqueEquipo method, of class Personaje.
     */
    @Test
    public void testCalcularAtaqueEquipo() {
        System.out.println("calcularAtaqueEquipo");
        Personaje instance = new Licantropo("lican", new Don("don", 1,1,1));
        int ataque=2;
        Arma arma = new Arma("arma", ataque, 0, 1, 2);
        instance.ponerArmaActiva(arma);
        int expResult = ataque;
        int result = instance.calcularAtaqueEquipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularModificadoresAtaque method, of class Personaje.
     */
    @Test
    public void testCalcularModificadoresAtaque() {
        System.out.println("calcularModificadoresAtaque");
        Personaje instance = new Licantropo("lican", new Don("don", 1,1,1));
        int ataque=2;
        instance.añadirModificador(new Modificador("mod", ataque, true));
        int expResult = ataque;
        int result = instance.calcularModificadoresAtaque();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalcularModificadoresDefensa() {
        System.out.println("calcularModificadoresDefensa");
        Personaje instance = new Licantropo("lican", new Don("don", 1,1,1));
        int defensa=2;
        instance.añadirModificador(new Modificador("mod", defensa, false));
        int expResult = defensa;
        int result = instance.calcularModificadoresDefensa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
   /* son metodos a los que se les hace override
    @org.junit.jupiter.api.Test
    public void testGetPotencialDefensa() {
        
    }
*/

    
    
}
