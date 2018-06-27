package com.ufc.br.controller;

import com.ufc.br.model.Usuario;
import com.ufc.br.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ModelAndView index(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("index");
        if(authentication != null)
            modelAndView.addObject("usuario", (Usuario) authentication.getPrincipal());
        modelAndView.addObject("produtos", produtoService.listarProdutos());
        return modelAndView;
    }
}
