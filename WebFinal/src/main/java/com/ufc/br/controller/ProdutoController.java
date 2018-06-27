package com.ufc.br.controller;

import com.ufc.br.model.Produto;
import com.ufc.br.model.Usuario;
import com.ufc.br.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/cadastrar")
    public ModelAndView formProduto(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("produto-form");
        if(authentication != null)
            modelAndView.addObject("usuario", (Usuario) authentication.getPrincipal());
        return modelAndView;
    }

    @PostMapping
    public  ModelAndView cadastrarProduto(Authentication authentication, Produto produto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        if(authentication != null)
            modelAndView.addObject("usuario", (Usuario) authentication.getPrincipal());
        produtoService.cadastrarProduto(produto);
        return modelAndView;
    }

    @GetMapping("del/{id}")
    public  ModelAndView removerProduto(Authentication authentication, @PathVariable("id") Produto produto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        if(authentication != null)
            modelAndView.addObject("usuario", (Usuario) authentication.getPrincipal());
        produtoService.removerProduto(produto);
        return modelAndView;
    }

    @RequestMapping("{id}")
    public ModelAndView atualizarProduto(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorId(id);
        ModelAndView mv = new ModelAndView("produto-form");
        mv.addObject("produto", produto);

        return mv;
    }
}
