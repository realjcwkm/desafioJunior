package com.desafiojunior.conta.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafiojunior.conta.model.Conta;
import com.desafiojunior.conta.model.Transacao;
import com.desafiojunior.conta.services.ContaService;
import com.desafiojunior.conta.services.TransacaoService;

@RestController
public class ContaController {
	
	@Autowired
	private ContaService contaService;

	@Autowired
	private TransacaoService transacaoService;

	@GetMapping(value = "/contas")
	public List<Conta> contas() {
		return contaService.getAllContas();
	}

	// criar conta
	@PostMapping(value = "/registrar")
	public Long registrar(@RequestBody Conta conta) {
		contaService.save(conta);

		return conta.getNumConta();
	}

	// buscarConta
	@GetMapping(value = "/conta/{id}")
	public Conta buscarConta(@PathVariable("id") Long id) {
		return contaService.getConta(id);
	}

	// depositar
	@PutMapping(value = "/depositar")
//	public boolean depositar(@RequestBody Integer id, @RequestBody Integer valor) {
	public boolean depositar(@RequestBody Map<String, Integer> param) {
		Long idConta = param.get("id").longValue();
		Integer valorParam = param.get("valor");

		Conta conta = buscarConta(idConta);

		if (valorParam > 0) {
			conta.setSaldo(conta.getSaldo() + valorParam);
			contaService.save(conta);

			Transacao transacao = new Transacao(conta, null, "deposito", valorParam, new Date());
			transacaoService.save(transacao);

			return true;
		}
		return false;
	}

//	sacar
	@PutMapping(value = "/sacar")
	public boolean sacar(@RequestBody Map<String, Integer> param) {
		Long idConta = param.get("id").longValue();
		Integer valorParam = param.get("valor");
		
		Conta conta = buscarConta(idConta);

		if (conta.getSaldo() >= valorParam && valorParam > 0) {
			conta.setSaldo(conta.getSaldo() - valorParam);
			contaService.save(conta);

			Transacao transacao = new Transacao(conta, null, "saque", valorParam, new Date());
			transacaoService.save(transacao);

			return true;
		}

		return false;
	}

//	transferir
	@PutMapping(value = "/transferir")	
	public boolean transferir(@RequestBody Map<String, Integer> param) {
		Long idOrigem = param.get("idOrigem").longValue();
		Long idDestino = param.get("idDestino").longValue();
		Integer valorParam = param.get("valor");

		Conta contaOrigem = buscarConta(idOrigem);
		Conta contaDestino = buscarConta(idDestino);

		if (contaOrigem.getSaldo() >= valorParam && valorParam > 0) {
			contaOrigem.setSaldo(contaOrigem.getSaldo() - valorParam);
			contaDestino.setSaldo(contaDestino.getSaldo() + valorParam);

			contaService.save(contaOrigem);
			contaService.save(contaDestino);

			Transacao transacao = new Transacao(contaOrigem, contaDestino, "transferencia", valorParam, new Date());
			transacaoService.save(transacao);

			return true;
		}
		return false;
	}
}
