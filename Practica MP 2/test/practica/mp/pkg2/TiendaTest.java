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
public class TiendaTest {
    
    public TiendaTest() {
    }

    /**
     * Test of comprar method, of class Tienda.
     */
    @Test
    public void testComprar() {
        System.out.println("comprar");
        Personaje personaje = new Licantropo("lican", new Don ("don", 1,1,1));
        Equipos equipos = new Equipos();
        equipos.anadirEquipo(new Arma("arma2", 1, 0, 0 ,2));
        Tienda instance = new Tienda(equipos);
        instance.comprar(personaje);
        
        assertTrue(personaje.getOro()<50);
    }
    
}
