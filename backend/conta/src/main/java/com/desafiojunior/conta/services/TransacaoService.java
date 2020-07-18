package com.desafiojunior.conta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiojunior.conta.model.Conta;
import com.desafiojunior.conta.model.Transacao;
import com.desafiojunior.conta.repositories.TransacaoRepository;

@Service
public class TransacaoService {
	@Autowired
	private TransacaoRepository transacaoRepository;

	public void save(Transacao transacao) {
		transacaoRepository.save(transacao);
	}

	public Transacao getTransacao(Long id) {
		return transacaoRepository.findById(id).get();
	}

	public List<Transacao> getAllTransacoes() {
		return transacaoRepository.findAll();
	}

	public List<Transacao> getTransacaoByOrigem(Conta conta) {
		return transacaoRepository.findByOrigemNumConta(conta.getNumConta());
	}

	public List<Transacao> getTransacaoByDestino(Conta conta) {
		return transacaoRepository.findByDestinoNumConta(conta.getNumConta());
	}
}
