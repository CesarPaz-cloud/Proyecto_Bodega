package com.cibertec.Proyecto_Bodega.model.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarcaRequest {

    private Integer codMar;
    private String nomMar;
}
