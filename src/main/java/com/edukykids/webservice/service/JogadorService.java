package com.edukykids.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edukykids.webservice.domain.Jogador;
import com.edukykids.webservice.repository.JogadorRepository;

@Service
public class JogadorService {

    // Objetos:

    @Autowired
    private JogadorRepository jogadorRepository;

    // Métodos:

    public List<Jogador> obterTodosJogadores() {
        return jogadorRepository.findAll();
    }

    public Jogador obterPorId(Long id) {
        if (jogadorRepository.existsById(id)) {
            return jogadorRepository.findById(id).get();
        } else {
            throw new IllegalArgumentException("Jogador Não Encontrado! ID: " + id);
        }
    }

    public void salvarJogador(Jogador jogador) {
        jogadorRepository.save(jogador);
    }

    public void atualizarJogador(Jogador jogador) {
        if (jogadorRepository.existsById(jogador.getId())) {
            jogadorRepository.save(jogador);
        } else {
            throw new IllegalArgumentException("Jogador Não Encontrado! ID: " + jogador.getId());
        }
    }

    public void excluirJogador(Long id) {
        if (jogadorRepository.existsById(id)) {
            jogadorRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Jogador Não Encontrado! ID: " + id);
        }
    }
}
