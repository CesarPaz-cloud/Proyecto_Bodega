package com.cibertec.Proyecto_Bodega.servicio;

import com.cibertec.Proyecto_Bodega.model.Marca;
import com.cibertec.Proyecto_Bodega.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository mrc;

    public List<Marca> findAll(String keyword){
        if(keyword!=null){
            return mrc.findAll(keyword);
        }
        return mrc.findAll();
    }
}
