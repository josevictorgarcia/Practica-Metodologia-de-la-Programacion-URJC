/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */
public class Usuario implements Comparable<Usuario>{
    private String nombre;
    private String nickname;
    private String contrasena;
    private Personaje personaje;
    
    public void darseBaja(BaseUsuarios baseUsuarios) {
        baseUsuarios.eliminar(this.getNombre());
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    @Override
    public int compareTo(Usuario u) {
        return this.personaje.getDesafios_ganados() - u.personaje.getDesafios_ganados();
    }

    public Personaje getPersonaje() {
        return personaje;
    }
    
    
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
