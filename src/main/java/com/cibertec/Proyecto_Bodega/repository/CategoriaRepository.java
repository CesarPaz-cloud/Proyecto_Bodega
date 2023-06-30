package com.cibertec.Proyecto_Bodega.repository;

import com.cibertec.Proyecto_Bodega.model.bd.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
