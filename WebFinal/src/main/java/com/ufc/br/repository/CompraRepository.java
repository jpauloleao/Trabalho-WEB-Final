package com.ufc.br.repository;

import com.ufc.br.model.Compra;
import com.ufc.br.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
    Compra findByClienteAndFinalizadaIsFalse(Usuario cliente);
}
