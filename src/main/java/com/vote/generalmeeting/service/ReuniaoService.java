package com.vote.generalmeeting.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.vote.generalmeeting.DTO.ReuniaoDTO;
import com.vote.generalmeeting.domain.Reuniao;
import com.vote.generalmeeting.expection.ObjetoNotFoundExpection;
import com.vote.generalmeeting.repository.ReuniaoRepository;

@Service
public class ReuniaoService implements ServiceInterface<Reuniao> {

	@Autowired
	private ReuniaoRepository repo;

	@Override
	public Reuniao buscar(Integer id) {
		Optional<Reuniao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNotFoundExpection(
				"Objeto Não Encontrato! id: " + id + ", tipo "+ Reuniao.class.getName()));
	}

	@Override
	public Reuniao inserir(Reuniao obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reuniao> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Reuniao> buscarPagina(Integer page, Integer linhasPorPagina, String orderBy, String direction) {
		// TODO Auto-generated method stub
		return null;
	}

	public Reuniao fromDTO(@Valid ReuniaoDTO objDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
