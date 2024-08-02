package iftm.edu.br.rastreio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iftm.edu.br.rastreio.Repository.PacoteRepository;
import iftm.edu.br.rastreio.model.Pacote;

@Service
public class PacoteService {

    @Autowired
    PacoteRepository repo;

    public Pacote salvarPacote(Pacote pacote) {
        return repo.save(pacote);
    }

    public List<Pacote> listarPacotes() {
        List<Pacote> lista = new ArrayList<Pacote>();
        repo.findAll().forEach(i -> lista.add(i));
        return lista;
    }

    public Pacote buscarPacote(Long id) {
        return repo.findById(id).get();
    }

    public Pacote atualizarPacote(Long id, Pacote pacote) {
        Pacote pacoteExistente = repo.findById(id).get();
        pacoteExistente.setDestinatario(pacote.getDestinatario());
        pacoteExistente.setEndereco(pacote.getEndereco());
        return repo.save(pacoteExistente);
    }

    public void deletarPacote(Long id) {
        repo.deleteById(id);
    }

}