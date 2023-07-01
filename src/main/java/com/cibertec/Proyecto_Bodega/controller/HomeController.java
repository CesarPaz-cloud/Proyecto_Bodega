package com.cibertec.Proyecto_Bodega.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/inicio")
    public String cargarHome(){
        return "Home";
    }

}
