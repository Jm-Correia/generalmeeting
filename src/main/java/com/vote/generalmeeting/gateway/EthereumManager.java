package com.vote.generalmeeting.gateway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public abstract class EthereumManager {

	private static final String ETHEREUM_FILE = "ethereum.properties";
	private static final Properties PROPERTIES;

	static {
		PROPERTIES = new Properties();
		
		try(InputStream resourcerAsStream = 
				EthereumManager.class.getClassLoader().getResourceAsStream(ETHEREUM_FILE)){
			PROPERTIES.load(resourcerAsStream);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String carregarProperty(String key) {
		return PROPERTIES.getProperty(key);
	}
	
}
