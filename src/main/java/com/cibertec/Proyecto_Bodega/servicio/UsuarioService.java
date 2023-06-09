package com.cibertec.Proyecto_Bodega.servicio;

import com.cibertec.Proyecto_Bodega.model.bd.Usuario;

import java.util.List;

public interface UsuarioService {

    String findUsuariobyNombre(String nomUs, String pswUs);

    Usuario obtenerUsuarioPorId(Integer Id);

    Usuario guardar(Usuario usuario);

    List<Usuario> listarUsuario();

    void eliminarUsuario(Integer id);
}
