package uce.edu.apiserverautorizacion.service.to;

import java.io.Serializable;

public class UsuarioTO implements Serializable {
    private String nombre,password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}