
package practica.mp.pkg2;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import practica.mp.pkg2.*;

public class AppTest {
    private App app;

    @Before
    public void setUp() {
        app = new App();
    }

    @Test
    public void testLoadRanking() {
        // Verificar que se carga correctamente la estructura Ranking
        assertNotNull(app.loadRanking());
    }
    @Test
    public void testSaveRanking() {
        // Verificar que se guarda correctamente la estructura Ranking
        app.saveRanking();
        assertNotNull(app.loadRanking());
    }
    @Test
    public void testLoadEquipos() {
        Equipos equipos = app.loadEquipos();
        assertNotNull(equipos);
    }
    
    @Test
    public void testSaveEquipos() {
        Equipos equipos = new Equipos();
        
        // Agregar algunos datos a equipos para simular una estructura no vacía
        Equipo equipo1 = new Equipo("Prueba", 2, 3, 2);
        equipos.anadirEquipo(equipo1);        
        try {
            app.saveEquipos();
        } catch (Exception ex) {
            fail("No se debería haber producido una excepción");
        }
    }
    @Test
    public void testLoadGenerador() {
        GeneradorIDs generador = app.loadGenerador();
        assertNotNull(generador);
    }
    
    @Test
    public void testSaveGenerador() {
        GeneradorIDs generador = new GeneradorIDs();
        app.saveGenerador();
        GeneradorIDs newGenerador = app.loadGenerador();
        assertEquals(generador, newGenerador);
    }
    
    @Test
    public void testLoadHabilidades() {
        Habilidades habilidades = app.loadHabilidades();
        assertNotNull(habilidades);
    }
    
    @Test
    public void testSaveHabilidades() {
        Habilidades habilidades = new Habilidades();
        app.saveHabilidades();
        Habilidades newHabilidades = app.loadHabilidades();
        assertEquals(habilidades, newHabilidades);
    }
}
