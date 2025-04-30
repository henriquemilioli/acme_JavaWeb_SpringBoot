package br.edu.infnet.acme.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.edu.infnet.acme.model.Cotacao;
import br.edu.infnet.acme.repository.CotacaoRepository;

@Service
public class CotacaoServiceImpl implements CotacaoService {

    @Autowired
    private CotacaoRepository repo;

    @Override
    @Transactional(readOnly = true)
    public List<Cotacao> listarPorProduto(Integer produtoId) {
        return repo.findByProdutoId(produtoId);
    }

    @Override
    @Transactional(readOnly = true)
    public Cotacao buscarPorId(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cotação não encontrada: " + id));
    }

    @Override
    @Transactional
    public Cotacao salvar(Cotacao cotacao) {
        return repo.save(cotacao);
    }

    @Override
    @Transactional
    public void excluir(Integer id) {
        repo.deleteById(id);
    }

}
