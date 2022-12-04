package com.edukykids.webservice.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "PontuacaoJogoMatematica")
@Table(name = "PontuacaoJogoMatematica")
@Inheritance(strategy = InheritanceType.JOINED)
public class PontuacaoJogoMatematica extends Pontuacao implements Serializable {

    // Atributos:

    @Column(name = "ACERTOS", nullable = false)
    @Positive(message = "A quantidade de exercícios resolvidos deve ser positiva!")
    @NotNull(message = "A quantidade de exercícios resolvidos é obrigatória!")
    private Integer acertos;

    @Column(name = "ERROS", nullable = false)
    @Positive(message = "A quantidade de exercícios errados deve ser positiva!")
    @NotNull(message = "A quantidade de exercícios errados é obrigatória!")
    private Integer erros;
}
