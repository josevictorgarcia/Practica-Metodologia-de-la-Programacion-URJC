/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practica.mp.pkg2;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex
 */
public class RankingTest {
    
    public RankingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCasoPrueba1() { //intenta registrar Hacker pero nombre ya está cogido
        System.out.println("a\u00f1adirUsuario");
        Usuario user = new Usuario("Hacker","Hacker", "contra");
        Ranking instance = new Ranking();
        instance.añadirUsuario(user);
        Usuario buscado= instance.getUsuario("Hacker");
        assertTrue(buscado!=null);
    }
    
    /*

    @Test
    public void testAñadirUsuario() {
        System.out.println("a\u00f1adirUsuario");
        Usuario user = null;
        Ranking instance = new Ranking();
        instance.añadirUsuario(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testActualizarRanking() {
        System.out.println("actualizarRanking");
        Ranking instance = new Ranking();
        instance.actualizarRanking();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testMostrarRanking() {
        System.out.println("mostrarRanking");
        Ranking instance = new Ranking();
        instance.mostrarRanking();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        String nickname = "";
        Ranking instance = new Ranking();
        Usuario expResult = null;
        Usuario result = instance.getUsuario(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testEliminarUsuario() {
        System.out.println("eliminarUsuario");
        String nombreUsuario = "";
        Ranking instance = new Ranking();
        instance.eliminarUsuario(nombreUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

  
    @Test
    public void testGetRanking() {
        System.out.println("getRanking");
        Ranking instance = new Ranking();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.getRanking();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @Test
    public void testSetRanking() {
        System.out.println("setRanking");
        List<Usuario> ranking = null;
        Ranking instance = new Ranking();
        instance.setRanking(ranking);
       // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
    */
    
}
