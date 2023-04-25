/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;
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
    
    
    
public User inicio() throws InterruptedException{
    Scanner scanner = new Scanner(System.in);
    Ranking ranking= new Ranking();
    System.out.println("Pulse '1' para iniciar sesión o '2' para registrarse:");
    if ("1".equals(scanner.nextLine())){
        System.out.println("Escriba su nombre de usuario (nickname)");
        String nickname = scanner.nextLine();
        Usuario user =ranking.buscarUsuario(nickname);
        if(user!=null){
            System.out.println("Escriba su contraseña:");
            String contra = scanner.nextLine();
            if(contra.contentEquals(user.getContrasena())){
                System.out.println("Acceso con exito");
                return user;
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
        Usuario user =ranking.buscarUsuario(nickname);
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
                Cliente cliente = new Cliente(nickname, contra);
                ranking.add(cliente);
                System.out.println("Cliente registrado");
                return cliente;
            }
            else {
                OperadorSistema op = new OperadorSistema(nickname, contra);
                ranking.add(op);
                System.out.println("Operador de Sistema registrado");
                return op;
            }
        }
    }


}

//pregunta en bucle que hacer y le dice al usuario que lo haga
public void inicio (Usuario user, BaseUsuarios base) {
    boolean end = false;
    AccionCliente accionCliente;
    AccionOp accionOp;
    Cliente cliente;
    OperadorSistema op;
    if (user instanceof Cliente) { //acciones diferentes dependiendo de si es cliente o operadorSistema
        cliente= (Cliente) user;
        while (!end) {  //bucle hata que se elija DarseBaja o SalirSistema
            pedirAccionCliente(accionCliente); //pide al usuario que elija una accion
            switch (accionCliente) {
                case DarseBaja:
                    cliente.darseBaja(base);
                    end=true;
                    break;
                case SalirSistema:
                    end=true;
                    break;
                case CambiarPersonaje:
                    cliente.cambiarPersonaje();
                    break;
                case ElegirEquipo:
                    cliente.elegirEquipo();
                    break;
                case Desafiar:
                    cliente.desafiar();
                    break;
                case ResponderDesafios:
                    cliente.responderDesafios();
                    break;
                case ConsultaCombates:
                    cliente.consultaCombates();
                    break;
                case ConsultaRanking:
                    cliente.consultaRanking();
                    break;
            }
        }
    } 
    else {
        op= (OperadorSistema) user;
        while (!end) { //bucle hasta que se elija DarseBaja o SalirSistema
            pedirAccionOperador(accionOp);
            switch (accionOp) {
                case DarseBaja:
                    op.darseBaja(base);
                    end=true;
                    break;
                case SalirSistema:
                    end=true;
                    break;
                case EditarPersonaje:
                    op.cambiarPersonaje();
                    break;
                case CompletarPersonaje:
                    op.elegirEquipo();
                    break;
                case ValidarDesafios:
                    op.desafiar();
                    break;
                case Banear:
                    op.responderDesafios();
                    break;
                case Desbanear:
                    op.consultaCombates();
                    break;
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
}
}