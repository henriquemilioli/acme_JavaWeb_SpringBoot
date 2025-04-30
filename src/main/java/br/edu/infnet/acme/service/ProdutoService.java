package br.edu.infnet.acme.service;

import java.util.List;
import br.edu.infnet.acme.model.Produto;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface ProdutoService {
    List<Produto> listarTodos();
    Produto obterPorId(Integer id);
    Produto salvar(Produto produto);
    void excluir(Integer id);
}
