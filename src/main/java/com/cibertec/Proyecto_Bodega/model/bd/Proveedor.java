package com.cibertec.Proyecto_Bodega.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_prv")
    private long codProv;
    @Column(name = "nom_prv")
    private String nomProv;
    @Column(name = "ctc_prv")
    private String ctcProv;
    @Column(name = "tlf_prv")
    private String tlfProv;
    @Column(name = "email_prv")
    private String emlProv;


    @JsonManagedReference
    @OneToMany (mappedBy = "objPrv", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> lproducto = new ArrayList<>();
}
