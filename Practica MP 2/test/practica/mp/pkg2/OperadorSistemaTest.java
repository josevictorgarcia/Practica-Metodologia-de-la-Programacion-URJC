/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practica.mp.pkg2;

import org.junit.Test;
import static org.junit.Assert.*;

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
        Ranking rank = app.loadRanking();
        OperadorSistema instance = new OperadorSistema("prueba", "prueba", "prueba", new Menu());
        instance.editarPersonaje(rank);
    }

    @Test
    public void testCompletarPersonaje() {
        System.out.println("completarPersonaje");
        Ranking rank = null;
        Equipos equipos = null;
        OperadorSistema instance = null;
        instance.completarPersonaje(rank, equipos);
    }

    @Test
    public void testValidarDesafios() {
        System.out.println("validarDesafios");
        Ranking ranking = null;
        OperadorSistema instance = null;
        instance.validarDesafios(ranking);
    }

    @Test
    public void testBanear() {
        System.out.println("banear");
        Ranking ranking = null;
        OperadorSistema instance = null;
        instance.banear(ranking);
    }

    @Test
    public void testDesbanear() {
        System.out.println("desbanear");
        Ranking ranking = null;
        OperadorSistema instance = null;
        instance.desbanear(ranking);
    }

    @Test
    public void testAñadirItemTienda() {
        System.out.println("a\u00f1adirItemTienda");
        Equipos equipos = null;
        OperadorSistema instance = null;
        instance.añadirItemTienda(equipos);
    }

    @Test
    public void testAñadirHabilidad() throws Exception {
        System.out.println("a\u00f1adirHabilidad");
        Habilidades habilidades = null;
        OperadorSistema instance = null;
        instance.añadirHabilidad(habilidades);
    }
    
}
