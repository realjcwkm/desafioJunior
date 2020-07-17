package com.desafiojunior.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafiojunior.model.Conta;
import com.desafiojunior.model.Transacao;
import com.desafiojunior.repository.ContaRepository;
import com.desafiojunior.repository.TransacaoRepository;

@RestController
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@GetMapping("/contas")
	public List<Conta> listarContas() {
		return contaRepository.findAll();
	}

	// criar conta
	@PostMapping("/conta")
	public void criarConta(@RequestBody Conta conta) {
		contaRepository.save(conta);
	}

	// alterar
	@PutMapping("/conta")
	public void alterar(@RequestBody Conta conta) {
		contaRepository.save(conta);
	}

	@GetMapping("/conta/{id}")
	public Optional<Conta> buscarConta(@PathVariable("id") Integer id) {
		return contaRepository.findById(id);
	}

	// depositar
	@PutMapping("/conta/depositar")
	public boolean depositar(@RequestBody Integer id, @RequestBody Float valor) {
		Conta conta = buscarConta(id).get();

		if (valor > 0) {
			conta.setSaldo(conta.getSaldo() + valor);
			contaRepository.save(conta);
			
			Transacao transacao = new Transacao(conta, null, "deposito", valor, new Date());
			transacaoRepository.save(transacao);

			return true;
		}
		return false;
	}

	// sacar
	@PutMapping("/conta/sacar")
	public boolean sacar(@RequestBody Integer id, @RequestBody Float valor) {
		Conta conta = buscarConta(id).get();

		if (conta.getSaldo() >= valor && valor > 0) {
			conta.setSaldo(conta.getSaldo() - valor);
			contaRepository.save(conta);
			
			Transacao transacao = new Transacao(conta, null, "saque", valor, new Date());
			transacaoRepository.save(transacao);

			return true;
		}

		return false;
	}

	// sacar
	@PutMapping("/conta/transaferir")
	public boolean transferir(@RequestBody Integer idOrigem, @RequestBody Integer idDestino, @RequestBody Float valor) {
		Conta contaOrigem = buscarConta(idOrigem).get();
		Conta contaDestino = buscarConta(idDestino).get();

		if (contaOrigem.getSaldo() >= valor && valor > 0) {
			contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
			contaDestino.setSaldo(contaDestino.getSaldo() + valor);

			contaRepository.save(contaOrigem);
			contaRepository.save(contaDestino);
			
			Transacao transacao = new Transacao(contaOrigem, contaDestino, "transferencia", valor, new Date());
			transacaoRepository.save(transacao);
			
			return true;
		}
		return false;
	}
}
