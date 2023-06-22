/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
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
 * @author migue
 */
public class OperadorSistemaTest {
    
    public OperadorSistemaTest() {
    }

    @Test
    public void testEditarPersonaje() {
        System.out.println("editarPersonaje");
        App app = new App();
        Ranking rank = new Ranking();
        
        //crear cliente
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente cliente = new Cliente("cliente", "cliente","contra", menu, generador);
        
        Licantropo personaje1= new Licantropo("prueba", new Don("prueba",1,2,1));
        personaje1.setRabia(0);
        personaje1.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        personaje1.anadirItem(arma);
        personaje1.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        personaje1.anadirItem(armadura);
        personaje1.setArmadura_activa(armadura);
        
        cliente.setPersonaje(personaje1);
        
        rank.añadirUsuario(cliente);
        
        OperadorSistema instance = new OperadorSistema("prueba", "prueba", "prueba", new Menu());
        instance.editarPersonaje(rank);
        
        assertTrue(! cliente.getPersonaje().getNombre().equals("cliente"));
    }

    @Test
    public void testCompletarPersonaje() {
        System.out.println("completarPersonaje");
        App app = new App();
        Ranking rank = new Ranking();
        
        //crear cliente
        Menu menu = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        Cliente cliente = new Cliente("cliente", "cliente","contra", menu, generador);
        
        Licantropo personaje1= new Licantropo("prueba", new Don("prueba",1,2,1));
        personaje1.setRabia(0);
        personaje1.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        personaje1.anadirItem(arma);
        personaje1.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        personaje1.anadirItem(armadura);
        personaje1.setArmadura_activa(armadura);
        
        cliente.setPersonaje(personaje1);
        
        rank.añadirUsuario(cliente);
        
        
        Equipos equipos = new Equipos();
        equipos.anadirEquipo(new Arma("arma2",1,0,1,2));
        OperadorSistema instance = new OperadorSistema("op", "op", "contra", menu);
        instance.completarPersonaje(rank, equipos);
        
        assertTrue(cliente.getPersonaje().getEquipo().size()>2);
    }

    @Test
    public void testValidarDesafios() {
        System.out.println("validarDesafios");
        
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
        
        
        OperadorSistema op = new OperadorSistema("op", "op", "contra", menu);
        op.validarDesafios(ranking);
        
        assertTrue(des.isValidado());
    }

    @Test
    public void testBanear() {
        System.out.println("banear");
        Ranking ranking = new Ranking();
        Menu menu = new Menu();
        GeneradorIDs generador = new GeneradorIDs();
        Cliente cliente = new Cliente("cliente", "cliente", "contra", menu, generador);
        ranking.añadirUsuario(cliente);
        OperadorSistema instance = new OperadorSistema("op", "op", "contra", menu);
        instance.banear(ranking);
        assertTrue(cliente.isBaneado());
    }

    @Test
    public void testDesbanear() {
        System.out.println("desbanear");
        Ranking ranking = new Ranking();
        Menu menu = new Menu();
        GeneradorIDs generador = new GeneradorIDs();
        Cliente cliente = new Cliente("cliente", "cliente", "contra", menu, generador);
        cliente.setBaneado(true);
        ranking.añadirUsuario(cliente);
        OperadorSistema instance = new OperadorSistema("op", "op", "contra", menu);
        instance.desbanear(ranking);
        assertTrue(! cliente.isBaneado());
    }

    @Test
    public void testAñadirItemTienda() {
        System.out.println("a\u00f1adirItemTienda");
        Equipos equipos = new Equipos();
        Menu menu = new Menu();
        OperadorSistema instance = new OperadorSistema("op", "op", "contra", menu);
        instance.añadirItemTienda(equipos);
        
        assertTrue(equipos.getEquipos().size()>0);
    }

    @Test
    public void testAñadirHabilidad() throws Exception {
        System.out.println("a\u00f1adirHabilidad");
        Habilidades habilidades = new Habilidades();
        Menu menu = new Menu();
        OperadorSistema instance = new OperadorSistema("op", "op", "contra", menu);
        instance.añadirHabilidad(habilidades);
        
        assertTrue(habilidades.getHabilidades().size()>0);
    }
    
}
