package com.vote.generalmeeting.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Morador")
public class Morador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "FistName")
	private String primeiroNome;
	
	@Column(name = "LastName")
	private String ultimoNome;
	
	@Column(name = "IsOwner")
	private boolean isDonoImovel;
	
	@Column(name = "DateBeginLiving")
	private Date inicioResidencia;
	
	@Column(name = "DateEndLiving")
	private Date fimResidencia;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "morador")
	private Usuario user;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "moradorWallet")
	private Wallet wallet;
	
	@ManyToOne
	@JoinColumn(name = "condominio_id")
	private Condominio condominioMorador;

	public Morador() {
		super();
	}

	public Morador(Integer id, String primeiroNome, String ultimoNome, boolean isDonoImovel, Date inicioResidencia) {
		super();
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.isDonoImovel = isDonoImovel;
		this.inicioResidencia = inicioResidencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public boolean isDonoImovel() {
		return isDonoImovel;
	}

	public void setDonoImovel(boolean isDonoImovel) {
		this.isDonoImovel = isDonoImovel;
	}

	public Date getInicioResidencia() {
		return inicioResidencia;
	}

	public void setInicioResidencia(Date inicioResidencia) {
		this.inicioResidencia = inicioResidencia;
	}

	public Date getFimResidencia() {
		return fimResidencia;
	}

	public void setFimResidencia(Date fimResidencia) {
		this.fimResidencia = fimResidencia;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Condominio getCondominioMorador() {
		return condominioMorador;
	}

	public void setCondominioMorador(Condominio condominioMorador) {
		this.condominioMorador = condominioMorador;
	}

	
	
	
}
