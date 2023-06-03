package com.cibertec.Proyecto_Bodega.servicio;

import com.cibertec.Proyecto_Bodega.model.Producto;
import com.cibertec.Proyecto_Bodega.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository prod;

    public List<Producto> productoList(String keyword){
        if (keyword!=null) {
          return  prod.findAll(keyword);
        }
        return prod.findAll();
    }
}

