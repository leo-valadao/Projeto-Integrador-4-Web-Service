package com.edukykids.webservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edukykids.webservice.domain.Jogador;
import com.edukykids.webservice.service.JogadorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/jogador")
public class JogadorResource {

    // Objetos:

    @Autowired
    private JogadorService jogadorService;

    // Métodos:

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Jogador> obterPorId(@PathVariable("id") Long id) {
        Jogador jogador = jogadorService.obterPorId(id);

        return ResponseEntity.ok(jogador);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Jogador> salvarJogador(@RequestBody @Valid Jogador jogador) {
        jogadorService.salvarJogador(jogador);

        return ResponseEntity.created(null).body(jogador);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Jogador> excluirJogador(@PathVariable("id") Long id) {
        jogadorService.excluirJogador(id);

        return ResponseEntity.noContent().build();
    }
}
