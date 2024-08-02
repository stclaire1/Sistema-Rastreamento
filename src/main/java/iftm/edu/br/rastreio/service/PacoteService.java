package iftm.edu.br.rastreio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iftm.edu.br.rastreio.Repository.PacoteRepository;
import iftm.edu.br.rastreio.model.Endereco;
import iftm.edu.br.rastreio.model.Pacote;

@Service
public class PacoteService {

    @Autowired
    PacoteRepository repo;

    @Autowired
    EnderecoService enderecoRepo;

    public Pacote salvarPacote(Pacote pacote) {
        Endereco enderecoCompleto = enderecoRepo.findById(pacote.getEndereco().getId());
        pacote.setEndereco(enderecoCompleto);
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
    pacoteExistente.setStatus(pacote.getStatus());

    Endereco enderecoCompleto = enderecoRepo.findById(pacote.getEndereco().getId());
    pacoteExistente.setEndereco(enderecoCompleto);
    return repo.save(pacoteExistente);
}

    public void deletarPacote(Long id) {
        repo.deleteById(id);
    }

}