package com.cibertec.Proyecto_Bodega.repository;

import com.cibertec.Proyecto_Bodega.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsnUsAndPswUs(String usnUs, String pswUs);
}
