package com.cibertec.Proyecto_Bodega.servicio;

import com.cibertec.Proyecto_Bodega.model.bd.Proveedor;

import java.util.List;

public interface ProveedorService {

    public List<Proveedor> listarProveedores(String keyword);

    public void registrarProveedor(Proveedor prv);

    public void eliminarProveedor(Long idProv);

    public Proveedor buscarProveedor(Long idProv);
}
