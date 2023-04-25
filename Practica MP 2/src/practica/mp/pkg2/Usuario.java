/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */



public class Usuario {
    private String nombre;
    private String nickname;
    private String contrasena;
    private boolean baneado;
    
    public Usuario (String nombre, String nickname, String contrasena) {
        this.baneado=false;
        this.nombre=nombre;
        this.nickname=nickname;
        this.contrasena=contrasena;
    }
    
    public void darseBaja(BaseUsuarios baseUsuarios) {
        baseUsuarios.eliminar(this.getNombre());
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
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

    /**
     * @return the baneado
     */
    public boolean isBaneado() {
        return baneado;
    }

    /**
     * @param baneado the baneado to set
     */
    public void setBaneado(boolean baneado) {
        this.baneado = baneado;
    }
    
    
}
