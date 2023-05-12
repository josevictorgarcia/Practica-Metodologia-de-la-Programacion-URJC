/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practica.mp.pkg2;

import java.util.ArrayList;
import java.util.List;
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
public class HabilidadesTest {
    
    public HabilidadesTest() {
    }

    @Test
    public void testImprimirInfo() {
        System.out.println("imprimirInfo");
        Habilidad habilidad = new Talento("tal", 1,1);
        Habilidades instance = new Habilidades();
        instance.añadirHabilidad(habilidad);
        instance.imprimirInfo(habilidad);
    }

    @Test
    public void testMostrarDisciplinas() {
        System.out.println("mostrarDisciplinas");
        Habilidades instance = new Habilidades();
        Disciplina dis= new Disciplina("dis", 1, 1, 1);
        instance.añadirHabilidad(dis);
        instance.mostrarDisciplinas();
    }

    @Test
    public void testMostrarDones() {
        System.out.println("mostrarDones");
        Habilidades instance = new Habilidades();
        Don don = new Don("don", 1,1,1);
        instance.añadirHabilidad(don);
        instance.mostrarDones();
    }

    @Test
    public void testMostrarTalentos() {
        System.out.println("mostrarTalentos");
        Habilidades instance = new Habilidades();
        Talento talento = new Talento("tal", 1,1);
        instance.añadirHabilidad(talento);
        instance.mostrarTalentos();
    }

    @Test
    public void testAñadirHabilidad() {
        System.out.println("a\u00f1adirHabilidad");
        Habilidad habilidad = new Talento("tal", 1,1);
        Habilidades instance = new Habilidades();
        instance.añadirHabilidad(habilidad);
        assertTrue(instance.getHabilidades().size()>0);
    }
    
}
