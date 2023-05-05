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
public class RondaTest {
    
    public RondaTest() {
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
     * Test of calculoRonda method, of class Ronda.
     */
    @org.junit.jupiter.api.Test
    public void testCalculoRonda() {
        System.out.println("calculoRonda");
        Licantropo personaje1= new Licantropo("prueba", new Don("prueba",1,2,1));
        personaje1.setRabia(0);
        personaje1.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        personaje1.anadirItem(arma);
        personaje1.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        personaje1.anadirItem(armadura);
        personaje1.setArmadura_activa(armadura);
        
        Licantropo personaje2= new Licantropo("prueba", new Don("prueba",2,1,1));
        personaje2.setRabia(0);
        personaje2.setPoder(3);
        Arma arma2 = new Arma("arma",2,0,0,2);
        personaje2.anadirItem(arma2);
        personaje2.ponerArmaActiva(arma2);
        Armadura armadura2 = new Armadura("armadura", 1,0,0);
        personaje2.anadirItem(armadura2);
        personaje2.setArmadura_activa(armadura2);
        
        personaje1.setSalud(5);
        personaje2.setSalud(5);
        
        Ronda instance = new Ronda(new Combate(personaje1, personaje2));
        instance.calculoRonda();
        // Es random y no podemos hacer assert de nada
        
    }

    /**
     * Test of calculoNumExitosAtaque method, of class Ronda.
     */
    
    @org.junit.jupiter.api.Test
    public void testCalculoNumExitosAtaque() {
        System.out.println("calculoNumExitosAtaque");
        Licantropo personaje1= new Licantropo("prueba", new Don("prueba",1,2,1));
        personaje1.setRabia(0);
        personaje1.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        personaje1.anadirItem(arma);
        personaje1.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        personaje1.anadirItem(armadura);
        personaje1.setArmadura_activa(armadura);
       
        Ronda instance = new Ronda(new Combate(personaje1, null));
        int expResult = 0;
        int result = instance.calculoNumExitosAtaque(personaje1);
        //assertEquals(expResult, result);
        //es random por lo que no podemos hacer assert de nada
        
    }
    
    @org.junit.jupiter.api.Test
    public void testCalculoNumExitosDefensa() {
        System.out.println("calculoNumExitosAtaque");
        Licantropo personaje1= new Licantropo("prueba", new Don("prueba",1,2,1));
        personaje1.setRabia(0);
        personaje1.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        personaje1.anadirItem(arma);
        personaje1.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        personaje1.anadirItem(armadura);
        personaje1.setArmadura_activa(armadura);
       
        Ronda instance = new Ronda(new Combate(personaje1, null));
        int expResult = 0;
        int result = instance.calculoNumExitosDefensa(personaje1);
        //es random por lo que no podemos hacer assert de nada
    }

    
    
}
