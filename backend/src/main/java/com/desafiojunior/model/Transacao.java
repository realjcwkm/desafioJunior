package com.desafiojunior.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "transacao")
public class Transacao implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTransacao;

	@OneToOne(mappedBy = "numero_conta", cascade = CascadeType.ALL)
	private Conta origem;

	@OneToOne(mappedBy = "numero_conta", cascade = CascadeType.ALL)
	private Conta destino;

	private String tipo_transacao;
	private Float valor;
	private Date hora_transacao;

	public Transacao() {
	}

	public Transacao(Conta origem, Conta destino, String tipo_transacao, Float valor, Date hora_transacao) {
		this.origem = origem;
		this.destino = destino;
		this.tipo_transacao = tipo_transacao;
		this.valor = valor;
		this.hora_transacao = hora_transacao;
	}

	public Integer getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Integer idTransacao) {
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

	public String getTipo_transacao() {
		return tipo_transacao;
	}

	public void setTipo_transacao(String tipo_transacao) {
		this.tipo_transacao = tipo_transacao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Date getHora_transacao() {
		return hora_transacao;
	}

	public void setHora_transacao(Date hora_transacao) {
		this.hora_transacao = hora_transacao;
	}

}
