package br.edu.infnet.acme.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.edu.infnet.acme.service.ProdutoService;
import br.edu.infnet.acme.model.Produto;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping // JSP: /WEB-INF/views/produto/lista.jsp
    public String listar(Model model) {
        List<Produto> lista = produtoService.listarTodos();
        model.addAttribute("produtos", lista);
        return "produtos/lista";
    }

    @GetMapping("/novo") //JSP: /WEB-INF/views/produto/form.jsp
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/form";
    }

    @GetMapping("editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {
        Produto p = produtoService.obterPorId(id);
        model.addAttribute("produto", p);
        return "produtos/form";
    }

    @GetMapping("/salvar")
    public String salvar(
            @Valid @ModelAttribute Produto produto,
            BindingResult binding,
            RedirectAttributes redirect) {
        if (binding.hasErrors()) {
            return "produtos/form";
        }
        produtoService.salvar(produto);
        redirect.addFlashAttribute("sucesso", "Produto salvo com sucesso!");
        return "redirect:/produtos";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(RedirectAttributes redirect, @PathVariable Integer id) {
        produtoService.excluir(id);
        redirect.addFlashAttribute("sucesso", "Produto removido com sucesso!");
        return "redirect:/produtos";
    }

}

// @Valid e BindingResult para exibir erros de validação no JSP.