package iftm.edu.br.rastreio.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iftm.edu.br.rastreio.model.Pacote;

@Repository
public interface PacoteRepository extends CrudRepository<Pacote, Long> {
    
}
