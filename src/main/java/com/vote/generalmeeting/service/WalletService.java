package com.vote.generalmeeting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vote.generalmeeting.domain.Wallet;
import com.vote.generalmeeting.expection.ObjetoNotFoundExpection;
import com.vote.generalmeeting.repository.WalletRepository;

@Service
public class WalletService implements ServiceInterface<Wallet> {

	@Autowired
	private WalletRepository repo;

	@Override
	public Wallet buscar(Integer id) {
		Optional<Wallet> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjetoNotFoundExpection(
				"Objeto Não Encontrado! id: " + id + ", tipo " + Wallet.class.getName()));
	}

	@Override
	public Wallet inserir(Wallet obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	@Override
	public List<Wallet> buscarTodos() {
		return repo.findAll();
	}

	@Override
	public Page<Wallet> buscarPagina(Integer page, Integer linhasPorPagina, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linhasPorPagina, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
}
