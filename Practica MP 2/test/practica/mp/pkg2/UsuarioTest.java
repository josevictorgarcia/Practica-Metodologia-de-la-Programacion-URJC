/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package practica.mp.pkg2;

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
public class UsuarioTest {
    
    public UsuarioTest() {
    }

    /**
     * Test of darseBaja method, of class Usuario.
     */
    @Test
    public void testDarseBaja() {
        System.out.println("darseBaja");
        Ranking ranking = new Ranking();
        Menu menu = new Menu();
        GeneradorIDs generador = new GeneradorIDs();
        Usuario instance = new Cliente("cliente", "cliente", "contra", menu, generador);
        instance.darseBaja(ranking);
        
        assertTrue(ranking.getUsuario("cliente")==null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
