package com.vote.generalmeeting.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Wallet")
public class Wallet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
		
	@Column(name = "HashPrivado")
	private String hashPrivado;
	
	@Lob
	@Column(name = "FileJson", length = 10000)
	private byte[] fileJsonWallet;
	
	@OneToOne
	@JoinColumn(name = "moradorWallet_id")
	@MapsId
	private Morador moradorWallet;
	
	public Wallet() {
		super();
	}

	public Wallet(Integer id, String hashPrivado, byte[] fileJsonWallet) {
		super();
		this.id = id;
		this.hashPrivado = hashPrivado;
		this.fileJsonWallet = fileJsonWallet;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getHashPrivado() {
		return hashPrivado;
	}

	public void setHashPrivado(String hashPrivado) {
		this.hashPrivado = hashPrivado;
	}

	public byte[] getFileJsonWallet() {
		return fileJsonWallet;
	}

	public void setFileJsonWallet(byte[] fileJsonWallet) {
		this.fileJsonWallet = fileJsonWallet;
	}

	public Morador getMoradorWallet() {
		return moradorWallet;
	}

	public void setMoradorWallet(Morador moradorWallet) {
		this.moradorWallet = moradorWallet;
	}
	
}
