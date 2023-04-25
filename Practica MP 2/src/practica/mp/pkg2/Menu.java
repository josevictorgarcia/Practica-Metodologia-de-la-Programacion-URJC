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
    
    
    
    public void inicio() throws InterruptedException{
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
                    //Que vaya al menú principal;
                    
                }else{inicio();};
            }else{inicio();};
        }else{
            System.out.println("Escriba su nombre de usuario (nickname)");
            String nickname = scanner.nextLine();
            Usuario user =ranking.buscarUsuario(nickname);
            if(user!=null){
                System.out.println("Nombre de usuario ya registrado");
                Thread.sleep(3000);
                inicio();
            }else{
                //crearUsuario(nickname); //hay que hacerlo
            }
        }
        
        
    }
    /*
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
*/
    /*public void pedirAccionCliente(AccionCliente accionCliente)throws InterruptedException{
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
}
*/
