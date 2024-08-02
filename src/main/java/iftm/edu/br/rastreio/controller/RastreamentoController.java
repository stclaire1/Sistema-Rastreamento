package iftm.edu.br.rastreio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.rastreio.model.Rastreamento;
import iftm.edu.br.rastreio.service.RastreamentoService;

@RestController
@RequestMapping("/rastreamentos")
public class RastreamentoController {

    @Autowired RastreamentoService rastreamentoservice;

    @PostMapping
    public Rastreamento salvarRastreamento(@RequestBody Rastreamento rastreamento) {
        return rastreamentoservice.salvarRastreamento(rastreamento);
    }

    @GetMapping("/{id}")
    public Rastreamento buscarRastreamento(@PathVariable Long id) {
        return rastreamentoservice.buscarRastreamento(id);
    }

}
