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
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "REUNIAO")
public class Reuniao implements Serializable {

	public static final String REUNIAO_EXTRAORDINARIA = "E";
	public static final String REUNIAO_ORDINARIA = "O";
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dhReuniao;
	
	private String descricao;
	
	private int duracao;
	
	private String tipoReuniao = REUNIAO_ORDINARIA;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "reuniao")
	private Pauta pauta;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "condominio_id")
	private Condominio condominio;

	public Reuniao() {
		super();
	}

	public Reuniao(Integer id, Date dhReuniao, String descricao, int duracao) {
		super();
		this.id = id;
		this.dhReuniao = dhReuniao;
		this.descricao = descricao;
		this.duracao = duracao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDhReuniao() {
		return dhReuniao;
	}

	public void setDhReuniao(Date dhReuniao) {
		this.dhReuniao = dhReuniao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getTipoReuniao() {
		return tipoReuniao;
	}

	public void setTipoReuniao(String tipoReuniao) {
		this.tipoReuniao = tipoReuniao;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
	
}
