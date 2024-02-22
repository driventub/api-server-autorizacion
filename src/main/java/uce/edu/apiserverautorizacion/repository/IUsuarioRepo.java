package uce.edu.apiserverautorizacion.repository;

import uce.edu.apiserverautorizacion.modelo.Usuario;

public interface IUsuarioRepo {
    public Usuario consultarPorNombre(String nombre);
    
}
