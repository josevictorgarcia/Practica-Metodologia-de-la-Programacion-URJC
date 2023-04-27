/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.mp.pkg2;

/**
 *
 * @author Alex
 */

import java.util.*;
import java.io.*;
public class GeneradorIDs implements Serializable{
    private List<String> ids;
    
    //ID de formato  LNNLL  
    
    public GeneradorIDs () {
        this.ids = new ArrayList();
    }
    
    public String getID () {
        String id;
        if (this.ids.size()==0) {
            id = "A00AA";
            this.ids.add(id);
        }
        else {
            String idUltimo= this.ids.get(this.ids.size()-1);
            if (idUltimo.charAt(4) < 'Z') {
                id = idUltimo.substring(0,3) + (idUltimo.charAt(4) +1) ;
            }
            else {
                if (idUltimo.charAt(3) < 'Z') {
                    id = idUltimo.substring(0, 2) + (idUltimo.charAt(3) +1) + 'Z';
                }
                else {
                    if (idUltimo.charAt(2) < '9') {
                        id = idUltimo.substring(0,1) + (idUltimo.charAt(2) + 1) + "ZZ";
                    }
                    else {
                        if (idUltimo.charAt(1) < '9') {
                            id = idUltimo.charAt(0) + (idUltimo.charAt(1) + 1) + "9ZZ";
                        }
                        else {
                            if (idUltimo.charAt(0) < 'Z') {
                                id = (idUltimo.charAt(0) + 1) + "99ZZ";
                            }
                            else {
                                id = "Z99ZZ";
                            }
                        }
                    }
                }
            }
        }
        return id;
    }
    
    public void saveGenerador() {
        try {
            FileOutputStream archivo = new FileOutputStream("generador.ser");
            ObjectOutputStream rankingSalida = new ObjectOutputStream(archivo);
            rankingSalida.writeObject(this);
            rankingSalida.close();
        }
        catch (Exception ex) {
        System.out.println("Error clase App method saveGenerador");}
    }
    
    public GeneradorIDs loadGenerador() {
        try {
            FileInputStream archivo = new FileInputStream("generador.ser");
            ObjectInputStream rankingEntrada = new ObjectInputStream(archivo);
            GeneradorIDs generador = (GeneradorIDs) rankingEntrada.readObject();
            rankingEntrada.close();
            return generador;
        }
        catch(IOException | ClassNotFoundException e) {
           //lo creamos pues no hay archivo
            return new GeneradorIDs();
        }
    }
}
