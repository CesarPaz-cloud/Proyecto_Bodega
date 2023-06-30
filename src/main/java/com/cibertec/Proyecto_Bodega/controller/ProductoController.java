package com.cibertec.Proyecto_Bodega.controller;

import com.cibertec.Proyecto_Bodega.model.bd.Producto;
import com.cibertec.Proyecto_Bodega.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produdcto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/lista")
    public String ListaProducto(Model model){
        model.addAttribute("listaProducto",productoService.listarProductos());
        return "producto/lista";
    }
    @GetMapping("/nuevoProducto")
    public String nuevoProducto(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "producto/nuevoProducto";
    }
    @PostMapping("/guardarProducto")
    public String guardarEncargdo(@ModelAttribute("producto") Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/producto";
    }
    @GetMapping("/actualizarProducto/{id}")
    public String actualizarProducto(@PathVariable(value = "id") long id, Model model){
        Producto producto = productoService.obtenerProductoPorId(id);
        model.addAttribute("producto", producto);
        return  "producto/actualizarProducto";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable(value = "id") long id){
        productoService.eliminarProducto(id);
        return "redirect:/producto/lista";
    }
}
