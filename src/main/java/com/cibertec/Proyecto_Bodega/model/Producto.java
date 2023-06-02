package com.cibertec.Proyecto_Bodega.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "tb_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPro;
    private String nomPro;
    private Integer codMar;
    private Integer codCat;
    private double prePro;
    private String stkPro;
    private String ubiPro;
    private String fcvPro;

    @ManyToOne
    @JoinColumn(name = "codMar",insertable = false, updatable = false)
    private Marca objMrc;

    @ManyToOne
    @JoinColumn(name = "codCat",insertable = false,updatable = false)
    private Categoria objCat;
}
