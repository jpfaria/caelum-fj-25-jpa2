package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Index;

@Entity
public class Conta {

	@Id
	@GeneratedValue
	private Integer id;
	@Index(name = "titular")
	private String titular;
	private String agencia;
	private String numero;
	private String banco;
	//@OneToMany
	//private Movimentacao movimentacoes;

	public Integer getId() {
		return id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	/*
	public Movimentacao getMovimentacoes() {
		return movimentacoes;
	}
	*/

}
