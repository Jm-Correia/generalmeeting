package com.vote.generalmeeting.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.web3j.crypto.WalletUtils;

import com.vote.generalmeeting.domain.Wallet;

public class Utils {
	
	private Utils() {
	}
	
	public static Wallet criarChaves(String seed) throws Exception {
		
		File file = new File("src/main/resources/temp/");
		
		String url = WalletUtils.generateFullNewWalletFile(seed, file);
		
		String uri = file.getAbsolutePath() + "/" + url;
		
		JSONObject json = new JSONObject();
		JSONParser jsonParser = new JSONParser();
		
		json = (JSONObject) jsonParser.parse(new FileReader(uri));

		JSONObject jsonCryto =  (JSONObject) json.get("crypto");
		
		String chavePrivada = (String) jsonCryto.get("mac");
		
		byte[] fileJson;
		try (InputStream io = new FileInputStream(uri)) {
			
			fileJson = new byte[io.available()];
			io.read(fileJson);
			
			io.close();
		}catch(Exception ex1) {
			throw new Exception(ex1.getMessage());
		}
		
		return new Wallet(null, chavePrivada, fileJson);
	}
	
	
	
	
}
