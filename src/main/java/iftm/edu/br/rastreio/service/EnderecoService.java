package iftm.edu.br.rastreio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iftm.edu.br.rastreio.Repository.EnderecoRepository;
import iftm.edu.br.rastreio.model.Endereco;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repo;

    public Endereco salvarEndereco(Endereco endereco) {
        return repo.save(endereco);
    }

    public List<Endereco> listarEnderecos() {
        List<Endereco> lista = new ArrayList<Endereco>();
        repo.findAll().forEach(i -> lista.add(i));
        return lista;
    }

}