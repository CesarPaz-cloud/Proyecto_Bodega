package com.cibertec.Proyecto_Bodega.serviceImpl;

import com.cibertec.Proyecto_Bodega.model.bd.Marca;
import com.cibertec.Proyecto_Bodega.repository.MarcaRepository;
import com.cibertec.Proyecto_Bodega.servicio.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {
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
    public Marca buscarMarca(Long codMarc){
        Optional<Marca> elemento = mrc.findById(codMarc);
        Marca m;
        if(!elemento.isEmpty()){
            m = elemento.get();
        }else{
            throw new RuntimeException("Error al Obtener la Marca: "+codMarc);
        }
        return m;
    }

}
