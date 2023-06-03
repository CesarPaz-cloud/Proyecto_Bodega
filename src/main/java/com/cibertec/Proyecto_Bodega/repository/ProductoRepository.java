package com.cibertec.Proyecto_Bodega.repository;

import com.cibertec.Proyecto_Bodega.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT p FROM Producto p WHERE p.nom_prod LIKE %?1%"
            + "OR p.ObjM.nomMar LIKE %?1%"
            + "OR p.ObjC.nomCat LIKE %?1%"
            + "OR p.fcvProd LIKE %?1%"
            + "OR p.preProd LIKE %?1%")
    public List<Producto> findAll(String keyword);
}
