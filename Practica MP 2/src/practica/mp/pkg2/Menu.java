/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
public class Menu {
    
    //pregunta en bucle que hacer y le dice al usuario que lo haga
    public void inicio (Usuario user, BaseUsuarios base) {
        boolean end = false;
        AccionCliente accionCliente;
        AccionOp accionOp;
        Cliente cliente;
        OperadorSistema op;
        if (user instanceof Cliente) {
            cliente= (Cliente) user;
            while (!end) {
                pedirAccionCliente(accionCliente);
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
            while (!end) {
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
}
