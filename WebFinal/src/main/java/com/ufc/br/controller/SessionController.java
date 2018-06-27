package com.ufc.br.controller;

import com.ufc.br.model.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class SessionController {
    @GetMapping("/entrar")
    public ModelAndView entrar(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("entrar");
        if(authentication != null)
            modelAndView.addObject("usuario", (Usuario) authentication.getPrincipal());
        return modelAndView;
    }
}
