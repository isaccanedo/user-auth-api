package br.com.isaccanedo.auth.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(length = 11, unique = true)
    private String cpf;

    private String rg;

    private String matricula;

    private String diretoria;

    private String superintendencia;

    private String area;

    private String cargo;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(length = 1000)
    private String observacao;
}