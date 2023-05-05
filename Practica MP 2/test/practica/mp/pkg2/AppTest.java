
package practica.mp.pkg2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class AppTest {
    private App app;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        app = new App();
    }

    @After
    public void tearDown() throws Exception {
    }

    
     //los metodos load se ejecutan en el constructor, por lo que no se pueden testear correctamente
    //los metodos save no se pueden testear bien pues no podemos ejecutar loads para comprobar si se han realizado correctamente
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
        // Crear instancia de Generador
        GeneradorIDs generador = app.loadGenerador();
        
        // Añadir algunos generadores
        app.saveGenerador();
        app.getGenerador().getID();
        app.getGenerador().getID();
        
        // Guardar los nuevos generadores en archivo
        app.saveGenerador();
    
        // Cargar los generadores guardados
        GeneradorIDs generadoresCargados = app.loadGenerador();
        
        // Verificar que los generadores cargados son iguales a los generadores originales
        assertEquals(app.getGenerador().getIds().size(), generadoresCargados.getIds().size());
        
        // Restaurar los generadores
        app.setGenerador(generador);
        app.saveHabilidades();
    }

    @Test
    public void testLoadHabilidades() {
        Habilidades habilidades = app.loadHabilidades();
        assertNotNull(habilidades);
    }

    @Test
    public void testSaveHabilidades() {
        // Crear instancia de Habilidades
        Habilidades habilidades = app.loadHabilidades();
        Habilidades habilidades1 = app.loadHabilidades();
        // Añadir algunas habilidades
        habilidades.añadirHabilidad(new Talento("Habilidad 1", 5, 3));
        habilidades.añadirHabilidad(new Disciplina("Habilidad 2", 8, 2, 10));
        habilidades.añadirHabilidad(new Don("Habilidad 3", 10, 0, 5));
        
        // Guardar las habilidades
        app.getHabilidades().setHabilidades(habilidades.getHabilidades());
        app.saveHabilidades();
    
        // Cargar las habilidades guardadas
        Habilidades habilidadesCargadas = app.loadHabilidades();
    
        // Verificar que las habilidades cargadas son iguales a las habilidades originales
        assertEquals(habilidades.getHabilidades().size(), habilidadesCargadas.getHabilidades().size());
        assertEquals(habilidades.getTalento("Habilidad 1").getNombre(), habilidadesCargadas.getTalento("Habilidad 1").getNombre());
        assertEquals(habilidades.getDisciplina("Habilidad 2").getNombre(), habilidadesCargadas.getDisciplina("Habilidad 2").getNombre());
        assertEquals(habilidades.getDon("Habilidad 3").getNombre(), habilidadesCargadas.getDon("Habilidad 3").getNombre());
        
        // Restaurar las habilidades
        app.getHabilidades().setHabilidades(habilidades1.getHabilidades());
        app.saveHabilidades();
    }

    /**
     * Test of run method, of class App.
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("run");
        App instance = new App();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
