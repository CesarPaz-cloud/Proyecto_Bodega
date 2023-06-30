package com.cibertec.Proyecto_Bodega.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @Column(name="cod_usu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codUs;
    @Column(name = "nom_usu")
    private String nomUs;
    @Column(name = "ape_usu")
    private String apeUs;
    @Column(name = "email_usu")
    private String email;
    @Column(name = "usn_usu")
    private String usnUs;
    @Column(name = "psw_usu")
    private String pswUs;

}
