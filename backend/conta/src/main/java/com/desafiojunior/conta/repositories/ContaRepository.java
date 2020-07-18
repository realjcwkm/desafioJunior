package com.desafiojunior.conta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiojunior.conta.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
