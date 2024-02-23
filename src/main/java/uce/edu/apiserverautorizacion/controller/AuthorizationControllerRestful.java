package uce.edu.apiserverautorizacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.apiserverautorizacion.security.JwtUtils;
import uce.edu.apiserverautorizacion.service.to.UsuarioTO;


@RestController
@RequestMapping("autorizaciones")
public class AuthorizationControllerRestful {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtils utils;
    /**
     * Autenticacion
     * Validar que el usuario y el password sean correctos\
     * 
     * @param user
     * @return el token
     */
    @GetMapping(path = "jwt", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String consultarToken(@RequestBody UsuarioTO user){
        this.autenticacion(user.getNombre(),user.getPassword());
        return this.utils.buildTokenJwt(user.getNombre());
    }

    private void autenticacion(String usuario, String password){
        UsernamePasswordAuthenticationToken usuarioToken = new UsernamePasswordAuthenticationToken(usuario, password);
        Authentication auth = this.authManager.authenticate(usuarioToken);
        SecurityContextHolder.getContext().setAuthentication(auth); 
    }

    
}
