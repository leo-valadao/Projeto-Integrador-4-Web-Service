package com.edukykids.webservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edukykids.webservice.domain.PontuacaoJogoMatematica;
import com.edukykids.webservice.service.PontuacaoJogoMatematicaService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pontuacao/jogomatematica")
public class PontuacaoJogoMatematicaResource {

    // Objetos:

    @Autowired
    private PontuacaoJogoMatematicaService pontuacaoJogoMatematicaService;

    // Métodos:

    @RequestMapping(method = RequestMethod.GET, value = "/rank")
    public ResponseEntity<List<PontuacaoJogoMatematica>> obterMaiorPontuacao(
            @RequestParam(name = "quantidade", required = true) Integer quantidade,
            @RequestParam(name = "idJogador", required = false) Long idJogador) {
        List<PontuacaoJogoMatematica> pontuacao = pontuacaoJogoMatematicaService.obterMaiorPontuacao(quantidade, idJogador);

        return ResponseEntity.ok(pontuacao);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<PontuacaoJogoMatematica> obterPorId(@PathVariable("id") Long id) {
        PontuacaoJogoMatematica pontuacao = pontuacaoJogoMatematicaService.obterPorId(id);

        return ResponseEntity.ok(pontuacao);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PontuacaoJogoMatematica> salvarPontuacao(
            @RequestBody @Valid PontuacaoJogoMatematica pontuacao) {
        pontuacaoJogoMatematicaService.salvarPontuacao(pontuacao);

        return ResponseEntity.created(null).body(pontuacao);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<PontuacaoJogoMatematica> excluirPontuacao(@PathVariable("id") Long id) {
        pontuacaoJogoMatematicaService.excluirPontuacao(id);

        return ResponseEntity.noContent().build();
    }
}
