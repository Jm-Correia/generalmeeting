package com.vote.generalmeeting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vote.generalmeeting.domain.Usuario;


public class UsuarioTest {

	
	@Test
	public void compararUsuario() {
		Usuario usuario = new Usuario(null, "JMC", "JMC");
	
		assertEquals("JMC", usuario.getLogin());
		
	}
	
	@Test
	public void compararSenha() {
		Usuario usuario = new Usuario(null, "JMC", "JMC");
	
		assertEquals("JMC", usuario.getSenha());
		
	}
	
	
	
	
}
