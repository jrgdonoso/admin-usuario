package com.example.demo.dao;

import com.example.demo.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Usuario getUsuario() {
        return null;
    }

    @Override
    public List<Usuario> getUsuarios() {

        String query="FROM Usuario";
        return this.entityManager.createQuery(query).getResultList();

    }

    @Override
    public Usuario setUsuario(Usuario user) {
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
        String hash=argon2.hash(1,1024,1,user.getPassword());
        user.setPassword(hash);

       return  this.entityManager.merge(user);

    }

    @Override
    public Usuario addUsuario(Usuario user) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        System.out.println("Se elimina usuario...");
       Usuario usuario=this.entityManager.find(Usuario.class, id);
       this.entityManager.remove(usuario);
    }

    @Override
    public boolean verificaLogin(Usuario usuario) {
        List<Usuario> usuarios=this.entityManager.createQuery("FROM Usuario WHERE password= :password AND email= :correo")
                .setParameter("password",usuario.getPassword())
                .setParameter("correo", usuario.getEmail())
                .getResultList();



        return !usuarios.isEmpty();
    }
}
