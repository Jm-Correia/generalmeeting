package com.vote.generalmeeting.Enumeration;

public enum Perfil {
	
	SINDICO(1, "ROLE_ADMIN"),
	MORADOR(2, "ROLE_MORADOR");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		if(cod ==null) {
			return null;
		}
		
		for(Perfil x: Perfil.values()) {
			if(cod.equals(x.cod))
				return x;
		}
		
		throw new IllegalArgumentException("Id Inválido " + cod);
	}

}
