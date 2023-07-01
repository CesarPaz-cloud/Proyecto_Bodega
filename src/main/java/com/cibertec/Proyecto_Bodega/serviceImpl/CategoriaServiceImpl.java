package com.cibertec.Proyecto_Bodega.serviceImpl;

import com.cibertec.Proyecto_Bodega.model.bd.Categoria;
import com.cibertec.Proyecto_Bodega.repository.CategoriaRepository;
import com.cibertec.Proyecto_Bodega.servicio.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository cat;
    public List<Categoria> listarCategorias(String keyword){
        if(keyword!=null){
            return cat.findAll(keyword);
        }
        return cat.findAll();
    }

    public void registrarCategoria(Categoria c){
        cat.save(c);
    }

    public void eliminarCategoria(Long codCat){
        cat.deleteById(codCat);
    }

    public Categoria buscarCategoria(Long codCat){
        Optional<Categoria> elemento = cat.findById(codCat);
        Categoria c;
        if(!elemento.isEmpty()){
            c = elemento.get();
        }else{
            throw new RuntimeException("Error al Obtener la Categoria: "+codCat);
        }
        return c;
    }
}
