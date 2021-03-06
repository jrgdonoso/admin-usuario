package com.example.demo.controllers;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {



    @Autowired
    private UsuarioDao usuarioDAO;

    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public boolean login(@RequestBody Usuario usuario){
        return this.usuarioDAO.verificaLogin(usuario);

    }

}
