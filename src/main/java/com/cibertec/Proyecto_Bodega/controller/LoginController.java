package com.cibertec.Proyecto_Bodega.controller;

import com.cibertec.Proyecto_Bodega.model.bd.Usuario;
import com.cibertec.Proyecto_Bodega.serviceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;
    @GetMapping("/login")
    public String login(){
        return "auth/frmlogin";
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
        return "redirect:/auth/usuario";
    }
    @PostMapping(value = "/login")
    public String ValidacionLogin(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  Model model) {
        String message = usuarioServiceImpl.findUsuariobyNombre(username, password);
        if (message.equals("Se ha Iniciado Sesión")) {
            return "redirect:/usuario";
        } else {
            model.addAttribute("errorMessage", "Usuario o contraseña incorrectos");
            return "auth/login";
        }
    }
}
