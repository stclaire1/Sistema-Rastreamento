package iftm.edu.br.rastreio.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iftm.edu.br.rastreio.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
    
}
