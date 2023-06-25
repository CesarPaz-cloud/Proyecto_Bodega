package com.cibertec.Proyecto_Bodega.repository;

import com.cibertec.Proyecto_Bodega.model.bd.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT p FROM Producto p WHERE p.nomPro LIKE %?1%"
            + "OR p.objMrc.nomMar LIKE %?1%"
            + "OR p.objCat.nomCat LIKE %?1%"
            + "OR p.fcvPro LIKE %?1%"
            + "OR p.prePro LIKE %?1%")
    public List<Producto> findAll(String keyword);
}
