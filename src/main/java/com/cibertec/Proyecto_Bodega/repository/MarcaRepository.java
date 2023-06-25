package com.cibertec.Proyecto_Bodega.repository;

import com.cibertec.Proyecto_Bodega.model.bd.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Integer> {
    @Query("SELECT m FROM Marca m WHERE m.nomMar LIKE %?1%")
    public List<Marca> findAll(String keyword);
}
