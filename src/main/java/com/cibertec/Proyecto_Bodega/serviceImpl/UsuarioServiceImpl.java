package com.cibertec.Proyecto_Bodega.serviceImpl;

import com.cibertec.Proyecto_Bodega.model.bd.Usuario;
import com.cibertec.Proyecto_Bodega.repository.UsuarioRepository;
import com.cibertec.Proyecto_Bodega.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usRepo;



    @Override
    public String findUsuariobyNombre(String nomUs, String pswUs) {
        Usuario obj = usRepo.findByUsnUsAndPswUs(nomUs, pswUs);
        if(obj != null) {
            return "Se ha Iniciado Sesion";
        }else {
            return "No se ha logrado Iniciar Sesion";
        }
    }

    @Override
    public Usuario obtenerUsuarioPorId(long Id) {
        Optional<Usuario> opcional = usRepo.findById(Id);
        Usuario usuario;
        if (opcional.isPresent()) {
            usuario = opcional.get();
        }else {
            throw new RuntimeException("Usuario no encontrado:" + Id);
        }
        return usuario;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        //usuario.setPswUs(bCryptPasswordEncoder.encode(usuario.getPswUs()));
        return usRepo.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usRepo.findAll();
    }

    @Override
    public void eliminarUsuario(long id) {
        usRepo.deleteById(id);
    }
}
