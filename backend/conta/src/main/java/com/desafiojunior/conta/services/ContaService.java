package com.desafiojunior.conta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiojunior.conta.model.Conta;
import com.desafiojunior.conta.repositories.ContaRepository;

@Service
public class ContaService {
	@Autowired
	private ContaRepository contaRepository;

	public void save(Conta conta) {
		contaRepository.save(conta);
	}

	public Conta getConta(Long id) {
		return contaRepository.findById(id).get();
	}

	public List<Conta> getAllContas() {
		return contaRepository.findAll();
	}
}
