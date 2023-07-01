package com.cibertec.Proyecto_Bodega.servicio;

import com.cibertec.Proyecto_Bodega.model.bd.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> listarProductos(String keyword);

    public void registrarProducto(Producto p);

    public void eliminarProducto(Long codPro);

    public Producto buscarProducto(Long codPro);
}
