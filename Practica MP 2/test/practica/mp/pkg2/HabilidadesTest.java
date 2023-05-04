/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practica.mp.pkg2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author migue
 */
public class HabilidadesTest {
    
    public HabilidadesTest() {
    }

  /*  @Test
    public void testImprimirInfo() {
        System.out.println("imprimirInfo");
        Habilidad habilidad = null;
        Habilidades instance = new Habilidades();
        instance.imprimirInfo(habilidad);
    }***/

    @Test
    public void testMostrarDisciplinas() {
        System.out.println("mostrarDisciplinas");
        Habilidades instance = new Habilidades();
        instance.mostrarDisciplinas();
    }

    @Test
    public void testMostrarDones() {
        System.out.println("mostrarDones");
        Habilidades instance = new Habilidades();
        instance.mostrarDones();
    }

    @Test
    public void testMostrarTalentos() {
        System.out.println("mostrarTalentos");
        Habilidades instance = new Habilidades();
        instance.mostrarTalentos();
    }

    @Test
    public void testAñadirHabilidad() {
        System.out.println("a\u00f1adirHabilidad");
        Habilidad habilidad = null;
        Habilidades instance = new Habilidades();
        instance.añadirHabilidad(habilidad);
    }

    @Test
    public void testGetDisciplina() {
        System.out.println("getDisciplina");
        String nombre = "";
        Habilidades instance = new Habilidades();
        Disciplina expResult = null;
        Disciplina result = instance.getDisciplina(nombre);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTalento() {
        System.out.println("getTalento");
        String nombre = "";
        Habilidades instance = new Habilidades();
        Talento expResult = null;
        Talento result = instance.getTalento(nombre);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDon() {
        System.out.println("getDon");
        String nombre = "";
        Habilidades instance = new Habilidades();
        Don expResult = null;
        Don result = instance.getDon(nombre);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHabilidades() {
        System.out.println("getHabilidades");
        Habilidades instance = new Habilidades();
        List<Habilidad> expResult = new ArrayList();
        List<Habilidad> result = instance.getHabilidades();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetHabilidades() {
        System.out.println("setHabilidades");
        List<Habilidad> habilidades = null;
        Habilidades instance = new Habilidades();
        instance.setHabilidades(habilidades);
    }
    
}
