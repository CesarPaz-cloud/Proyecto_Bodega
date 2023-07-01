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

    public List<Producto> listarProductos(String keyword){
        if(keyword!=null){
            return prod.findAll(keyword);
        }
        return prod.findAll();
    }

    public void registrarProducto(Producto p){
        prod.save(p);
    }

    public void eliminarProducto(Long codPro){
        prod.deleteById(codPro);
    }

    public Producto buscarProducto(Long codPro){
        Optional<Producto> elemento = prod.findById(codPro);
        Producto p;
        if(!elemento.isEmpty()){
            p = elemento.get();
        }else{
            throw new RuntimeException("Error al Obtener el Producto: "+codPro);
        }
        return p;
    }
}

