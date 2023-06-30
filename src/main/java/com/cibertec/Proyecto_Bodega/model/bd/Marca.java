package com.cibertec.Proyecto_Bodega.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_mrc")
    private Integer codMar;
    @Column(name = "nom_mrc")
    private String nomMar;

    @JsonManagedReference
    @OneToMany (mappedBy = "objMrc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> lproducto = new ArrayList<>();
}
