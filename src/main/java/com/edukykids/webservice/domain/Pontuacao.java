package com.edukykids.webservice.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "Pontuacao")
@Table(name = "Pontuacao")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pontuacao {

    // Atributos:

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PONTUACAO_PK", nullable = false)
    private Long id;

    @Column(name = "PONTUACAO", nullable = false)
    @NotNull(message = "A pontuação é ser obrigatória!")
    private Integer pontuacao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "DATABASE", nullable = false)
    private Date data;

    // Relacionamentos:

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_JOGADOR_FK", referencedColumnName = "ID_JOGADOR_PK", nullable = false)
    @NotNull(message = "O jogador é obrigatório!")
    private Jogador jogador;
}
