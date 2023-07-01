package com.cibertec.Proyecto_Bodega.controller;

import com.cibertec.Proyecto_Bodega.model.bd.Marca;
import com.cibertec.Proyecto_Bodega.model.request.MarcaRequest;
import com.cibertec.Proyecto_Bodega.model.response.ResultadoResponse;
import com.cibertec.Proyecto_Bodega.serviceImpl.MarcaServiceImpl;
import com.cibertec.Proyecto_Bodega.servicio.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    public MarcaServiceImpl mrcS;


    @GetMapping("/lista")
    public String frmMantMarca(Model model, @Param("keyword") String keyword){
        model.addAttribute("listaMarcas", mrcS.listarMarcas(keyword));
        return "marca/frmMantMarca";
    }

    @GetMapping("/listarMarcas")
    @ResponseBody
    public List<Marca> listarMarcas(@Param("keyword") String keyword){
        return mrcS.listarMarcas(keyword);
    }

    @PostMapping("/registrarMarca")
    @ResponseBody
    public ResultadoResponse registrarMarca(@RequestBody MarcaRequest marcaRequest){
        String mensaje = "Marca registrada correctamente";
        Boolean respuesta = true;

        try {
            Marca objMarca = new Marca();
            if(marcaRequest.getCodMar()>0){
                objMarca.setCodMar(marcaRequest.getCodMar());
            }
            objMarca.setNomMar(marcaRequest.getNomMar());
            mrcS.registrarMarca(objMarca);
        }catch (Exception e){
            mensaje = "Marca no registrada";
            respuesta=false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminarMarca")
    @ResponseBody
    public ResultadoResponse eliminarMarca(@RequestBody MarcaRequest marcaRequest){
        String mensaje = "Marca eliminada correctamente";
        Boolean respuesta = true;
        try {
            mrcS.eliminarMarca(Long.parseLong(marcaRequest.getCodMar().toString()));
        }catch (Exception e){
            mensaje = "Error al eliminar Marca";
            respuesta=false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta).build();
    }


}
