package com.std.ec.service;

import com.std.ec.model.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public Usuario guardar(Usuario usuario);

    public Usuario buscarId(Integer id);

    public List<Usuario> listar();

    public void eliminar(Usuario usuario);

}
