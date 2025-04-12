package br.com.isaccanedo.auth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    private String rg;

    private String matricula;

    private String diretoria;

    private String superintendencia;

    private String area;

    private String cargo;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password; // A senha será criptografada

    private String observacao;

    // Outros campos necessários para recuperação de senha (token, data de expiração)
    private String resetPasswordToken;

    private java.time.LocalDateTime resetPasswordTokenExpiry;

    // Construtores, getters e setters (gerados pelo Lombok)
}