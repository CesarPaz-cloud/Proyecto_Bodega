package com.cibertec.Proyecto_Bodega.serviceImpl;

import com.cibertec.Proyecto_Bodega.model.bd.Marca;
import com.cibertec.Proyecto_Bodega.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository mrc;

    public List<Marca> listarMarcas(String keyword){
        if(keyword!=null){
            return mrc.findAll(keyword);
        }
        return mrc.findAll();
    }

    public void registrarMarca(Marca m){
        mrc.save(m);
    }

    public void eliminarMarca(Long codMarc){
        mrc.deleteById(codMarc);
    }
}
