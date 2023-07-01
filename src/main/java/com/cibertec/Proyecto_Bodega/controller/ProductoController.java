package com.cibertec.Proyecto_Bodega.controller;


import com.cibertec.Proyecto_Bodega.model.bd.Producto;
import com.cibertec.Proyecto_Bodega.serviceImpl.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produdcto")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl prodS;

    @GetMapping("/lista")
    public String listarProductos(Model model, @Param("keyword") String keyword){
        model.addAttribute("listaProductos", prodS.listarProductos(keyword));
        return "Producto/ListaProducto";
    }

    @GetMapping("/registrarProducto")
    public String RegistrarProducto(Model model){
        model.addAttribute("producto",new Producto());
        return "Producto/RegistroProducto";
    }

    @PostMapping("/guardarProducto")
    public String guardarProducto(@ModelAttribute("producto") Producto producto, Model model){
        try {
            prodS.registrarProducto(producto);
            model.addAttribute("clasemensaje","alert alert-success");
            model.addAttribute("mensaje","Producto registrado con exito");
        } catch (Exception e) {
            model.addAttribute("clasemensaje","alert alert-danger");
            model.addAttribute("mensaje","Error al registrar Producto");
        }
        model.addAttribute("listaProductos", prodS.listarProductos(null));
        return "Producto/ListaProducto";
    }

    @PostMapping("/editarProducto")
    public String editarProducto(@ModelAttribute("producto") Producto producto, Model model){
        model.addAttribute("producto", prodS.buscarProducto(producto.getCodPro()));
        return "Producto/RegistroProducto";
    }


    @PostMapping("/eliminarProducto")
    public String eliminarProducto(@ModelAttribute Producto producto,Model model ){
        try {
            prodS.eliminarProducto(producto.getCodPro());
            model.addAttribute("clasemensaje","alert alert-success");
            model.addAttribute("mensaje","Producto eliminado con exito");
        } catch (Exception e) {
            model.addAttribute("clasemensaje","alert alert-danger");
            model.addAttribute("mensaje","Error al eliminar Producto");
        }

        model.addAttribute("listaProductos", prodS.listarProductos(null));
        return "Producto/ListaProducto";
    }

}
