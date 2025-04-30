package br.edu.infnet.acme.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.edu.infnet.acme.model.Produto;
import br.edu.infnet.acme.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    @Override
    @Transactional(readOnly = true)
    public List<Produto> listarTodos() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Produto obterPorId(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + id));
    }

    @Override
    @Transactional
    public Produto salvar(Produto produto) {
        return repo.save(produto);
    }

    @Override
    @Transactional
    public void excluir(Integer id) {
        repo.deleteById(id);
    }
}
