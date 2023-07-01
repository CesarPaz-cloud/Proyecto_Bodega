package com.cibertec.Proyecto_Bodega.servicio;

import com.cibertec.Proyecto_Bodega.model.bd.Marca;

import java.util.List;

public interface MarcaService {

    List<Marca> listarMarcas(String keyword);

    public void registrarMarca(Marca m);

    public void eliminarMarca(Long codMarc);

    public Marca buscarMarca(Long codMarc);

}
