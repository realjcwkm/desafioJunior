package com.desafiojunior.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiojunior.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

}
