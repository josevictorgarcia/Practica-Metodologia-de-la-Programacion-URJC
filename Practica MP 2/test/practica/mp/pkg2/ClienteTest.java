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
public class ClienteTest {
    
    public ClienteTest() {
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
     * Test of cambiarPersonaje method, of class Cliente.
     */
    @org.junit.jupiter.api.Test
    public void testCambiarPersonaje() throws Exception {
        System.out.println("cambiarPersonaje");
        Habilidades habilidades = new Habilidades();
        habilidades.añadirHabilidad(new Don("don", 1,1,1));
        habilidades.añadirHabilidad(new Talento("tal",1,1));
        habilidades.añadirHabilidad(new Disciplina ("dis", 1,1,1));
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        instance.cambiarPersonaje(habilidades);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elegirEquipo method, of class Cliente.
     */
    @org.junit.jupiter.api.Test
    public void testElegirEquipo() {
        System.out.println("elegirEquipo");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        Habilidades habilidades = new Habilidades();
        habilidades.añadirHabilidad(new Don("don", 1,1,1));
        habilidades.añadirHabilidad(new Talento("tal",1,1));
        habilidades.añadirHabilidad(new Disciplina ("dis", 1,1,1));
        instance.cambiarPersonaje(habilidades);
        Arma arma= new Arma ("arma",1,0,0,2);
        Armadura armadura = new Armadura("armadura",1,0,1);
        instance.getPersonaje().anadirItem(arma);
        instance.getPersonaje().anadirItem(armadura);
        instance.getPersonaje().ponerArmaActiva(arma);
        instance.getPersonaje().setArmadura_activa(armadura);
        instance.elegirEquipo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of desafiar method, of class Cliente.
     */
    @org.junit.jupiter.api.Test
    public void testDesafiar() {
        System.out.println("desafiar");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        Ranking ranking = new Ranking();
        ranking.añadirUsuario(instance);
        ranking.añadirUsuario(new Cliente ("cliente2","cliente2", "contra",menu,generador));
        instance.desafiar(ranking, generador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of responderDesafios method, of class Cliente.
     */
    @org.junit.jupiter.api.Test
    public void testResponderDesafios() {
        System.out.println("responderDesafios");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        Cliente cliente2= new Cliente ("cliente2","cliente2", "contra",menu,generador);
        //crear personajes:
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
        
        instance.setPersonaje(personaje1);
        instance.setPersonaje(personaje2);
        
        
        Ranking ranking = new Ranking();
        ranking.añadirUsuario(instance);
        ranking.añadirUsuario(cliente2);
        
        Desafio des = new Desafio(cliente2.getPersonaje(), instance.getPersonaje(), 2, generador, cliente2);
        cliente2.enviarDesafio(des, instance);
        des.validar();
        instance.responderDesafios(ranking);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hayDesafios method, of class Cliente.
     */
    @org.junit.jupiter.api.Test
    public void testHayDesafios() {
        System.out.println("hayDesafios");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        boolean expResult = false;
        boolean result = instance.hayDesafios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of añadirCombate method, of class Cliente.
     */
    @org.junit.jupiter.api.Test
    public void testAñadirCombate() {
        System.out.println("a\u00f1adirCombate");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        Licantropo personaje1= new Licantropo("prueba", new Don("prueba",3,1,1));
        Licantropo personaje2= new Licantropo("prueba", new Don("prueba",2,1,1));
        Combate comb = new Combate(personaje1, personaje2);
        instance.añadirCombate(comb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultaCombates method, of class Cliente.
     */
    @org.junit.jupiter.api.Test
    public void testConsultaCombates() {
        System.out.println("consultaCombates");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        Licantropo personaje1= new Licantropo("prueba", new Don("prueba",3,1,1));
        Licantropo personaje2= new Licantropo("prueba", new Don("prueba",2,1,1));
        Combate comb = new Combate(personaje1, personaje2);
        instance.añadirCombate(comb);
        instance.consultaCombates();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultaRanking method, of class Cliente.
     */
    @org.junit.jupiter.api.Test
    public void testConsultaRanking() {
        System.out.println("consultaRanking");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        Ranking rank = new Ranking();
        rank.añadirUsuario(instance);
        instance.consultaRanking(rank);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enviarDesafio method, of class Cliente.
     */
    @org.junit.jupiter.api.Test
    public void testEnviarDesafio() {
        System.out.println("enviarDesafio");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        Cliente cliente2= new Cliente ("cliente2","cliente2", "contra",menu,generador);
        //crear personajes:
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
        
        instance.setPersonaje(personaje1);
        instance.setPersonaje(personaje2);
        
        
        Ranking ranking = new Ranking();
        ranking.añadirUsuario(instance);
        ranking.añadirUsuario(cliente2);
        
        Desafio des = new Desafio(instance.getPersonaje(), cliente2.getPersonaje(), 2, generador, instance);
        instance.enviarDesafio(des, cliente2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprarItem method, of class Cliente.
     */
    @org.junit.jupiter.api.Test
    public void testComprarItem() {
        System.out.println("comprarItem");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        
        Licantropo personaje1= new Licantropo("prueba", new Don("prueba",1,2,1));
        personaje1.setRabia(0);
        personaje1.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        personaje1.anadirItem(arma);
        personaje1.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        personaje1.anadirItem(armadura);
        personaje1.setArmadura_activa(armadura);
        
        instance.setPersonaje(personaje1);
        
        Equipos equipos = new Equipos();
        Arma arma2 = new Arma("arma2",1,0,1,2);
        equipos.anadirEquipo(arma2);
        Tienda tienda= new Tienda(equipos);
        instance.comprarItem(tienda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
