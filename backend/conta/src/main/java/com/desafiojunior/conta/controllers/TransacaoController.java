package com.desafiojunior.conta.controllers;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafiojunior.conta.model.Conta;
import com.desafiojunior.conta.model.Transacao;
import com.desafiojunior.conta.services.ContaService;
import com.desafiojunior.conta.services.TransacaoService;

@RestController
public class TransacaoController {
	
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	
	@Autowired
	private ContaService contaService;

	@Autowired
	private TransacaoService transacaoService;

	@GetMapping(value = "/transacoes")
	public List<Transacao> listarTransacoes() {
		return transacaoService.getAllTransacoes();
	}

	@GetMapping(value = "/transacao/{id}")
	public Transacao buscarTransacao(@PathVariable("id") Long id) {
		Transacao t = transacaoService.getTransacao(id);
		System.out.println("Horario transacao: " + dateFormatter.format(t.getHoraTransacao()));
		return transacaoService.getTransacao(id);
	}

	@PostMapping(value = "/transacao")
	public void cadastrarTransacao(@RequestBody Transacao transacao) {
		transacaoService.save(transacao);
	}
}
