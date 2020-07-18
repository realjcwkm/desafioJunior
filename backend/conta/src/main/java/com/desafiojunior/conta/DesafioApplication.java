package com.desafiojunior.conta;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafiojunior.conta.model.Conta;
import com.desafiojunior.conta.model.Transacao;
import com.desafiojunior.conta.repositories.ContaRepository;
import com.desafiojunior.conta.repositories.TransacaoRepository;
import com.desafiojunior.conta.services.ContaService;
import com.desafiojunior.conta.services.TransacaoService;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}
	
	@Autowired
	public void starter(ContaRepository contaRepository, ContaService contaService, TransacaoRepository transacaoRepository, TransacaoService transacaoService) {
		if(contaRepository.count() == 0) {
			contaService.save(new Conta("admin", 10));			
		}
		if(transacaoRepository.count() == 0) {
			transacaoService.save(
				new Transacao(new Conta("conta teste", 0),
					new Conta("conta teste2", 10),
					"saque",
					10,
					new Date()
				)
			);
			
		}

		
		
	}
}
