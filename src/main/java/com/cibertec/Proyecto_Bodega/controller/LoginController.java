package com.cibertec.Proyecto_Bodega.controller;

import com.cibertec.Proyecto_Bodega.model.bd.Usuario;
import com.cibertec.Proyecto_Bodega.serviceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;
    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("/usuario")
    public String usuarioLista(Model model) {
        model.addAttribute("listaUsuario",usuarioServiceImpl.listarUsuario());
        return "auth/usuario";
    }

    @GetMapping("/registrar")
    public String registrar(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "auth/registrar";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        usuarioServiceImpl.guardar(usuario);
        return "auth/login";
    }
}
