/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practica.mp.pkg2;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author migue
 */
public class MenuTest {
    
    public MenuTest() {
    }

    @org.junit.Test
    public void testInicio() throws Exception {
        System.out.println("inicio");
        Ranking ranking = null;
        GeneradorIDs generador = null;
        Habilidades habilidades = null;
        Menu instance = new Menu();
        Usuario expResult = null;
        Usuario result = instance.inicio(ranking, generador, habilidades);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testPedirAccionCliente() {
        System.out.println("pedirAccionCliente");
        Menu instance = new Menu();
        AccionCliente expResult = null;
        AccionCliente result = instance.pedirAccionCliente();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testPedirAccionOperador() {
        System.out.println("pedirAccionOperador");
        Menu instance = new Menu();
        AccionOp expResult = null;
        AccionOp result = instance.pedirAccionOperador();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testPedirString() {
        System.out.println("pedirString");
        String mensaje = "";
        Menu instance = new Menu();
        String expResult = "";
        String result = instance.pedirString(mensaje);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testMostrarString() {
        System.out.println("mostrarString");
        String mensaje = "";
        Menu instance = new Menu();
        instance.mostrarString(mensaje);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskNombrePersonaje() {
        System.out.println("askNombrePersonaje");
        Menu instance = new Menu();
        String expResult = "";
        String result = instance.askNombrePersonaje();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskElegirEquipo() {
        System.out.println("askElegirEquipo");
        Menu instance = new Menu();
        String expResult = "";
        String result = instance.askElegirEquipo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskArma() {
        System.out.println("askArma");
        List<Equipo> equipo = null;
        List<Arma> armasActivas = null;
        Menu instance = new Menu();
        Arma expResult = null;
        Arma result = instance.askArma(equipo, armasActivas);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskArmadura() {
        System.out.println("askArmadura");
        List<Equipo> equipo = null;
        Menu instance = new Menu();
        Armadura expResult = null;
        Armadura result = instance.askArmadura(equipo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskDesafiado() {
        System.out.println("askDesafiado");
        Ranking ranking = null;
        Menu instance = new Menu();
        Cliente expResult = null;
        Cliente result = instance.askDesafiado(ranking);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskOroApostado() {
        System.out.println("askOroApostado");
        int oro_max = 0;
        int oro_rival = 0;
        Menu instance = new Menu();
        int expResult = 0;
        int result = instance.askOroApostado(oro_max, oro_rival);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskDesafio() {
        System.out.println("askDesafio");
        Desafio des = null;
        Menu instance = new Menu();
        boolean expResult = false;
        boolean result = instance.askDesafio(des);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testMostrarCombates() {
        System.out.println("mostrarCombates");
        List<Combate> list = null;
        Menu instance = new Menu();
        instance.mostrarCombates(list);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskEditarPersonaje() {
        System.out.println("askEditarPersonaje");
        Ranking rank = null;
        Menu instance = new Menu();
        Personaje expResult = null;
        Personaje result = instance.askEditarPersonaje(rank);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskDatosPersonaje() {
        System.out.println("askDatosPersonaje");
        Personaje per = null;
        Menu instance = new Menu();
        instance.askDatosPersonaje(per);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskPersonaje() {
        System.out.println("askPersonaje");
        Ranking rank = null;
        Menu instance = new Menu();
        Personaje expResult = null;
        Personaje result = instance.askPersonaje(rank);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskAñadirAPersonaje() {
        System.out.println("askA\u00f1adirAPersonaje");
        Menu instance = new Menu();
        String expResult = "";
        String result = instance.askAñadirAPersonaje();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskArmaNueva() {
        System.out.println("askArmaNueva");
        Menu instance = new Menu();
        Arma expResult = null;
        Arma result = instance.askArmaNueva();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskArmaduraNueva() {
        System.out.println("askArmaduraNueva");
        Menu instance = new Menu();
        Armadura expResult = null;
        Armadura result = instance.askArmaduraNueva();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskModificadorNuevo() {
        System.out.println("askModificadorNuevo");
        Menu instance = new Menu();
        Modificador expResult = null;
        Modificador result = instance.askModificadorNuevo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskEsbirroNuevo() {
        System.out.println("askEsbirroNuevo");
        boolean vampiro = false;
        Menu instance = new Menu();
        Esbirro expResult = null;
        Esbirro result = instance.askEsbirroNuevo(vampiro);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskDesafioValidar() {
        System.out.println("askDesafioValidar");
        Ranking rank = null;
        Menu instance = new Menu();
        Desafio expResult = null;
        Desafio result = instance.askDesafioValidar(rank);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskUsuarioBanear() {
        System.out.println("askUsuarioBanear");
        Ranking ranking = null;
        Menu instance = new Menu();
        Usuario expResult = null;
        Usuario result = instance.askUsuarioBanear(ranking);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskUsuarioDesbanear() {
        System.out.println("askUsuarioDesbanear");
        Ranking ranking = null;
        Menu instance = new Menu();
        Usuario expResult = null;
        Usuario result = instance.askUsuarioDesbanear(ranking);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskPersonajeNuevo() throws Exception {
        System.out.println("askPersonajeNuevo");
        Habilidades habilidades = null;
        Menu instance = new Menu();
        Personaje expResult = null;
        Personaje result = instance.askPersonajeNuevo(habilidades);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskDisciplinaNueva() throws Exception {
        System.out.println("askDisciplinaNueva");
        Menu instance = new Menu();
        Disciplina expResult = null;
        Disciplina result = instance.askDisciplinaNueva();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskDonNuevo() {
        System.out.println("askDonNuevo");
        Menu instance = new Menu();
        Don expResult = null;
        Don result = instance.askDonNuevo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskTalentoNuevo() {
        System.out.println("askTalentoNuevo");
        Menu instance = new Menu();
        Talento expResult = null;
        Talento result = instance.askTalentoNuevo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testEmpate() {
        System.out.println("empate");
        Menu instance = new Menu();
        instance.empate();
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testMostrarGanador() {
        System.out.println("mostrarGanador");
        Personaje per = null;
        Menu instance = new Menu();
        instance.mostrarGanador(per);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testPedirItemTienda() {
        System.out.println("pedirItemTienda");
        Tienda tienda = null;
        Menu instance = new Menu();
        Equipo expResult = null;
        Equipo result = instance.pedirItemTienda(tienda);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskItemNuevo() {
        System.out.println("askItemNuevo");
        Menu instance = new Menu();
        Equipo expResult = null;
        Equipo result = instance.askItemNuevo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskHabilidadNueva() throws Exception {
        System.out.println("askHabilidadNueva");
        Menu instance = new Menu();
        Habilidad expResult = null;
        Habilidad result = instance.askHabilidadNueva();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskDisciplina() {
        System.out.println("askDisciplina");
        Habilidades habilidades = null;
        Menu instance = new Menu();
        Disciplina expResult = null;
        Disciplina result = instance.askDisciplina(habilidades);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskDon() {
        System.out.println("askDon");
        Habilidades habilidades = null;
        Menu instance = new Menu();
        Don expResult = null;
        Don result = instance.askDon(habilidades);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testAskTalento() {
        System.out.println("askTalento");
        Habilidades habilidades = null;
        Menu instance = new Menu();
        Talento expResult = null;
        Talento result = instance.askTalento(habilidades);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
