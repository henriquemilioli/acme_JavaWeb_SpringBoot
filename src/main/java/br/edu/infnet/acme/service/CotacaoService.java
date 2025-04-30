package br.edu.infnet.acme.service;

import java.util.List;
import  br.edu.infnet.acme.model.Cotacao;

public interface CotacaoService {
    List<Cotacao> listarPorProduto(Integer ProdutoId);
    Cotacao buscarPorId(Integer id);
    Cotacao salvar(Cotacao cotacao);
    void excluir(Integer id);

}
