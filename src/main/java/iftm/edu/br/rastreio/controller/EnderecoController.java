package iftm.edu.br.rastreio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.rastreio.model.Endereco;
import iftm.edu.br.rastreio.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    // - POST /enderecos - Adiciona um novo endereço.
    // - GET /enderecos - Consulta todos os endereços.

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco salvarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.salvarEndereco(endereco);
    }

    @GetMapping
    public List<Endereco> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }
}
