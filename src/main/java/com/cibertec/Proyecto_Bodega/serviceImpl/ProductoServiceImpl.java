package com.cibertec.Proyecto_Bodega.serviceImpl;

import com.cibertec.Proyecto_Bodega.model.bd.Producto;
import com.cibertec.Proyecto_Bodega.repository.ProductoRepository;
import com.cibertec.Proyecto_Bodega.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository prod;


    @Override
    public List<Producto> listarProductos() {
        return prod.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(long idProd) {
        Optional<Producto> opcional = prod.findById(idProd);
        Producto producto;
        if (opcional.isPresent()){
            producto = opcional.get();
        }else {
            throw new RuntimeException("Producto no encontrado por el Id"+ idProd);
        }
        return producto;
    }

    @Override
    public void guardarProducto(Producto producto) {
         prod.save(producto);
    }

    @Override
    public void eliminarProducto(long idProd) {
        prod.deleteById(idProd);
    }
}

