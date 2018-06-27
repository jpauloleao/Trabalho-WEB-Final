package com.ufc.br.controller;

import com.ufc.br.model.Usuario;
import com.ufc.br.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/cadastrar")
    public ModelAndView cadastroForm() {
        ModelAndView modelAndView = new ModelAndView("cliente-form");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView cadastrar(Usuario usuario) {
        ModelAndView modelAndView = new ModelAndView("redirect:/entrar");
        clienteService.cadastrarUsuario(usuario);
        return modelAndView;
    }
}
