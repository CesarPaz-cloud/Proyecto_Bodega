package com.cibertec.Proyecto_Bodega.servicio;

import com.cibertec.Proyecto_Bodega.model.bd.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> listarCategorias(String keyword);

    public void registrarCategoria(Categoria c);

    public void eliminarCategoria(Long codCat);

    public Categoria buscarCategoria(Long codCat);
}
