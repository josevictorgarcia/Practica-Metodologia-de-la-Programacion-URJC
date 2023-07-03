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
public class ClienteTest {
    
    public ClienteTest() {
    }

    /**
     * Test of cambiarPersonaje method, of class Cliente.
     */
    @Test
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
        assertTrue(!instance.getPersonaje().getNombre().equals("cliente"));
    }

    /**
     * Test of elegirEquipo method, of class Cliente.
     */
    @Test
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
        assertTrue((instance.getPersonaje().getArmadura_activa()!= null) | (instance.getPersonaje().getArmas_activas().size()>0));
    }

    /**
     * Test of desafiar method, of class Cliente.
     */
    @Test
    public void testDesafiar() {
        System.out.println("desafiar");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        Ranking ranking = new Ranking();
        ranking.añadirUsuario(instance);
        Cliente rival = new Cliente ("cliente2","cliente2", "contra",menu,generador);
        ranking.añadirUsuario(rival);
        instance.desafiar(ranking, generador);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(rival.getDesafiosPendientes().size()>0);
    }

    /**
     * Test of responderDesafios method, of class Cliente.
     */
    @Test
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
        
        Desafio des = new Desafio(cliente2.getPersonaje(), instance.getPersonaje(), 10, generador, cliente2);
        cliente2.enviarDesafio(des, instance);
        des.validar();
        instance.responderDesafios(ranking);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.getUltimosCombates().size()>0);
    }

    /**
     * Test of hayDesafios method, of class Cliente.
     */
    @Test
    public void testHayDesafios() {
        System.out.println("hayDesafios");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        boolean expResult = false;
        boolean result = instance.hayDesafios();
        assertEquals(expResult, result);
    }

    /**
     * Test of añadirCombate method, of class Cliente.
     */
    @Test
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
        assertTrue(instance.getUltimosCombates().size()>0);
    }

    /**
     * Test of consultaCombates method, of class Cliente.
     */
    @Test
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
        assertTrue(instance.getUltimosCombates().size()>0);
    }

    /**
     * Test of consultaRanking method, of class Cliente.
     */
    @Test
    public void testConsultaRanking() {
        System.out.println("consultaRanking");
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente instance = new Cliente("cliente", "cliente","contra", menu, generador);
        Ranking rank = new Ranking();
        rank.añadirUsuario(instance);
        instance.consultaRanking(rank);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of enviarDesafio method, of class Cliente.
     */
    @Test
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
        cliente2.setPersonaje(personaje2);
        
        
        Ranking ranking = new Ranking();
        ranking.añadirUsuario(instance);
        ranking.añadirUsuario(cliente2);
        
        Desafio des = new Desafio(instance.getPersonaje(), cliente2.getPersonaje(), 10, generador, instance);
        instance.enviarDesafio(des, cliente2);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(cliente2.getDesafiosPendientes().size()>0);
    }

    /**
     * Test of comprarItem method, of class Cliente.
     */
    @Test
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
        assertTrue(instance.getPersonaje().getOro()<50);
    }

    
}
