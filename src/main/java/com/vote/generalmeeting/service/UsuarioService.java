package com.vote.generalmeeting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vote.generalmeeting.domain.Usuario;
import com.vote.generalmeeting.expection.ObjetoNotFoundExpection;
import com.vote.generalmeeting.repository.UsuarioRepository;

@Service
public class UsuarioService implements ServiceInterface<Usuario> {

	@Autowired
	private UsuarioRepository repo;

	@Override
	public Usuario buscar(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNotFoundExpection(
				"Objeto Não Encontrato! id: " + id + ", tipo "+ Usuario.class.getName()));
	}

	@Override
	public Usuario inserir(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return repo.findAll();
	}

	@Override
	public Page<Usuario> buscarPagina(Integer page, Integer linhasPorPagina, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linhasPorPagina, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	
	
}
