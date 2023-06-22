/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package practica.mp.pkg2;

import java.util.Date;
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
public class CombateTest {
    
    public CombateTest() {
    }

    /**
     * Test of nuevaRonda method, of class Combate.
     */
    @Test
    public void testNuevaRonda() {
        System.out.println("nuevaRonda");
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
        
        
        Combate instance = new Combate(personaje1, personaje2);
        instance.nuevaRonda();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.getRondas().size()>0);
    }

    /**
     * Test of desarrolloCombate method, of class Combate.
     */
    @Test
    public void testDesarrolloCombate() {
        System.out.println("desarrolloCombate");
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
        
        
        Combate instance = new Combate(personaje1, personaje2);
        instance.desarrolloCombate();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue((personaje1.getSalud()==0) | (personaje2.getSalud()==0));
    }

    
}
