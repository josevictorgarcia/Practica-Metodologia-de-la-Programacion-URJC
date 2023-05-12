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
public class MenuTest {
    
    public MenuTest() {
    }

    @org.junit.Test
    public void testInicio() throws Exception { //prueba registro o login de "cliente"
        System.out.println("inicio");
        Ranking ranking = new Ranking();
        GeneradorIDs generador = new GeneradorIDs();
        Habilidades habilidades = new Habilidades();
        Menu instance = new Menu();
        ranking.añadirUsuario(new Cliente("cliente","cliente","contra",instance, generador));
        Usuario result = instance.inicio(ranking, generador, habilidades);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testPedirAccionCliente() {
        System.out.println("pedirAccionCliente");
        Menu instance = new Menu();
        AccionCliente result = instance.pedirAccionCliente();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testPedirAccionOperador() {
        System.out.println("pedirAccionOperador");
        Menu instance = new Menu();
        AccionOp result = instance.pedirAccionOperador();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testPedirString() {
        System.out.println("pedirString");
        String mensaje = "";
        Menu instance = new Menu();
        String result = instance.pedirString(mensaje);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testMostrarString() {
        System.out.println("mostrarString");
        String mensaje = "String a mostrar";
        Menu instance = new Menu();
        instance.mostrarString(mensaje);
    }

    @org.junit.Test
    public void testAskNombrePersonaje() {
        System.out.println("askNombrePersonaje");
        Menu instance = new Menu();
        String result = instance.askNombrePersonaje();
        assertTrue(result!=null);
    }

   @org.junit.Test
    public void testAskElegirEquipo() {
        System.out.println("askElegirEquipo");
        Menu instance = new Menu();
        String result = instance.askElegirEquipo();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskArma() {
        System.out.println("askArma");
        List<Equipo> equipo = new ArrayList();
        equipo.add(new Arma("arma", 1,0,1,2));
        List<Arma> armasActivas = new ArrayList();
        Menu instance = new Menu();
        Arma result = instance.askArma(equipo, armasActivas);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskArmadura() {
        System.out.println("askArmadura");
        List<Equipo> equipo = new ArrayList();
        equipo.add(new Armadura("armadura", 1,0,1));
        Menu instance = new Menu();
        Armadura result = instance.askArmadura(equipo);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskDesafiado() {
        System.out.println("askDesafiado");
        Ranking ranking = new Ranking();
        GeneradorIDs generador= new GeneradorIDs();
        Menu instance = new Menu();
        ranking.añadirUsuario(new Cliente("cliente","cliente","contra",instance,generador));
        Cliente result = instance.askDesafiado(ranking);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskOroApostado() {
        System.out.println("askOroApostado");
        int oro_max = 300;
        int oro_rival = 50;
        Menu instance = new Menu();
        int result = instance.askOroApostado(oro_max, oro_rival);
        assertTrue(result>0 && result<oro_max && result<oro_rival);
    }

    @org.junit.Test
    public void testAskDesafio() {
        System.out.println("askDesafio");
        
        Menu instance = new Menu();
        GeneradorIDs generador= new GeneradorIDs();
        
        //crear personajes
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
        
        Cliente cliente = new Cliente ("cliente", "cliente", "contra", instance, generador);
        cliente.setPersonaje(personaje1);
        
        Desafio des = new Desafio(personaje1, personaje2, 3, generador, cliente);
        boolean result = instance.askDesafio(des);
    }

    @org.junit.Test
    public void testMostrarCombates() {
        System.out.println("mostrarCombates");
        List<Combate> list = new ArrayList();
        
        //crear combate: 
        
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
        
        
        Combate combate = new Combate(personaje1, personaje2);
        combate.desarrolloCombate();
        
        list.add(combate);
        Menu instance = new Menu();
        instance.mostrarCombates(list);
    }

    @org.junit.Test
    public void testAskEditarPersonaje() {
        System.out.println("askEditarPersonaje");
        Ranking rank = new Ranking();
        Menu instance = new Menu();
        GeneradorIDs generador = new GeneradorIDs();
        
        Licantropo personaje1= new Licantropo("prueba", new Don("prueba",1,2,1));
        personaje1.setRabia(0);
        personaje1.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        personaje1.anadirItem(arma);
        personaje1.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        personaje1.anadirItem(armadura);
        personaje1.setArmadura_activa(armadura);
        
        Cliente cliente = new Cliente ("cliente", "cliente", "contra", instance, generador);
        cliente.setPersonaje(personaje1);
        
        rank.añadirUsuario(cliente);
        Personaje result = instance.askEditarPersonaje(rank);
        assertTrue(result!=null);
    }

   @org.junit.Test
    public void testAskDatosPersonaje() {
        System.out.println("askDatosPersonaje");
        Personaje per = new Licantropo("lican", new Don("don",1,1,1));
        Menu instance = new Menu();
        instance.askDatosPersonaje(per);
        assertTrue(! per.getNombre().equals("lican")); //si nombre es distinto del original
    }

    @org.junit.Test
    public void testAskPersonaje() {
        System.out.println("askPersonaje");
        Ranking rank = new Ranking();
        Menu instance = new Menu();
        GeneradorIDs generador = new GeneradorIDs();
        
        Licantropo personaje1= new Licantropo("prueba", new Don("prueba",1,2,1));
        personaje1.setRabia(0);
        personaje1.setPoder(3);
        Arma arma = new Arma("arma",1,0,0,2);
        personaje1.anadirItem(arma);
        personaje1.ponerArmaActiva(arma);
        Armadura armadura = new Armadura("armadura", 1,0,0);
        personaje1.anadirItem(armadura);
        personaje1.setArmadura_activa(armadura);
        
        Cliente cliente = new Cliente ("cliente", "cliente", "contra", instance, generador);
        cliente.setPersonaje(personaje1);
        
        rank.añadirUsuario(cliente);
        Personaje result = instance.askPersonaje(rank);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskAñadirAPersonaje() {
        System.out.println("askA\u00f1adirAPersonaje");
        Menu instance = new Menu();
        String result = instance.askAñadirAPersonaje();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskArmaNueva() {
        System.out.println("askArmaNueva");
        Menu instance = new Menu();
        Arma result = instance.askArmaNueva();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskArmaduraNueva() {
        System.out.println("askArmaduraNueva");
        Menu instance = new Menu();
        Armadura result = instance.askArmaduraNueva();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskModificadorNuevo() {
        System.out.println("askModificadorNuevo");
        Menu instance = new Menu();
        Modificador result = instance.askModificadorNuevo();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskEsbirroNuevo() {
        System.out.println("askEsbirroNuevo");
        boolean vampiro = false;
        Menu instance = new Menu();
        Esbirro result = instance.askEsbirroNuevo(vampiro);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskDesafioValidar() {
        System.out.println("askDesafioValidar");
        
        //creamos desafio valido y lo enviamos
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
        
        Desafio des = new Desafio(instance.getPersonaje(), cliente2.getPersonaje(), 2, generador, instance);
        instance.enviarDesafio(des, cliente2);
        
        
        Desafio result = menu.askDesafioValidar(ranking);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskUsuarioBanear() {
        System.out.println("askUsuarioBanear");
        Ranking ranking = new Ranking();
        Menu instance = new Menu();
        GeneradorIDs generador = new GeneradorIDs();
        ranking.añadirUsuario(new Cliente("cliente","cliente","contra",instance, generador));
        Usuario result = instance.askUsuarioBanear(ranking);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskUsuarioDesbanear() {
        System.out.println("askUsuarioDesbanear");
        Ranking ranking = new Ranking();
        Menu instance = new Menu();
        GeneradorIDs generador = new GeneradorIDs();
        ranking.añadirUsuario(new Cliente("cliente","cliente","contra",instance, generador));
        Usuario result = instance.askUsuarioDesbanear(ranking);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskPersonajeNuevo() throws Exception {
        System.out.println("askPersonajeNuevo");
        Habilidades habilidades = new Habilidades();
        habilidades.añadirHabilidad(new Talento("tal",1,1));
        habilidades.añadirHabilidad(new Don("don",1,1,1));
        habilidades.añadirHabilidad(new Disciplina("dis",1,1,1));
        Menu instance = new Menu();
        Personaje result = instance.askPersonajeNuevo(habilidades);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskDisciplinaNueva() throws Exception {
        System.out.println("askDisciplinaNueva");
        Menu instance = new Menu();
        Disciplina result = instance.askDisciplinaNueva();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskDonNuevo() {
        System.out.println("askDonNuevo");
        Menu instance = new Menu();
        Don result = instance.askDonNuevo();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskTalentoNuevo() {
        System.out.println("askTalentoNuevo");
        Menu instance = new Menu();
        Talento result = instance.askTalentoNuevo();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testEmpate() {
        System.out.println("empate");
        Menu instance = new Menu();
        instance.empate();
    }

    @org.junit.Test
    public void testMostrarGanador() {
        System.out.println("mostrarGanador");
        Personaje per = new Licantropo("lican", new Don("don",1,1,1));
        Menu instance = new Menu();
        instance.mostrarGanador(per);
    }

    @org.junit.Test
    public void testPedirItemTienda() {
        System.out.println("pedirItemTienda");
        Equipos equipos=new Equipos();
        equipos.anadirEquipo(new Arma("arma",1,0,1,2));
        Tienda tienda = new Tienda(equipos);
        Menu instance = new Menu();
        Equipo result = instance.pedirItemTienda(tienda);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskItemNuevo() {
        System.out.println("askItemNuevo");
        Menu instance = new Menu();
        Equipo result = instance.askItemNuevo();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskHabilidadNueva() throws Exception {
        System.out.println("askHabilidadNueva");
        Menu instance = new Menu();
        Habilidad result = instance.askHabilidadNueva();
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskDisciplina() {
        System.out.println("askDisciplina");
        Habilidades habilidades = new Habilidades();
        habilidades.añadirHabilidad(new Disciplina("dis", 1,1,1));
        Menu instance = new Menu();
        Disciplina result = instance.askDisciplina(habilidades);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskDon() {
        System.out.println("askDon");
        Habilidades habilidades = new Habilidades();
        habilidades.añadirHabilidad(new Don("don", 1,1,1));
        Menu instance = new Menu();
        Don result = instance.askDon(habilidades);
        assertTrue(result!=null);
    }

    @org.junit.Test
    public void testAskTalento() {
        System.out.println("askTalento");
        Habilidades habilidades = new Habilidades();
        habilidades.añadirHabilidad(new Talento("tal", 1,1));
        Menu instance = new Menu();
        Talento result = instance.askTalento(habilidades);
        assertTrue(result!=null);
    }
    
}
