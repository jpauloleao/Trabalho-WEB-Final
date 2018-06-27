package com.ufc.br.service;

import com.ufc.br.model.Produto;
import com.ufc.br.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public void  removerProduto(Produto produto) {
        produtoRepository.delete(produto);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.getOne(Math.toIntExact(id));
    }
}
