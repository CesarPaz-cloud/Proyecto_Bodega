package com.cibertec.Proyecto_Bodega.repository;

import com.cibertec.Proyecto_Bodega.model.bd.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository <Proveedor,Long>{

    @Query("SELECT pr FROM Proveedor pr WHERE pr.nomProv LIKE %?1%"
            + "OR pr.ctcProv LIKE %?1%")
    public List<Proveedor> findAll(String keyword);

}
