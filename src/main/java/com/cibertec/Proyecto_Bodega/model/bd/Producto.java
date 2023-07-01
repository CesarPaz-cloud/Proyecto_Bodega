package com.cibertec.Proyecto_Bodega.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "tb_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_prod")
    private long codPro;
    @Column(name = "nom_prod")
    private String nomPro;
    @Column(name = "cod_mrc")
    private long codMar;
    @Column(name = "cod_cat")
    private long codCat;
    @Column(name = "pre_prod")
    private double prePro;
    @Column(name = "stk_prod")
    private String stkPro;
    @Column(name = "ubi_prod")
    private String ubiPro;
    @Column(name = "fcv_prod")
    private String fcvPro;
    @Column (name="cod_prv")
    private long codProv;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cod_mrc",insertable = false, updatable = false)
    private Marca objMrc;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cod_cat",insertable = false,updatable = false)
    private Categoria objCat;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cod_prv",insertable = false,updatable = false)
    private Proveedor objPrv;
}
