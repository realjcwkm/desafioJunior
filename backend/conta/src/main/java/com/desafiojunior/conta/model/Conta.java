package com.desafiojunior.conta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conta {
	@Id
	@GeneratedValue
	private Long numConta;
	private String nome;
	private Integer saldo;

	public Conta() {
		// TODO Auto-generated constructor stub
	}

	public Conta(String nome, Integer saldo) {
		super();
		this.nome = nome;
		this.saldo = saldo;
	}

	public Long getNumConta() {
		return numConta;
	}

	public void setNumConta(Long numConta) {
		this.numConta = numConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

}
