package com.desafiojunior.conta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiojunior.conta.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
	List<Transacao> findByOrigemNumConta(Long id);
	List<Transacao> findByDestinoNumConta(Long id);
}
