package com.cibertec.Proyecto_Bodega.controller;

import com.cibertec.Proyecto_Bodega.model.bd.Marca;
import com.cibertec.Proyecto_Bodega.serviceImpl.MarcaServiceImpl;
import com.cibertec.Proyecto_Bodega.servicio.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    public MarcaServiceImpl mrcS;


    @GetMapping("/lista")
    public String listarMarcas(Model model, @Param("keyword") String keyword){
        model.addAttribute("listaMarcas", mrcS.listarMarcas(keyword));
        return "Marca/ListaMarca";
    }

    @GetMapping("/registrarMarca")
    public String RegistrarMarca(Model model){
        model.addAttribute("marca",new Marca());
        return "Marca/RegistroMarca";
    }

    @PostMapping("/guardarNarca")
    public String guardarMarca(@ModelAttribute("marca") Marca marca, Model model){
        try {
            mrcS.registrarMarca(marca);
            model.addAttribute("clasemensaje","alert alert-success");
            model.addAttribute("mensaje","Marca registrada con exito");
        } catch (Exception e) {
            model.addAttribute("clasemensaje","alert alert-danger");
            model.addAttribute("mensaje","Error al registrar marca");
        }
        model.addAttribute("listaMarcas", mrcS.listarMarcas(null));
        return "Marca/ListaMarca";
    }

    @PostMapping("/editarMarca")
    public String editarMarca(@ModelAttribute("marca") Marca marca, Model model){
        model.addAttribute("marca", mrcS.buscarMarca(marca.getCodMar()));
        return "Marca/RegistroMarca";
    }


    @PostMapping("/eliminarMarca")
    public String eliminarMarca(@ModelAttribute Marca marca,Model model ){
        try {
            mrcS.eliminarMarca(marca.getCodMar());
            model.addAttribute("clasemensaje","alert alert-success");
            model.addAttribute("mensaje","Marca eliminada con exito");
        } catch (Exception e) {
            model.addAttribute("clasemensaje","alert alert-danger");
            model.addAttribute("mensaje","Error al eliminar marca");
        }

        model.addAttribute("listaMarcas", mrcS.listarMarcas(null));
        return "Marca/ListaMarca";
    }



}
