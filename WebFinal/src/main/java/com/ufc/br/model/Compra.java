package com.ufc.br.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity @Data
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Usuario cliente;

    @ManyToMany(mappedBy = "compras", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    private Boolean finalizada;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(id, compra.id) &&
                Objects.equals(cliente, compra.cliente) &&
                Objects.equals(produtos, compra.produtos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cliente, produtos);
    }
}
