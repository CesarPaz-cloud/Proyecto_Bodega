package com.cibertec.Proyecto_Bodega.controller;

import com.cibertec.Proyecto_Bodega.model.bd.Proveedor;
import com.cibertec.Proyecto_Bodega.serviceImpl.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    public ProveedorServiceImpl prvS;

    @GetMapping("/lista")
    public String listarProveedores(Model model, @Param("keyword") String keyword){
        model.addAttribute("listaProveedores", prvS.listarProveedores(keyword));
        return "Proveedor/ListaProveedor";
    }

    @GetMapping("/registrarProveedor")
    public String RegistrarProveedor(Model model){
        model.addAttribute("proveedor",new Proveedor());
        return "Proveedor/RegistroProveedor";
    }

    @PostMapping("/guardarProveedor")
    public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor, Model model){
        try {
            prvS.registrarProveedor(proveedor);
            model.addAttribute("clasemensaje","alert alert-success");
            model.addAttribute("mensaje","Proveedor registrado con exito");
        } catch (Exception e) {
            model.addAttribute("clasemensaje","alert alert-danger");
            model.addAttribute("mensaje","Error al registrar Proveedor");
        }
        model.addAttribute("listaProveedores", prvS.listarProveedores(null));
        return "Proveedor/ListaProveedor";
    }

    @PostMapping("/editarProveedor")
    public String editarProveedor(@ModelAttribute("proveedor") Proveedor proveedor, Model model){
        model.addAttribute("proveedor", prvS.buscarProveedor(proveedor.getCodProv()));
        return "Proveedor/RegistroProveedor";
    }


    @PostMapping("/eliminarProveedor")
    public String eliminarProveedor(@ModelAttribute Proveedor proveedor,Model model ){
        try {
            prvS.eliminarProveedor(proveedor.getCodProv());
            model.addAttribute("clasemensaje","alert alert-success");
            model.addAttribute("mensaje","Proveedor eliminado con exito");
        } catch (Exception e) {
            model.addAttribute("clasemensaje","alert alert-danger");
            model.addAttribute("mensaje","Error al eliminar Proveedor");
        }

        model.addAttribute("listaProveedores", prvS.listarProveedores(null));
        return "Proveedor/ListaProveedor";
    }
}
