package com.desafiojunior.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafiojunior.model.Conta;
import com.desafiojunior.model.Transacao;
import com.desafiojunior.repository.TransacaoRepository;
@RestController
public class TransacaoController {
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@GetMapping("/transacoes")
	public List<Transacao> listarTransacoes() {		
		return transacaoRepository.findAll();
	}
	
	@GetMapping("/transacao")
	public Optional<Transacao> buscarTransacoes(@RequestBody Integer id) {	
		return transacaoRepository.findById(id);
	}
	
	@PostMapping("/transacao")
	public void cadastrarTransacao(@RequestBody Transacao transacao) {
		transacaoRepository.save(transacao);		
	}
}
