/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package practica.mp.pkg2;

import java.util.List;
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
public class EquiposTest {
    
    public EquiposTest() {
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
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of anadirEquipo method, of class Equipos.
     */
    @org.junit.jupiter.api.Test
    public void testAnadirEquipo_0args() {
        System.out.println("anadirEquipo");
        Equipos instance = new Equipos();
        instance.anadirEquipo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of anadirEquipo method, of class Equipos.
     */
    @org.junit.jupiter.api.Test
    public void testAnadirEquipo_Equipo() {
        System.out.println("anadirEquipo");
        Equipo equipo = new Arma("arma", 1, 1, 0, 2);
        Equipos instance = new Equipos();
        instance.anadirEquipo(equipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarEquipo method, of class Equipos.
     */
    @org.junit.jupiter.api.Test
    public void testModificarEquipo() {
        System.out.println("modificarEquipo");
        Equipo equipo = new Arma("arma", 1, 1, 0, 2);
        Equipos instance = new Equipos();
        instance.anadirEquipo(equipo);
        instance.modificarEquipo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarEquipo method, of class Equipos.
     */
    @org.junit.jupiter.api.Test
    public void testEliminarEquipo() {
        System.out.println("eliminarEquipo");
        Equipo equipo = new Arma("arma", 1, 1, 0, 2);
        Equipos instance = new Equipos();
        instance.anadirEquipo(equipo);
        instance.eliminarEquipo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
