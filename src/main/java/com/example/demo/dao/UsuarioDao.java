package com.example.demo.dao;

import com.example.demo.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    Usuario getUsuario();
    List<Usuario> getUsuarios();
    Usuario setUsuario(Usuario user);
    Usuario addUsuario(Usuario user);
    void deleteById(int id);
    boolean verificaLogin(Usuario usuario);

}
