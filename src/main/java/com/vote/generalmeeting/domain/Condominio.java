package com.vote.generalmeeting.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CONDOMINIO")
public class Condominio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private Integer qtdMoradores;
	
	@JsonIgnore
	@OneToMany(mappedBy = "condominio")
	private List<Reuniao> reunioes = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "condominioMorador")
	private List<Morador> moradores = new ArrayList<>();

	public Condominio() {
		super();
	}

	public Condominio(Integer id, String nome, Integer qtdMoradores) {
		super();
		this.id = id;
		this.nome = nome;
		this.qtdMoradores = qtdMoradores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdMoradores() {
		return qtdMoradores;
	}

	public void setQtdMoradores(Integer qtdMoradores) {
		this.qtdMoradores = qtdMoradores;
	}

	public List<Reuniao> getReunioes() {
		return reunioes;
	}

	public void setReunioes(List<Reuniao> reunioes) {
		this.reunioes = reunioes;
	}

	public List<Morador> getMoradores() {
		return moradores;
	}

	public void setMoradores(List<Morador> moradores) {
		this.moradores = moradores;
	}

	
	
	
}
