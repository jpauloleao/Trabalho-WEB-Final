package com.ufc.br.service;

import com.ufc.br.model.Compra;
import com.ufc.br.model.Produto;
import com.ufc.br.model.Usuario;
import com.ufc.br.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    CompraRepository compraRepository;

    public Compra buscarCompra(Usuario cliente) {
        return compraRepository.findByClienteAndFinalizadaIsFalse(cliente);
    }

    public Compra addProdutoEmCompra(Produto produto, Usuario cliente) {
        Compra compra = Optional.ofNullable(compraRepository.findByClienteAndFinalizadaIsFalse(cliente)).orElse(new Compra());
        if(compra.getProdutos() == null)
            compra.setProdutos(new ArrayList<>());
        compra.getProdutos().add(produto);
        compra.setCliente(cliente);
        compra.setFinalizada(Boolean.FALSE);
        produto.getCompras().add(compra);
        return compraRepository.save(compra);
    }

    public void finzalizarCompra(Compra compra) {
        compra.setFinalizada(Boolean.FALSE);
        compraRepository.save(compra);
    }
}
