package br.edu.infnet.acme.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.acme.model.Cotacao;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Integer> {

    List<Cotacao> findByProdutoId(Integer produtoId);
}

//O metodo findByProdutoId é gerado automaticamente pelo Spring Data!