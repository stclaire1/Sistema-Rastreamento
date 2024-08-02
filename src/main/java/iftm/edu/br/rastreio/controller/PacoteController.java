package iftm.edu.br.rastreio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.rastreio.model.Pacote;
import iftm.edu.br.rastreio.service.PacoteService;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    // - POST /pacotes - Adiciona um novo pacote.
    // - GET /pacotes - Consulta todos os pacotes.
    // - GET /pacotes/{id} - Consulta um pacote específico.
    // - PUT /pacotes/{id} - Atualiza as informações de um pacote.
    // - DELETE /pacotes/{id} - Remove um pacote.
    
    @Autowired
    private PacoteService pacoteService;

    @PostMapping
    public Pacote salvarPacote(@RequestBody Pacote pacote) {
        return pacoteService.salvarPacote(pacote);
    }

    @GetMapping
    public List<Pacote> listarPacotes() {
        return pacoteService.listarPacotes();
    }

    @GetMapping("/{id}")
    public Pacote buscarPacote(@PathVariable Long id) {
        return pacoteService.buscarPacote(id);
    }

    @PutMapping("/{id}")
    public Pacote atualizarPacote(@PathVariable Long id, @RequestBody Pacote pacote) {
        return pacoteService.atualizarPacote(id, pacote);
    }

    @DeleteMapping("/{id}")
    public void deletarPacote(@PathVariable Long id) {
        pacoteService.deletarPacote(id);
    }
}
