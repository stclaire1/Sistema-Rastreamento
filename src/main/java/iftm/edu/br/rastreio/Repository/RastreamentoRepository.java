package iftm.edu.br.rastreio.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iftm.edu.br.rastreio.model.Rastreamento;

@Repository
public interface RastreamentoRepository extends CrudRepository<Rastreamento, Long> {
    
}
