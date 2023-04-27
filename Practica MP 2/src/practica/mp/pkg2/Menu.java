/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;
import java.util.*;
import java.util.Scanner;
/**
 *
 * @author Alex
 */
import java.io.*;
//es una pantalla, hace de interfaz con el usuario. Es quien le muestra o le pide cosas al usuario.
public class Menu implements Serializable{
    //Ranking ranking;
    private Usuario p;
    
    public Usuario inicio(Ranking ranking, GeneradorIDs generador, Habilidades habilidades) throws InterruptedException, FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pulse '1' para iniciar sesión o cualquier otra cosa para registrarse:");
        if ("1".equals(scanner.nextLine())){
            System.out.println("Escriba su nombre de usuario (nickname)");
            String nickname = scanner.nextLine();
            Usuario user =ranking.getUsuario(nickname);
            if(user!=null){
                System.out.println("Escriba su contraseña:");
                String contra = scanner.nextLine();
                if(contra.contentEquals(user.getContrasena())){
                    if (user.isBaneado()) {
                        System.out.println("Baneado");
                        return null;
                    }
                    else {
                        System.out.println("Acceso con exito");
                        return user;
                    }
                }
                else{
                    System.out.println("Contraseña incorrecta");
                    return null;}
            }
            else{
                System.out.println("Nickname no registrado");
                return null;}
        }else{
            System.out.println("Escriba su nombre de usuario (nickname)");
            String nickname = scanner.nextLine();
            Usuario user =ranking.getUsuario(nickname);
            if(user!=null){
                System.out.println("Nombre de usuario ya registrado");
                Thread.sleep(3000);
                inicio(ranking, generador, habilidades);
            }else{
                System.out.println("Escriba la contrasena");
                String contra = scanner.nextLine();
                System.out.println("Escriba 'c' para Cliente o cualquier otra cosa para Operador de Sistema");
                String tipo = scanner.nextLine();
                if ("c".equals(tipo)) {
                    Cliente cliente = new Cliente(nickname, nickname, contra, this, generador);
                    ranking.añadirUsuario(cliente);
                    System.out.println("Cliente registrado");
                    cliente.cambiarPersonaje(habilidades);
                    return cliente;
                }
                else {
                    OperadorSistema op = new OperadorSistema(nickname, nickname, contra, this);
                    ranking.añadirUsuario(op);
                    System.out.println("Operador de Sistema registrado");
                    return op;
                }
            }
        }
        return null;
    }


    public AccionCliente pedirAccionCliente(){
        String respuesta= pedirString("Escriba lo que quiere hacer: 'DarseBaja', 'CambiarPersonaje', 'ElegirEquipo', 'Desafiar', 'ResponderDesafios', 'ConsultaCombates', 'ComprarItem' o cualquier otra cosa para SalirSistema");
        switch (respuesta) {
            case "DarseBaja":
                return AccionCliente.DarseBaja;
            case "CambiarPersonaje":
                return AccionCliente.CambiarPersonaje;
            case "ElegirEquipo":
                return AccionCliente.ElegirEquipo;
            case "Desafiar":
                return AccionCliente.Desafiar;
            case "ResponderDesafios":
                return AccionCliente.ResponderDesafios;
            case "ConsultaCombates":
                return AccionCliente.ConsultaCombates;
            case "ComprarItem":
                return AccionCliente.ComprarItem;
            default:
                return AccionCliente.SalirSistema;
        }
    }
    public AccionOp pedirAccionOperador(){
        String respuesta= pedirString("Escriba lo que quiere hacer: 'DarseBaja', 'EditarPersonaje', 'CompletarPersonaje', 'ValidarDesafio', 'Banear', 'Desbanear', 'AñadirItemTienda', 'AnadirHabilidad' o cualquier otra cosa para SalirSistema");
        switch (respuesta) {
            case "DarseBaja":
                return AccionOp.DarseBaja;
            case "EditarPersonaje":
                return AccionOp.EditarPersonaje;
            case "CompletarPersonaje":
                return AccionOp.CompletarPersonaje;
            case "ValidarDesafio":
                return AccionOp.ValidarDesafios;
            case "Banear":
                return AccionOp.Banear;
            case "Desbanear":
                return AccionOp.Desbanear;
            case "AñadirItemTienda":
                return AccionOp.AñadirItemTienda;
            case "AnadirHabilidad":
                return AccionOp.AnadirHabilidad;
            default:
                return AccionOp.SalirSistema;
        }
    }

    public String pedirString (String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        String respuesta = scanner.nextLine();
        return respuesta;
    }

    public void mostrarString (String mensaje) {
        System.out.println(mensaje);
    }

    private int pedirInt(String mensaje) {
        String respuesta = pedirString(mensaje);
        try {
            int num = Integer.parseInt(respuesta);
            return num;
        }
        catch (Exception ex){
            System.out.println("Error class menu method pedirInt");
        }
        return 0;
    }
    
    private int pedirIntRango(String mensaje, int min, int max) {
        boolean end =false;
        int num=0;
        while (!end) {
            String respuesta = pedirString(mensaje);
            try {
                num = Integer.parseInt(respuesta);
                return num;
            }
            catch (Exception ex){
                System.out.println("Error class menu method pedirInt");
            }
            if (num<min || num>max) {
                mostrarString("el numero esta fuera del rango");
            }
            else {
                end=true;
            }
        }
        return num;
    }

    private boolean pedirBool (String mensaje) {
        String respuesta = pedirString(mensaje);
        if (respuesta.equals("s")) {
            return true;
        }
        else {
            return false;
        }
    }

    public String askNombrePersonaje () {
        return pedirString("Introduzca nombre para su nuevo personaje");
    }

    public String askElegirEquipo() {
        return pedirString("Escriba 'armas' si quiere cambiar un arma. Escriba cualquier otra cosa para cambiar armadura");
    }

    public Arma askArma(List<Equipo> equipo, List<Arma> armasActivas) {
        boolean vacio=true;
        mostrarString("Las armas en tu inventario son:");
        int pos =0;
        for (Equipo i: equipo) {
                if (i instanceof Arma) {
                    mostrarString(pos + ": " +i.getNombre() + " ataque: " + i.getAtaque() + " manos: " + ((Arma) i).getManos());
                    vacio=false;
                }
                pos++;
            }
        if (vacio) {
            mostrarString("No hay armas en tu equipo");
            return null;
        }
        mostrarString("Las armas activas son :");
        for (Arma i: armasActivas) {
            mostrarString(i.getNombre());
        }
        int num=-1;
        while (num<0 || !(equipo.get(num) instanceof Arma)) {
            String respuesta = pedirString("Escriba el numero del arma que desea incluir como activa");
            try {
                num = Integer.parseInt(respuesta);
            }
            catch (Exception ex){
                System.out.println("Error class menu method askArma");
            }
            if (!(equipo.get(num) instanceof Arma)) {
                mostrarString("El numero no corresponde a un arma");
            }
        }
        return (Arma) equipo.get(num); 
    }

    public Armadura askArmadura (List<Equipo> equipo) {
        boolean vacio=true;
        mostrarString("Las armaduras en tu inventario son:");
        int pos =0;
        for (Equipo i: equipo) {
                if (i instanceof Armadura) {
                    mostrarString(pos + ": " +i.getNombre() + " defensa: " + i.getDefensa());
                    vacio=false;
                }
                pos++;
            }
        if (vacio) {
            mostrarString("no tienes armaduras en tu equipo");
            return null;
        }
        int num=-1;
        while (num<0 || !(equipo.get(num) instanceof Armadura)) {
            String respuesta = pedirString("Escriba el numero de la armadura que desea incluir como activa");
            try {
                num = Integer.parseInt(respuesta);
            }
            catch (Exception ex){
                System.out.println("Error class menu method askArmadura");
            }
            if (!(equipo.get(num) instanceof Armadura)) {
                mostrarString("El numero no corresponde a una Armadura");
            }
        }
        return (Armadura) equipo.get(num); 
    }

    public Cliente askDesafiado (Ranking ranking) {
        boolean end=false;
        Usuario user=null;
        //mostrarRanking(ranking);
        ranking.mostrarRanking();
        while (!end) {
            String respuesta=pedirString("Escribe el nickname del usuario al que deseas desafiar");
            user = ranking.getUsuario(respuesta);
            if (ranking.getUsuario(respuesta)==null) {
                mostrarString("el usuario no existe");
            }
            else {
                if (user instanceof OperadorSistema) {
                    mostrarString("el usuario es un operador de sistema");
                }
                else {
                    end=true;
                }
            }
        }
        Cliente cliente = (Cliente) user;
        return cliente;
    }

    public int askOroApostado(int oro_max, int oro_rival) {
        boolean end=false;
        int respuesta=0;
        while (!end) {
            respuesta=pedirInt("introduzca oro apostado");
            if (respuesta<=oro_max && respuesta>0 && respuesta<=oro_rival) {
                end=true;
            }
            else {
                mostrarString("Estas apostando mas oro del que dispones o apostando oro negativo");
            }
        }
        return respuesta;
    }

    public boolean askDesafio (Desafio des) {
        mostrarString("Desafio pendiente: ");
        mostrarString("Nombre personaje desafiante: " + des.getDesafiante().getNombre());
        mostrarString("Oro apostado: "+des.getOro_apostado());
        mostrarString("ID desafio: " + des.getId_desafio());
        return pedirBool("Escribe 's' si quieres aceptar el desafio o cualquier otra cosa para rechazarlo");
    }

    public void mostrarCombates (List<Combate> list) {
        mostrarString("Los ultimos combates son: ");
        for (Combate i: list) {
            mostrarString("Combate id: " + i.getID());
            mostrarString("Personaje 1: " + i.getPersonaje1().getNombre());
            mostrarString("Personaje 2: " + i.getPersonaje2().getNombre());
            mostrarString("Rondas "+ i.getRondas().size());
            if (i.getGanador()==null) {
                mostrarString("Empate");
            }
            else {
                mostrarString("Ganador :" + i.getGanador().getNombre());
            }
            mostrarString("Desarrollo del combate: ");
            for (Ronda j: i.getRondas()) {
                mostrarString("Ronda "+j.getNumRonda());
                mostrarString("Daño a personaje 1: "+j.getAtaqueAPersonaje1());
                mostrarString("Daño a personaje 2: "+j.getAtaqueAPersonaje2());
            }
            mostrarString("Fin combate");
        }
    }


    /*public void mostrarRanking (Ranking rank) {
        int pos =0;
        for (Usuario i: rank.getRanking()) {
            pos++;
            mostrarString(pos+ ": " + i.getNickname());
            if (i instanceof Cliente) {
                Cliente cliente= (Cliente) i;
                mostrarString("Desafios ganados: " + cliente.getPersonaje().getDesafios_ganados());
            }
        }
    }*/

    public Personaje askEditarPersonaje(Ranking rank) {
        for (Usuario i: rank.getRanking()) {
            if (i instanceof Cliente) {
                mostrarString(i.getNickname());
            }
        }
        boolean end = false;
        Cliente cliente=null;
        while (!end) {
            String respuesta =pedirString("Escribe el nickname del personaje que quieres editar");
            if ((rank.getUsuario(respuesta) != null) && (rank.getUsuario(respuesta) instanceof Cliente)) {
                cliente = (Cliente) rank.getUsuario(respuesta);
                end=true;
            }
            else {
                mostrarString("El usuario no esta en el ranking o no es cliente");
            }
        }
        return cliente.getPersonaje();
    }

    public void askDatosPersonaje(Personaje per) {
        String respuesta = pedirString("Escribe el nuevo nombre del personaje");
        per.setNombre(respuesta);
    }


    public Personaje askPersonaje (Ranking rank) {
        for (Usuario i: rank.getRanking()) {
            if (i instanceof Cliente) {
                mostrarString(i.getNickname());
            }
        }
        boolean end = false;
        Cliente cliente=null;
        while (!end) {
            String respuesta =pedirString("Escribe el nickname del personaje que quieres completar");
            if ((rank.getUsuario(respuesta) != null) && (rank.getUsuario(respuesta) instanceof Cliente)) {
                cliente = (Cliente) rank.getUsuario(respuesta);
                end=true;
            }
            else {
                mostrarString("El usuario no esta en el ranking o no es cliente");
            }
        }
        return cliente.getPersonaje();
    } 
    
    public String askAñadirAPersonaje () {
        return pedirString("Escribe que quieres añadir al personaje: 'armas', 'armaduras', 'modificador' o cualquier otra cosa para esbirros ");
    }

    public Arma askArmaNueva() {
        String nombre= pedirString("Escribe el nombre del arma: ");
        int ataque = pedirIntRango("Escribe el ataque del arma  (1-3): ", 1, 3);
        int coste = pedirIntRango("Introduce el coste del arma  (1-50): ",1,50);
        int manos = pedirIntRango("Escriba si es de 1 o 2 manos: ",1,2);
        return new Arma(nombre, ataque, 0, coste, manos);
    }

    public Armadura askArmaduraNueva() {
        String nombre= pedirString("Escribe el nombre de la armadura: ");
        int defensa = pedirInt("Escribe la defensa de la armadura: ");
        int coste = pedirInt("Introduce el coste de la armadura: ");
        return new Armadura(nombre, defensa,0 , coste);
    }

    public Modificador askModificadorNuevo() {
        String nombre = pedirString("Escribe el nombre del modificador: ");
        int sensibilidad = pedirIntRango("Escribe la sensibilidad (1-5): ",1,5);
        boolean fortaleza = pedirBool("Escribe 's' para fortaleza o cualquier otra cosa para debilidad");
        return new Modificador(nombre, sensibilidad, fortaleza);
    }

    public Esbirro askEsbirroNuevo(boolean vampiro) {
        String nombre=pedirString("Escribe el nombre del esbirro: ");
        int salud= pedirIntRango("Escribe la salud del esbirro (1-3): ", 1,3);
        String tipo = pedirString("Escribe 'humano', 'ghoul' o cualquier otra cosa para demonio");
        Esbirro esbirro=null;
        if (tipo.equals("humano")) {
            int lealtad = pedirIntRango("Escribe entero de lealtad: 0 baja, 1 normal, 2 alta", 0,2);
            Lealtad leal;
            if (lealtad==0) {
                leal=Lealtad.BAJA;
            }
            else if (lealtad==1) {
                leal=Lealtad.MEDIA;
            }
            else{
                leal=Lealtad.ALTA;
            }
            Humano humano = new Humano(nombre, salud, leal);
            esbirro=humano;
        }
        else if (tipo.equals("ghoul")) {
            int dependencia = pedirIntRango("Escribe entero dependencia (1-3): ",1,3);
            Ghoul ghoul = new Ghoul(nombre, salud, dependencia);
            esbirro=ghoul;
        }
        else{
            String pacto = pedirString("Escribe el pacto: ");
            Demonio demonio = new Demonio (nombre, salud, pacto);
            boolean end=false;
            while (!end) {
                end=pedirBool("Escribe 's' para acabar, escribe cualquier otra cosa para añadir un nuevo esbirro al demonio");
                if (!end) {
                    Esbirro esbirroDemonio= askEsbirroNuevo(false);
                    demonio.anadirEsbirro(esbirroDemonio);
                }
            }
            esbirro=demonio;
        }
        return esbirro;
    }

    public Desafio askDesafioValidar (Ranking rank) {
        Desafio des=null;
        for (Usuario i: rank.getRanking()) {
            if (i instanceof Cliente) {
                Cliente cliente= (Cliente) i;
                for (Desafio j: cliente.getDesafiosPendientes()) {
                    if (!j.isValidado()) {
                        mostrarString("Desafio ID: " + j.getId_desafio());
                        mostrarString("Desafiado: "+j.getDesafiado().getNombre());
                        mostrarString("Desafiante: " + j.getDesafiante().getNombre());
                        mostrarString("Oro apostado: " + j.getOro_apostado());
                        boolean respuesta= pedirBool("Escribe 's' para validar, cualquier otra cosa para pasar al siguiente");
                        if (respuesta) {
                            return j;
                        }
                    }
                }
            }
        }
        return des;
    }

    public Usuario askUsuarioBanear(Ranking ranking) {
        Usuario user =null;
        for (Usuario i: ranking.getRanking()) {
            mostrarString("Nombre Usuario: "+i.getNickname());
            boolean respuesta= pedirBool("Escribe 's' para banear, cualquier otra cosa para pasar al siguiente");
            if (respuesta) {
                return i;
            }
        }
        return user;
    } 

    public Usuario askUsuarioDesbanear (Ranking ranking) {
        Usuario user =null;
        for (Usuario i: ranking.getRanking()) {
            mostrarString("Nombre Usuario: "+i.getNickname());
            boolean respuesta= pedirBool("Escribe 's' para desbanear, cualquier otra cosa para pasar al siguiente");
            if (respuesta) {
                return i;
            }
        }
        return user;
    }

    public Personaje askPersonajeNuevo(Habilidades habilidades) throws FileNotFoundException {
        String nombre = pedirString("Escribe nombre personaje: ");
        int tipo = pedirIntRango("Escribe tipo de Personaje: 0 para vampiro, 1 para licantropo, 2 para cazador",0,2);
        if (tipo==0) {
            Disciplina disciplina = askDisciplina(habilidades);
            Vampiro vampiro = new Vampiro(nombre, disciplina);
            return vampiro;
        }
        else if (tipo==1) {
            Don don = askDon(habilidades);
            Licantropo licantropo = new Licantropo(nombre, don);
            return licantropo;
        }
        else {
            Talento talento = askTalento(habilidades);
            Cazador cazador = new Cazador(nombre, talento);
            return cazador;
        }
    }

    public Disciplina askDisciplinaNueva() throws FileNotFoundException {
        String nombre = pedirString("Elija nombre disciplina");      
        int defensa = pedirIntRango("Elija valor de defensa entre 1 y 3", 1,3);
        int ataque = pedirIntRango("Elija valor de ataque entre 1 y 3",1,3);
        int coste= pedirIntRango("Elija un coste entre 1 y 3",1,3);
        return new Disciplina(nombre,ataque,defensa,coste);
    }

    public Don askDonNuevo() {
        String nombre = pedirString("Escribe nombre don :");
        int defensa = pedirIntRango("Elija valor de defensa entre 1 y 3",1,3);
        int ataque = pedirIntRango("Elija valor de ataque entre 1 y 3",1,3);
        int rabia_minima= pedirIntRango("Elija una rabia minima entre 1 y 3",1,3);
        return new Don(nombre,ataque,defensa,rabia_minima);
    }

    public Talento askTalentoNuevo() {
        String nombre = pedirString("Escribe nombre talento :");
        int defensa = pedirIntRango("Elija valor de defensa entre 1 y 3",1,3);
        int ataque = pedirIntRango("Elija valor de ataque entre 1 y 3",1,3);
        return new Talento(nombre,ataque,defensa);
    }

    public void empate() {
        mostrarString("Empate");
    }

    public void mostrarGanador (Personaje per) {
        mostrarString("El ganador es: "+per.getNombre());
    }
    
    public Equipo pedirItemTienda(Tienda tienda) {
        mostrarString("Los items de la tienda son:");
        int pos=0;
        for (Equipo i: tienda.getItems().getEquipos()) {
            mostrarString(pos+": Nombre: "+i.getNombre() + " Oro: "+ i.getCoste()+ " Ataque: " + i.getAtaque() + " Defensa: " + i.getDefensa());
            pos++;
        }
        int size=tienda.getItems().getEquipos().size();
        int respuesta = pedirIntRango("Escribe el numero para comprar, o escribe "+size+" para salir", 0, size);
        if (respuesta ==size) {
            return null;
        }
        else {
            return tienda.getItems().getEquipos().get(respuesta);
        }
    }

    public Equipo askItemNuevo() {
        Equipo equipo = null;
        String respuesta= pedirString ("Escribe que quiere añadir: 'arma' o cualquier otra cosa para armadura");
        if (respuesta.equals("arma")) {
            Arma arma = askArmaNueva();
            equipo=arma;
        }
        else {
            Armadura armadura = askArmaduraNueva();
            equipo=armadura;
        }
        return equipo;
    }
    
    public Habilidad askHabilidadNueva() throws FileNotFoundException{
        String respuesta= pedirString ("Escribe que quiere añadir: 'disciplina', 'don' o cualquier otra cosa para talento");
        if (respuesta.equals("disciplina")) {
            Disciplina disciplina = askDisciplinaNueva();
            return disciplina;
        }
        else if (respuesta.equals("don")){
            Don don = askDonNuevo();
            return don;
        } else{
            Talento talento = askTalentoNuevo();
            return talento;
        }
    }
    
     public Disciplina askDisciplina(Habilidades habilidades){
        habilidades.mostrarDisciplinas();
        String respuesta= pedirString ("Escribe el nombre de la disciplina elegida");
        return habilidades.getDisciplina(respuesta);
    }
    
    public Don askDon(Habilidades habilidades){
        habilidades.mostrarDones();
        String respuesta= pedirString ("Escribe el nombre del don elegido");
        return habilidades.getDon(respuesta);
    }
    
    public Talento askTalento(Habilidades habilidades){
        habilidades.mostrarTalentos();
        String respuesta= pedirString ("Escribe el nombre del talento elegida");
        return habilidades.getTalento(respuesta);
    }
}
