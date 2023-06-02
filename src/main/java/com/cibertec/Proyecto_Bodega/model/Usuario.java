package com.cibertec.Proyecto_Bodega.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codUs;
    @Column(name = "nom_usu")
    private String nomUs;
    @Column(name = "ape_usu")
    private String apeUs;
    @Column(name = "email_usu")
    private String email;
    @Column(name = "usn_usu")
    private String usnUs;
    @Column(name = "psn_usu")
    private String psnUs;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "tb_usuario_rol", joinColumns = @JoinColumn(name = "idUs"),
                inverseJoinColumns = @JoinColumn(name = "idRol"))
    private Set<Rol> roles;
}
