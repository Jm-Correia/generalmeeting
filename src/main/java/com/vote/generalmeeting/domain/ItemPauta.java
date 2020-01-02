package com.vote.generalmeeting.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ITEMPAUTA")
public class ItemPauta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String descricao;
	
	@Column
	private String textoItem;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pauta_id")
	private Pauta pauta;

	public ItemPauta() {
		super();
	}

	public ItemPauta(Integer id, String descricao, String textoItem) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.textoItem = textoItem;
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

	public String getTextoItem() {
		return textoItem;
	}

	public void setTextoItem(String textoItem) {
		this.textoItem = textoItem;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}
	
	      
	
	
}
