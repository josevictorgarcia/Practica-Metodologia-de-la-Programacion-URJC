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
public class DesafioTest {
    
    public DesafioTest() {
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
     * Test of validar method, of class Desafio.
     */
    @org.junit.jupiter.api.Test
    public void testValidar() {
        System.out.println("validar");
        //personajes
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
        
        
        GeneradorIDs generador = new GeneradorIDs();
        Menu menu = new Menu();
        Cliente cliente = new Cliente("cliente", "cliente", "contra", menu , generador);
        cliente.setPersonaje(personaje1);
        
        Desafio instance = new Desafio(personaje1, personaje2, 2, generador, cliente);
        instance.validar();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.isValidado());
        fail("The test case is a prototype.");
    }

    /**
     * Test of aceptar method, of class Desafio.
     */
    @org.junit.jupiter.api.Test
    public void testAceptar() {
        System.out.println("aceptar");
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
        
        
        GeneradorIDs generador = new GeneradorIDs();
        Menu menu = new Menu();
        Cliente cliente = new Cliente("cliente", "cliente", "contra", menu , generador);
        cliente.setPersonaje(personaje1);
        
        Desafio instance = new Desafio(personaje1, personaje2, 2, generador, cliente);
        
        instance.aceptar(menu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechazar method, of class Desafio.
     */
    @org.junit.jupiter.api.Test
    public void testRechazar() {
        System.out.println("rechazar");
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
        
        
        GeneradorIDs generador = new GeneradorIDs();
        Menu menu = new Menu();
        Cliente cliente = new Cliente("cliente", "cliente", "contra", menu , generador);
        cliente.setPersonaje(personaje1);
        
        Desafio instance = new Desafio(personaje1, personaje2, 2, generador, cliente);
        instance.rechazar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}