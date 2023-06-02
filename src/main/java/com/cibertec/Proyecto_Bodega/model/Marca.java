package com.cibertec.Proyecto_Bodega.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codMar;
    @Column(name = "nom_mrc")
    private String nomMar;
}
