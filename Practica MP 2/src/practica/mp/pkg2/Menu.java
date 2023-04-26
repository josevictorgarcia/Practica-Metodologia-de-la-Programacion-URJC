/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Alex
 */

//es una pantalla, hace de interfaz con el usuario. Es quien le muestra o le pide cosas al usuario.
public class Menu {
    //Ranking ranking;

    public Menu() {
    }
    
    
    
public Usuario inicio() throws InterruptedException{
    Scanner scanner = new Scanner(System.in);
    Ranking ranking= new Ranking();
    System.out.println("Pulse '1' para iniciar sesión o '2' para registrarse:");
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
                return null;};
        }
        else{
            System.out.println("Nickname no registrado");
            return null;};
    }else{
        System.out.println("Escriba su nombre de usuario (nickname)");
        String nickname = scanner.nextLine();
        Usuario user =ranking.getUsuario(nickname);
        if(user!=null){
            System.out.println("Nombre de usuario ya registrado");
            Thread.sleep(3000);
            inicio();
        }else{
            System.out.println("Escriba la contrasena");
            String contra = scanner.nextLine();
            System.out.println("Escriba 'c' para Cliente o 'op' para Operador de Sistema");
            String tipo = scanner.nextLine();
            if ("c".equals(tipo)) {
                Cliente cliente = new Cliente(nickname, nickname, contra, this);
                ranking.add(cliente);
                System.out.println("Cliente registrado");
                return cliente;
            }
            else {
                OperadorSistema op = new OperadorSistema(nickname, nickname, contra);
                ranking.add(op);
                System.out.println("Operador de Sistema registrado");
                return op;
            }
        }
    }


}


public void pedirAccionCliente(AccionCliente accionCliente)throws InterruptedException{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Elija lo que quiere hacer: ");
    if ("DarseBaja".equals(scanner.nextLine())){            
        accionCliente= accionCliente.DarseBaja;
    }else if ("SalirSistema".equals(scanner.nextLine())){
        accionCliente= accionCliente.SalirSistema;
    }else if ("CambiarPersonaje".equals(scanner.nextLine())){
        accionCliente= accionCliente.CambiarPersonaje;
    }else if ("ElegirEquipo".equals(scanner.nextLine())){
        accionCliente= accionCliente.ElegirEquipo;
    }else if ("Desafiar".equals(scanner.nextLine())){
        accionCliente= accionCliente.Desafiar;
    }else if ("ResponderDesafios".equals(scanner.nextLine())){
        accionCliente= accionCliente.ResponderDesafios;
    }else if ("ConsultaCombates".equals(scanner.nextLine())){
        accionCliente= accionCliente.ConsultaCombates;
    }else if ("ConsultaRanking".equals(scanner.nextLine())){
        accionCliente= accionCliente.ConsultaRanking;
    }
}
public void pedirAccionOperador(AccionOp accionOp)throws InterruptedException{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Elija lo que quiere hacer: ");
    if ("DarseBaja".equals(scanner.nextLine())){            
        accionOp= accionOp.DarseBaja;
    }else if ("SalirSistema".equals(scanner.nextLine())){
        accionOp= accionOp.SalirSistema;
    }else if ("CambiarPersonaje".equals(scanner.nextLine())){
        accionOp= accionOp.EditarPersonaje;
    }else if ("ElegirEquipo".equals(scanner.nextLine())){
        accionOp= accionOp.CompletarPersonaje;
    }else if ("Desafiar".equals(scanner.nextLine())){
        accionOp= accionOp.ValidarDesafios;
    }else if ("ResponderDesafios".equals(scanner.nextLine())){
        accionOp= accionOp.Banear;
    }else if ("ConsultaCombates".equals(scanner.nextLine())){
        accionOp= accionOp.Desbanear;
    }
}

private String pedirString (String mensaje) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(mensaje);
    String respuesta = scanner.nextLine();
    scanner.close();
    return respuesta;
}

private void mostrarString (String mensaje) {
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
    mostrarString("Las armas en tu inventario son:");
    int pos =0;
    for (Equipo i: equipo) {
            if (i instanceof Arma) {
                mostrarString(pos + ": " +i.getNombre());
            }
            pos++;
        }
    mostrarString("Las armas activas son :");
    for (Arma i: armasActivas) {
        mostrarString(i.getNombre());
    }
    String respuesta = pedirString("Escriba el numero del arma que desea incluir como activa");
    try {
        int num = Integer.parseInt(respuesta);
        return (Arma) equipo.get(num); 
    }
    catch (Exception ex){
        System.out.println("Error class menu method askArma");
    }
}

public Armadura askArmadura (List<Equipo> equipo) {
    mostrarString("Las armaduras en tu inventario son:");
    int pos =0;
    for (Equipo i: equipo) {
            if (i instanceof Armadura) {
                mostrarString(pos + ": " +i.getNombre());
            }
            pos++;
        }
    String respuesta = pedirString("Escriba el numero de la armadura que desea incluir como activa");
    try {
        int num = Integer.parseInt(respuesta);
        return (Armadura) equipo.get(num); 
    }
    catch (Exception ex){
        System.out.println("Error class menu method askArmadura");
    }
}

public Cliente askDesafiado (Ranking ranking) {
    boolean end=false;
    Usuario user=null;
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
    }
}


public void mostrarRanking (Ranking rank) {
    int pos =0;
    for (Usuario i: rank.getRanking()) {
        pos++;
        mostrarString(pos+ ": " + i.getNickname());
        if (i instanceof Cliente) {
            Cliente cliente= (Cliente) i;
            mostrarString("Desafios ganados: " + cliente.getPersonaje().getDesafios_ganados());
        }
    }
}

public Personaje askEditarPersonaje(Ranking rank) {
    for (Usuario i: rank.getRanking()) {
        if (i instanceof Cliente) {
            mostrarString(i.getNickname());
        }
    }
    String respuesta =pedirString("Escribe el nickname del personaje que quieres editar");
    Cliente cliente = (Cliente) rank.getUsuario(respuesta);
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
    String respuesta =pedirString("Escribe el nickname del personaje que quieres completar");
    Cliente cliente = (Cliente) rank.getUsuario(respuesta);
    return cliente.getPersonaje();
} 
public String askAñadirAPersonaje () {
    return pedirString("Escribe que quieres añadir al personaje: 'armas', 'armaduras', 'modificador' o 'esbirros' ");
}

public Arma askArmaNueva() {
    String nombre= pedirString("Escribe el nombre del arma: ");
    int ataque = pedirInt("Escribe el ataque del arma: ");
    int coste = pedirInt("Introduce el coste del arma: ");
    int manos = pedirInt("Escriba si es de 1 o 2 manos: ");
    return new Arma(nombre, ataque, 0, coste, manos);
}

public Armadura askArmaduraNueva() {
    String nombre= pedirString("Escribe el nombre de la armadura: ");
    int defensa = pedirInt("Escribe la defensa de la armadura: ");
    int coste = pedirInt("Introduce el coste de la armadura: ");
    return new Armadura(nombre, 0, defensa, coste);
}

public Modificador askModificadorNuevo() {
    String nombre = pedirString("Escribe el nombre del modificador: ");
    int sensibilidad = pedirInt("Escribe la sensibilidad: ");
    boolean fortaleza = pedirBool("Escribe 's' para fortaleza o cualquier otra cosa para debilidad");
    return new Modificador(nombre, sensibilidad, fortaleza);
}

public Esbirro askEsbirroNuevo(boolean vampiro) {
    String nombre=pedirString("Escribe el nombre del esbirro: ");
    int salud= pedirInt("Escribe la salud del esbirro: ");
    String tipo = pedirString("Escribe 'humano', 'ghoul' o 'demonio'");
    Esbirro esbirro=null;
    if (tipo.equals("humano")) {
        int lealtad = pedirInt("Escribe entero de lealtad: 0 baja, 1 normal, 2 alta");
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
        int dependencia = pedirInt("Escribe entero dependencia: ");
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
                Esbirro esbirroDemonio= menu.askEsbirroNuevo();
                demonio.anadirEsbirro(esbirroDemonio);
            }
        }
    }
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

public Personaje askPersonajeNuevo() {
    String nombre = pedirString("Escribe nombre personaje: ");
    int poder = pedirInt("Escribe poder entre 1-5");
    int tipo = pedirInt("Escribe tipo de Personaje: 0 para vampiro, 1 para licantropo, 2 para cazador");
    if (tipo==0) {
        Disciplina disciplina = menu.askDisciplinaNueva();
        Vampiro vampiro = new Vampiro(nombre, poder, disciplina);
        return vampiro;
    }
    else if (tipo==1) {
        Don don = menu.askDonNuevo();
        Licantropo licantropo = new Licantropo(nombre, poder, don);
        return licantropo;
    }
    else {
        Talento talento = menu.askTalentoNuevo();
        Cazador cazador = new Cazador(nombre, poder, talento);
        return cazador;
    }
}

public Disciplina askDisciplinaNueva() {
    String nombre = pedirString("Escribe nombre disciplina :");
    int ataque = pedirInt("Escribe valor ataque 1-3");
    int defensa=pedirInt("Escribe valor defensa 1-3");
    int coste=pedirInt("Escribe coste 1-3");
    return new Disciplina(nombre,ataque,defensa,coste);
}

public Don askDonNuevo() {
    String nombre = pedirString("Escribe nombre don :");
    int ataque = pedirInt("Escribe valor ataque 1-3");
    int defensa=pedirInt("Escribe valor defensa 1-3");
    int rabia_minima=pedirInt("Escribe rabia minima 1-3");
    return new Don(nombre,ataque,defensa,rabia_minima);
}

public Talento askTalentoNuevo() {
    String nombre = pedirString("Escribe nombre talento :");
    int ataque = pedirInt("Escribe valor ataque 1-3");
    int defensa=pedirInt("Escribe valor defensa 1-3");
    return new Talento(nombre,ataque,defensa);
}

}
