package com.vote.generalmeeting.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vote.generalmeeting.domain.Usuario;
import com.vote.generalmeeting.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario u = repo.findByLogin(login);
		
		if(u ==null) {
			throw new UsernameNotFoundException(login);
		}
		
		return new UserSS(u.getId(), u.getLogin(), u.getSenha(), u.getPerfis());
	}

}
