package com.cibertec.Proyecto_Bodega.serviceImpl;

import com.cibertec.Proyecto_Bodega.model.bd.Proveedor;
import com.cibertec.Proyecto_Bodega.repository.ProveedorRepository;
import com.cibertec.Proyecto_Bodega.servicio.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository prv;

    public List<Proveedor> listarProveedores(String keyword) {
        if(keyword!=null){
            return prv.findAll(keyword);
        }
        return prv.findAll();
    }

    public void registrarProveedor(Proveedor pr){
        prv.save(pr);
    }

    public void eliminarProveedor(Long idProv){
        prv.deleteById(idProv);
    }

    public Proveedor buscarProveedor(Long idProv){
        Optional<Proveedor> elemento = prv.findById(idProv);
        Proveedor pr;
        if(!elemento.isEmpty()){
            pr = elemento.get();
        }else{
            throw new RuntimeException("Error al Obtener el Proveedor: "+idProv);
        }
        return pr;
    }

}
