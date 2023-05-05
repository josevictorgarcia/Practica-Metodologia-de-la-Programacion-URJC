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
    
    @Test
    public void testCasoPrueba2() { //intenta logear Hacker peron no está registrado
        System.out.println("a\u00f1adirUsuario");
        Ranking instance = new Ranking();
        Usuario buscado = instance.getUsuario("Hacker");
        assertTrue(buscado==null);
    }
    
    @Test
    public void testCasoPrueba3() { //intenta logear Hacker pero constraseña no es correcta
        System.out.println("a\u00f1adirUsuario");
        Ranking instance = new Ranking();
        Usuario hacker = new Usuario("Hacker", "Hacker", "contra");
        instance.añadirUsuario(hacker);
        Usuario buscado = instance.getUsuario("Hacker");
        String intentoContra= "contra incorrecta";
        assertTrue(! intentoContra.equals(buscado.getContrasena()));
    }
    
    @Test
    public void testCasoPrueba4() { //intenta logear Hacker pero está baneado
        System.out.println("a\u00f1adirUsuario");
        Usuario user = new Usuario("Hacker","Hacker", "contra");
        user.setBaneado(true);
        Ranking instance = new Ranking();
        instance.añadirUsuario(user);
        Usuario buscado= instance.getUsuario("Hacker");
        String contra = "contra";
        assertTrue(buscado.isBaneado() && contra.equals(buscado.getContrasena()));
    }
    
    @Test
    public void testCasoPrueba5() { //intenta logear Hacker que está desbaneado
        System.out.println("a\u00f1adirUsuario");
        Usuario user = new Usuario("Hacker","Hacker", "contra");
        user.setBaneado(false);
        Ranking instance = new Ranking();
        instance.añadirUsuario(user);
        Usuario buscado= instance.getUsuario("Hacker");
        String contra = "contra";
        assertTrue((!buscado.isBaneado()) && contra.equals(buscado.getContrasena()));
    }
    
    
  
    @Test
    public void testAñadirUsuario() {
        System.out.println("a\u00f1adirUsuario");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Usuario user = new Cliente("cliente", "cliente", "contra", menu, generador);
        Ranking instance = new Ranking();
        instance.añadirUsuario(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testActualizarRanking() {
        System.out.println("actualizarRanking");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente user = new Cliente("cliente", "cliente", "contra", menu, generador);
        Personaje per = new Licantropo("lican", new Don("don", 1,1,1));
        user.setPersonaje(per);
        Ranking instance = new Ranking();
        instance.añadirUsuario(user);
        instance.actualizarRanking();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testMostrarRanking() {
        System.out.println("mostrarRanking");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Usuario user = new Cliente("cliente", "cliente", "contra", menu, generador);
        Ranking instance = new Ranking();
        instance.añadirUsuario(user);
        instance.mostrarRanking();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Usuario user = new Cliente("cliente", "cliente", "contra", menu, generador);
        Ranking instance = new Ranking();
        instance.añadirUsuario(user);
        Usuario result = instance.getUsuario("cliente");
        assertTrue(result!=null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testEliminarUsuario() {
        System.out.println("eliminarUsuario");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Usuario user = new Cliente("cliente", "cliente", "contra", menu, generador);
        Ranking instance = new Ranking();
        instance.añadirUsuario(user);
        instance.eliminarUsuario("cliente");
        
        assertTrue(instance.getUsuario("cliente")==null);
    }
    
}
