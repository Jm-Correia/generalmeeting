package com.vote.generalmeeting.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PAUTA")
public class Pauta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	private String descricao;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "reuniao_id")
	@MapsId
	private Reuniao reuniao;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "pauta")
	private List<ItemPauta> itens = new ArrayList<>();

	public Pauta() {
		super();
	}

	public Pauta(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Reuniao getReuniao() {
		return reuniao;
	}

	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}

	public List<ItemPauta> getItens() {
		return itens;
	}

	public void setItens(List<ItemPauta> itens) {
		this.itens = itens;
	}
	
	
	
	
}
