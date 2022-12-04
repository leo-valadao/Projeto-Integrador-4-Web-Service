package com.edukykids.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edukykids.webservice.domain.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
