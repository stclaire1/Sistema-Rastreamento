package iftm.edu.br.rastreio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iftm.edu.br.rastreio.Repository.RastreamentoRepository;
import iftm.edu.br.rastreio.model.Rastreamento;

@Service
public class RastreamentoService {

    @Autowired
    RastreamentoRepository repo;

    public Rastreamento buscarRastreamento(Long id) {
        return repo.findById(id).get();
    }

}
