package com.std.ec.controller;

import com.std.ec.model.entity.Usuario;
import com.std.ec.service.IUsuarioService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Component(value = "usuarioMB")
@ViewScoped
public class UsuarioController implements Serializable {

    @Autowired
    private IUsuarioService usuarioService;

    private Usuario usuario;
    private List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        return usuarios = usuarioService.listar();
    }

    public void nuevo(){
        usuario = new Usuario();
    }

    public void guardar(){
        if (usuario.getIdUsuario() == null){
            usuarioService.guardar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guardado"));
        }else{
            usuarioService.guardar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guardado"));
        }
        nuevo();
        PrimeFaces.current().ajax().update("form:messages", "form:dt-usuarios");
        PrimeFaces.current().executeScript("PF('dlgUsuario').hide();");
    }

    public void eliminar(){
        usuarioService.eliminar(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-usuarios");

    }

}
