package com.example.demo.controllers;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.models.Usuario;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDAO;

    @RequestMapping(value="api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable  Integer id){

        System.out.println("Usuario ID "+id.intValue());
        Usuario usuario=new Usuario();

        usuario.setId(id.intValue());
        usuario.setNombre("Jorge");
        usuario.setApellido("Donoso");
        usuario.setEmail("jrg.donoso@gmail.com");
        usuario.setPassword("123456");
        usuario.setTelefono("973650927");

        return usuario;
    }


    @RequestMapping(value="api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){

        List<Usuario> usuarios=usuarioDAO.getUsuarios();

        System.out.println(usuarios);
        return usuarios;

    }




    @RequestMapping(value="api/usuario", method = RequestMethod.POST)
    public Usuario setUsuarios(@RequestBody Usuario user){

        System.out.println("POST mapping");

        Usuario usuario=this.usuarioDAO.setUsuario(user);
        System.out.println(usuario);
        return usuario;
    }





    @RequestMapping(value="api/usuario/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable int id){
        System.out.println("cotroller elimina usuario...");
        this.usuarioDAO.deleteById(id);
    }

}
