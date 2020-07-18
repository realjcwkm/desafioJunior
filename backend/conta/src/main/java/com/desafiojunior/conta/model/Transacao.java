package com.desafiojunior.conta.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTransacao;
	
	@ManyToOne
	private Conta origem;
	
	@ManyToOne
	private Conta destino;

	private String tipoTransacao;
	private Integer valor;
	private Date horaTransacao;
	
	public Transacao() {
		// TODO Auto-generated constructor stub
	}

	public Transacao(Conta origem, Conta destino, String tipoTransacao, Integer valor, Date horaTransacao) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.tipoTransacao = tipoTransacao;
		this.valor = valor;
		this.horaTransacao = horaTransacao;
	}

	public Long getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}

	public Conta getOrigem() {
		return origem;
	}

	public void setOrigem(Conta origem) {
		this.origem = origem;
	}

	public Conta getDestino() {
		return destino;
	}

	public void setDestino(Conta destino) {
		this.destino = destino;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Date getHoraTransacao() {
		return horaTransacao;
	}

	public void setHoraTransacao(Date horaTransacao) {
		this.horaTransacao = horaTransacao;
	}
	
}
