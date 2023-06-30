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
@Table(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cat")
    private Integer idCat;
    @Column(name = "nom_cat")
    private String nomCat;

    @JsonManagedReference
    @OneToMany (mappedBy = "objCat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> lproducto = new ArrayList<>();
}
