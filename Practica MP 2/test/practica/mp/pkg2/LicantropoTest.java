/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package practica.mp.pkg2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alex
 */
public class LicantropoTest {
    
    public LicantropoTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    /**
     * Test of getPotencialAtaque method, of class Licantropo.
     */
    @org.junit.jupiter.api.Test
    public void testGetPotencialAtaque() {
        System.out.println("getPotencialAtaque");
        Licantropo instance = new Licantropo("prueba", new Don("prueba",1,2,1));
        instance.setRabia(0);
        instance.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        instance.anadirItem(arma);
        instance.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        instance.anadirItem(armadura);
        instance.setArmadura_activa(armadura);
        int expResult = 4;
        int result = instance.getPotencialAtaque();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPotencialDefensa method, of class Licantropo.
     */
    @org.junit.jupiter.api.Test
    public void testGetPotencialDefensa() {
        System.out.println("getPotencialAtaque");
        Licantropo instance = new Licantropo("prueba", new Don("prueba",1,2,1));
        instance.setRabia(0);
        instance.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        instance.anadirItem(arma);
        instance.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        instance.anadirItem(armadura);
        instance.setArmadura_activa(armadura);
        int expResult = 4;
        int result = instance.getPotencialDefensa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
    @org.junit.jupiter.api.Test
    public void testPrepararCombate() {
        System.out.println("prepararCombate");
        Licantropo instance = new Licantropo("licant", new Don("don",1,1,1));
        instance.prepararCombate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
}
