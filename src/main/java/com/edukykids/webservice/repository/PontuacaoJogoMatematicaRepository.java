package com.edukykids.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edukykids.webservice.domain.PontuacaoJogoMatematica;

@Repository
public interface PontuacaoJogoMatematicaRepository extends JpaRepository<PontuacaoJogoMatematica, Long> {

        @Query(value = "SELECT p "
                        + " FROM PontuacaoJogoMatematica p "
                        + " INNER JOIN p.jogador j "
                        + " WHERE (:idJogador IS NULL OR j.id = :idJogador) "
                        + " ORDER BY p.pontuacao DESC")
        List<PontuacaoJogoMatematica> obterMaiorPontuacao(@Param("idJogador") Long idJogador);
}
