package br.edu.infnet.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.acme.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
//entidade Produto herda os metodos save, find, delete...