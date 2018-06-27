package com.ufc.br.service;

import com.ufc.br.model.Papel;
import com.ufc.br.model.Usuario;
import com.ufc.br.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario cliente) {
        cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
        cliente.setPapeis(new ArrayList<>());
        cliente.getPapeis().add(Papel.CLIENTE);
        return usuarioRepository.save(cliente);
    }
}
