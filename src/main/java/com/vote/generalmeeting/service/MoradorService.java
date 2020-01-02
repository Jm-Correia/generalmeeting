package com.vote.generalmeeting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vote.generalmeeting.domain.Morador;
import com.vote.generalmeeting.expection.ObjetoNotFoundExpection;
import com.vote.generalmeeting.repository.MoradorRespository;

@Service
public class MoradorService implements ServiceInterface<Morador> {

	@Autowired
	private MoradorRespository repo;
	
	public Morador buscar(Integer id) {
	Optional<Morador> obj = repo.findById(id);
	return obj.orElseThrow(() -> new ObjetoNotFoundExpection(
			"Objeto Não Encontrato! id: " + id + ", tipo "+ Morador.class.getName()));
	}
	
	public Morador inserir(Morador obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public List<Morador> buscarTodos(){
		return repo.findAll();
	}
	
	public Page<Morador> buscarPagina(Integer page, Integer linhasPorPagina, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linhasPorPagina, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	
}
