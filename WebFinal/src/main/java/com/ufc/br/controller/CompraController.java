package com.ufc.br.controller;

import com.ufc.br.model.Produto;
import com.ufc.br.model.Usuario;
import com.ufc.br.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("compras")
public class CompraController {

    @Autowired
    CompraService compraService;

    @GetMapping("/addproduto/{id}")
    public ModelAndView addproduto(Authentication authentication, @PathVariable("id") Produto produto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        if(authentication != null)
            modelAndView.addObject("usuario", (Usuario) authentication.getPrincipal());

        compraService.addProdutoEmCompra(produto, (Usuario) authentication.getPrincipal());
        return modelAndView;
    }
}
