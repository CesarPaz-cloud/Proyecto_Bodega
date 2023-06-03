package com.cibertec.Proyecto_Bodega.servicio;

import com.cibertec.Proyecto_Bodega.model.Rol;
import com.cibertec.Proyecto_Bodega.model.Usuario;
import com.cibertec.Proyecto_Bodega.repository.RolRepository;
import com.cibertec.Proyecto_Bodega.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usRepo;

    @Autowired
    private RolRepository rolRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public Usuario buscarUsuarioPorEmail(String email){
        return usRepo.findByEmail(email);
    }
    public Usuario buscarUsuarioPorNombreUsuario(String usnUs){
        return usRepo.findByNomUsuario(usnUs);
    }
    public Usuario guardarUsuario(Usuario usuario){
        usuario.setPsnUs(bCryptPasswordEncoder.encode(usuario.getPsnUs()));
        Rol rol = rolRepo.findByNomRol("ADMIN");
        usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol)));
        return (Usuario) usRepo.save(usuario);
    }
}
