package com.vote.generalmeeting;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vote.generalmeeting.Enumeration.Perfil;
import com.vote.generalmeeting.domain.Condominio;
import com.vote.generalmeeting.domain.ItemPauta;
import com.vote.generalmeeting.domain.Morador;
import com.vote.generalmeeting.domain.Pauta;
import com.vote.generalmeeting.domain.Reuniao;
import com.vote.generalmeeting.domain.Usuario;
import com.vote.generalmeeting.domain.Wallet;
import com.vote.generalmeeting.repository.CondominioRepository;
import com.vote.generalmeeting.repository.ItemPautaRepository;
import com.vote.generalmeeting.repository.MoradorRespository;
import com.vote.generalmeeting.repository.PautaRepository;
import com.vote.generalmeeting.repository.ReuniaoRepository;
import com.vote.generalmeeting.repository.UsuarioRepository;
import com.vote.generalmeeting.repository.WalletRepository;
import com.vote.generalmeeting.util.Utils;

@SpringBootApplication
public class GeneralmeetingApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MoradorRespository moradorRepository;
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private ReuniaoRepository reuniaoRepository;
	
	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private ItemPautaRepository itemPautaRepository;
	
	@Autowired
	private CondominioRepository condominioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GeneralmeetingApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		/**
		 * Usuario Morador e wallet
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdft = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Usuario admin = new Usuario(null, "Admin", pe.encode("admin"));
		admin.addPerfil(Perfil.SINDICO);
		
		Usuario user1 = new Usuario(null, "Morador1", pe.encode("12345"));
		Usuario user2 = new Usuario(null, "Morador2", pe.encode("12345"));
		Usuario user3 = new Usuario(null, "Morador3", pe.encode("12345"));
		Usuario user4 = new Usuario(null, "Morador4", pe.encode("12345"));
		
		Morador sindico = new Morador(null, "Sindico ", " 1 ",true, sdf.parse("01/01/2019"));
		Morador morador1 = new Morador(null, "Morador ", " 1",true, sdf.parse("01/01/2019"));
		Morador morador2 = new Morador(null, "Morador ", " 2",true, sdf.parse("01/01/2019"));
		Morador morador3 = new Morador(null, "Morador ", " 3",true, sdf.parse("01/01/2019"));
		Morador morador4 = new Morador(null, "Morador ", " 4",true, sdf.parse("01/01/2019"));
		
		Wallet walletAdmin = Utils.criarChaves(admin.getSenha());
		Wallet wallet1 = Utils.criarChaves(user1.getSenha());
		Wallet wallet2 = Utils.criarChaves(user2.getSenha());
		Wallet wallet3 = Utils.criarChaves(user3.getSenha());
		Wallet wallet4 = Utils.criarChaves(user4.getSenha());
		
		admin.setMorador(sindico);
		walletAdmin.setMoradorWallet(sindico);
		
		user1.setMorador(morador1);
		wallet1.setMoradorWallet(morador1);
		
		user2.setMorador(morador2);
		wallet2.setMoradorWallet(morador2);
		
		user3.setMorador(morador3);
		wallet3.setMoradorWallet(morador3);
		
		user4.setMorador(morador4);
		wallet4.setMoradorWallet(morador4);
				
		walletRepository.saveAll(Arrays.asList(walletAdmin,wallet1,wallet2,wallet3,wallet4));
		usuarioRepository.saveAll(Arrays.asList(admin,user1,user2,user3,user4));
		
		moradorRepository.saveAll(Arrays.asList(sindico,morador1,morador2,morador3,morador4));
		
		
		/**
		 * Reuniao Pauta e Item_Pauta
		 */
		
		Reuniao reuniao1 = new Reuniao(null, sdft.parse("02/03/2020 19:30"), "Reunião de Apresentação do novo Sistema",
				60);
		
		Pauta pauta = new Pauta(null, "Votação para aquisição e utilização do sistema apresentado");
		
		pauta.setReuniao(reuniao1);
		
		ItemPauta item1 = new ItemPauta(null, "Titulo item 1", "Texto de explicação do item 1");
		ItemPauta item2 = new ItemPauta(null, "Titulo item 2", "Texto de explicação do item 2");
		ItemPauta item3 = new ItemPauta(null, "Titulo item 3", "Texto de explicação do item 3");
		ItemPauta item4 = new ItemPauta(null, "Titulo item 4", "Texto de explicação do item 4");
		
		item1.setPauta(pauta);
		item2.setPauta(pauta);
		item3.setPauta(pauta);
		item4.setPauta(pauta);
		
		
		pauta.setItens(Arrays.asList(item1,item2,item3,item4));
		
		
		pautaRepository.save(pauta);
		itemPautaRepository.saveAll(Arrays.asList(item1,item2,item3,item4));
		
		
		reuniaoRepository.save(reuniao1);
		
		/**
		 * Condominio
		 */
		
		Condominio condominio1 = new Condominio(null, "Aquafina Studios", 5);
		condominio1.setMoradores(Arrays.asList(sindico,morador1,morador2,morador3,morador4));
		condominio1.setReunioes(Arrays.asList(reuniao1));
		
		condominioRepository.save(condominio1);
		
		reuniao1.setCondominio(condominio1);                                                                                                                                                                                                                                       
		
		sindico.setCondominioMorador(condominio1);
		morador1.setCondominioMorador(condominio1);
		morador2.setCondominioMorador(condominio1);
		morador3.setCondominioMorador(condominio1);
		morador4.setCondominioMorador(condominio1);
		
		
		
	}

}
