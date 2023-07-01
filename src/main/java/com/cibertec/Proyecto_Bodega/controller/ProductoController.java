package com.cibertec.Proyecto_Bodega.controller;


import com.cibertec.Proyecto_Bodega.model.bd.Producto;
import com.cibertec.Proyecto_Bodega.serviceImpl.CategoriaServiceImpl;
import com.cibertec.Proyecto_Bodega.serviceImpl.MarcaServiceImpl;
import com.cibertec.Proyecto_Bodega.serviceImpl.ProductoServiceImpl;
import com.cibertec.Proyecto_Bodega.serviceImpl.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    public ProductoServiceImpl prodS;
    @Autowired
    public MarcaServiceImpl mrcS;
    @Autowired
    public CategoriaServiceImpl catS;
    @Autowired
    public ProveedorServiceImpl prvS;

    @GetMapping("/lista")
    public String listarProductos(Model model, @Param("keyword") String keyword){
        model.addAttribute("listaProductos", prodS.listarProductos(keyword));
        return "Producto/ListaProducto";
    }

    @GetMapping("/registrarProducto")
    public String RegistrarProducto(Model model){
        model.addAttribute("producto",new Producto());
        model.addAttribute("listaMarcas", mrcS.listarMarcas(null));
        model.addAttribute("listaCategorias", catS.listarCategorias(null));
        model.addAttribute("listaProveedores", prvS.listarProveedores(null));
        return "Producto/RegistroProducto";
    }

    @PostMapping("/guardarProducto")
    public String guardarProducto(Model model, @ModelAttribute("producto") Producto producto){
        try {
            prodS.registrarProducto(producto);
            model.addAttribute("clasemensaje","alert alert-success");
            model.addAttribute("mensaje","Producto registrado con exito");
        } catch (Exception e) {
            model.addAttribute("clasemensaje","alert alert-danger");
            model.addAttribute("mensaje","Error al registrar Producto");
        }
        model.addAttribute("listaMarcas", mrcS.listarMarcas(null));
        model.addAttribute("listaCategorias", catS.listarCategorias(null));
        model.addAttribute("listaProveedores", prvS.listarProveedores(null));
        return "Producto/RegistroProducto";
    }

    @PostMapping("/editarProducto")
    public String editarProducto(@ModelAttribute("producto") Producto producto, Model model){
        model.addAttribute("producto", prodS.buscarProducto(producto.getCodPro()));
        model.addAttribute("listaMarcas", mrcS.listarMarcas(null));
        model.addAttribute("listaCategorias", catS.listarCategorias(null));
        model.addAttribute("listaProveedores", prvS.listarProveedores(null));
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
