package com.cibertec.Proyecto_Bodega.controller;

import com.cibertec.Proyecto_Bodega.model.bd.Categoria;
import com.cibertec.Proyecto_Bodega.serviceImpl.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    public CategoriaServiceImpl catS;

    @GetMapping("/lista")
    public String listarCategorias(Model model, @Param("keyword") String keyword){
        model.addAttribute("listaCategorias", catS.listarCategorias(keyword));
        return "Categoria/ListaCategoria";
    }

    @GetMapping("/registrarCategoria")
    public String RegistrarCategoria(Model model){
        model.addAttribute("categoria",new Categoria());
            return "Categoria/RegistroCategoria";
    }

    @PostMapping("/guardarCategoria")
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria, Model model){
        try {
            catS.registrarCategoria(categoria);
            model.addAttribute("clasemensaje","alert alert-success");
            model.addAttribute("mensaje","Categoria registrada con exito");
        } catch (Exception e) {
            model.addAttribute("clasemensaje","alert alert-danger");
            model.addAttribute("mensaje","Error al registrar categoria");
        }
        model.addAttribute("listaCategorias", catS.listarCategorias(null));
        return "Categoria/ListaCategoria";
    }

    @PostMapping("/editarCategoria")
    public String editarCategoria(@ModelAttribute("categoria") Categoria categoria, Model model){
        model.addAttribute("categoria", catS.buscarCategoria(categoria.getCodCat()));
        return "Categoria/RegistroCategoria";
    }


    @PostMapping("/eliminarCategoria")
    public String eliminarCategoria(@ModelAttribute Categoria categoria,Model model ){
        try {
            catS.eliminarCategoria(categoria.getCodCat());
            model.addAttribute("clasemensaje","alert alert-success");
            model.addAttribute("mensaje","Categoria eliminada con exito");
        } catch (Exception e) {
            model.addAttribute("clasemensaje","alert alert-danger");
            model.addAttribute("mensaje","Error al eliminar Categoria");
        }

        model.addAttribute("listaCategorias", catS.listarCategorias(null));
        return "Categoria/ListaCategoria";
    }

}
