package com.ufc.br.model;

import org.springframework.security.core.GrantedAuthority;

public enum Papel implements GrantedAuthority {

    ADMINISTRADOR("ADMINISTRADOR"), CLIENTE("CLIENTE");

    private String descricao;

    private Papel(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + this.descricao;
    }
}
