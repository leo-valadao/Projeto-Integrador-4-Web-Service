package com.edukykids.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edukykids.webservice.domain.PontuacaoJogoMatematica;
import com.edukykids.webservice.repository.PontuacaoJogoMatematicaRepository;

@Service
public class PontuacaoJogoMatematicaService {

    // Objetos:

    @Autowired
    private PontuacaoJogoMatematicaRepository pontuacaoJogoMatematicaRepository;

    // Métodos:

    public List<PontuacaoJogoMatematica> obterMaiorPontuacao(Integer quantidadeRank, Long idJogador) {
        if (!pontuacaoJogoMatematicaRepository.obterMaiorPontuacao(idJogador).isEmpty()) {
            return pontuacaoJogoMatematicaRepository.obterMaiorPontuacao(idJogador).stream().limit(quantidadeRank).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Jogador Não Encontrado! ID: " + idJogador);
        }
    }

    public PontuacaoJogoMatematica obterPorId(Long id) {
        if (pontuacaoJogoMatematicaRepository.existsById(id)) {
            return pontuacaoJogoMatematicaRepository.findById(id).get();
        } else {
            throw new IllegalArgumentException("Pontuação Não Encontrada! ID: " + id);
        }
    }

    public void salvarPontuacao(PontuacaoJogoMatematica pontuacao) {
        pontuacaoJogoMatematicaRepository.save(pontuacao);
    }

    public void excluirPontuacao(Long id) {
        if (pontuacaoJogoMatematicaRepository.existsById(id)) {
            pontuacaoJogoMatematicaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Pontuação Não Encontrada! ID: " + id);
        }
    }
}
