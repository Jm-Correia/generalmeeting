package com.vote.generalmeeting.service;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ServiceInterface<T> {

	T buscar(Integer id);
	T inserir(T obj);
	List<T> buscarTodos();
	Page<T> buscarPagina(Integer page, Integer linhasPorPagina, String orderBy, String direction);
	
	
}
