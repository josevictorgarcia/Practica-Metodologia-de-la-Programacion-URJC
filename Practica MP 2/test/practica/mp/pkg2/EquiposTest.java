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
public class EquiposTest {
    
    public EquiposTest() {
    }
    /**
     * Test of anadirEquipo method, of class Equipos.
     */
    @Test
    public void testAnadirEquipo_0args() {
        System.out.println("anadirEquipo");
        Equipos instance = new Equipos();
        instance.anadirEquipo();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.getEquipos().size()>0);
    }

    /**
     * Test of anadirEquipo method, of class Equipos.
     */
    @Test
    public void testAnadirEquipo_Equipo() {
        System.out.println("anadirEquipo");
        Equipo equipo = new Arma("arma", 1, 1, 0, 2);
        Equipos instance = new Equipos();
        instance.anadirEquipo(equipo);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.getEquipos().size()>0);
    }

    /**
     * Test of modificarEquipo method, of class Equipos.
     */
    @Test
    public void testModificarEquipo() {
        System.out.println("modificarEquipo");
        Equipo equipo = new Arma("arma", 1, 1, 0, 2);
        Equipos instance = new Equipos();
        instance.anadirEquipo(equipo);
        instance.modificarEquipo();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue((equipo.getAtaque()!=1)|(equipo.getDefensa()!=1)|(equipo.getCoste()!=2));
    }

    /**
     * Test of eliminarEquipo method, of class Equipos.
     */
    @Test
    public void testEliminarEquipo() {
        System.out.println("eliminarEquipo");
        Equipo equipo = new Arma("arma", 1, 1, 0, 2);
        Equipos instance = new Equipos();
        instance.anadirEquipo(equipo);
        instance.eliminarEquipo();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.getEquipos().size()==0);
    }
    
}
