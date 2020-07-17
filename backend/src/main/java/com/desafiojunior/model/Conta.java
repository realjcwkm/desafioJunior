package com.desafiojunior.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "conta")
public class Conta implements Serializable {
	@Id
	@Column(name = "idConta")
	@GeneratedValue(strategy = GenerationType.AUTO)	
    private Integer numero_conta;
    private String nome;
    private Float saldo;
    
    @OneToMany(mappedBy = "idTransacao")
    private List<Transacao> transacoes = new ArrayList<Transacao>();

    public Conta() {
    }

    public Conta(Integer numero_conta, String nome, Float saldo) {
        this.numero_conta = numero_conta;
        this.nome = nome;
        this.saldo = saldo;
    }

    public Integer getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(Integer numero_conta) {
        this.numero_conta = numero_conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
}
