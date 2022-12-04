package com.edukykids.webservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "Jogador")
@Table(name = "Jogador")
public class Jogador {

    // Atributos:

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_JOGADOR_PK", nullable = false)
    private Long id;

    @Column(name = "NOME", length = 10, nullable = false)
    @NotEmpty(message = "O nome do jogador é obrigatório!")
    @Size(min = 1, max = 10, message = "O nome do jogador deve ter entre 1 a 10 caracteres!")
    private String nome;

    @Column(name = "IDADE", nullable = true)
    @Positive(message = "A idade deve ser maior que 0 (zero)!")
    private Integer idade;

    @Column(name = "CELULAR", nullable = false)
    @NotEmpty(message = "O modelo do celular é obrigatório!")
    private String celular;
}
