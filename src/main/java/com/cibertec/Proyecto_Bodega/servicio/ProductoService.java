package com.cibertec.Proyecto_Bodega.servicio;

import com.cibertec.Proyecto_Bodega.model.bd.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listarProductos();

    Producto obtenerProductoPorId(long idProd);

   void  guardarProducto(Producto producto);

    void eliminarProducto(long idProd);
}
