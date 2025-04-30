package br.edu.infnet.acme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.edu.infnet.acme.model.Cotacao;
import br.edu.infnet.acme.model.Produto;
import br.edu.infnet.acme.service.CotacaoService;
import br.edu.infnet.acme.service.ProdutoService;

@Controller
@RequestMapping("/cotacoes")
public class CotacaoController {

    @Autowired
    private CotacaoService cotacaoService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produto/{produtoId}") // JSP: /WEB-INF/views/cotacao/lista.jsp
    public String listarPorProduto(@PathVariable Integer produtoId, Model model) {
        Produto p = produtoService.obterPorId(produtoId);
        List<Cotacao> lista = cotacaoService.listarPorProduto(produtoId);
        model.addAttribute("produto", p);
        model.addAttribute("cotacoes", lista);
        return "cotacao/lista";
    }

    @PostMapping("/salvar")
    public String salvar(
            @Valid @ModelAttribute Cotacao cotacao,
            BindingResult binding,
            RedirectAttributes redirect) {

        if (binding.hasErrors()) {
            return "cotacao/form";
        }
        cotacaoService.salvar(cotacao);
        redirect.addFlashAttribute("sucesso", "Cotação salva!");
        // redireciona para a lista do mesmo produto
        return "redirect:/cotacoes/produto/"
                + cotacao.getProduto().getId();
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id,
                          RedirectAttributes redirect) {

        Cotacao c = cotacaoService.buscarPorId(id);
        Integer pid = c.getProduto().getId();
        cotacaoService.excluir(id);
        redirect.addFlashAttribute("sucesso", "Cotação excluída!");
        return "redirect:/cotacoes/produto/" + pid;
    }

    @GetMapping("/export/{produtoId}")
    public void exportarCsv(@PathVariable Integer produtoId,
                            HttpServletResponse response) throws IOException {

        // busca produto e cotações…
        List<Cotacao> lista = cotacaoService.listarPorProduto(produtoId);

        // tipo e cabeçalho de download
        response.setContentType("text/csv");
        String filename = "cotacoes_" + produtoId + ".csv";
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        // escreve o CSV
        try (PrintWriter writer = response.getWriter()) {
            writer.println("id,dataCotacao,fornecedor,valor");
            for (Cotacao c : lista) {
                writer.printf("%d,%s,%s,%.2f%n",
                        c.getId(),
                        c.getDataCotacao(),
                        c.getFornecedor(),
                        c.getValor()
                );
            }
        }
    }

}
