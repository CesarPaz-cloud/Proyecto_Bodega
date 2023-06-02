package com.cibertec.Proyecto_Bodega.repository;

import com.cibertec.Proyecto_Bodega.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByNomRol(String nomRol);
}
