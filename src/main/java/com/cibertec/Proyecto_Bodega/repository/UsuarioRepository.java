package com.cibertec.Proyecto_Bodega.repository;

import com.cibertec.Proyecto_Bodega.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository {
    Usuario findByEmail(String email);
    Usuario findByNomUsuario(String usnUs);
}
