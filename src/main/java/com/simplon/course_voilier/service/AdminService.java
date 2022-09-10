package com.simplon.course_voilier.service;

import java.util.Optional;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.simplon.course_voilier.model.Admin;
import com.simplon.course_voilier.repository.AdminRepo;

@PropertySource("classpath:application.properties")
@Service
public class AdminService {

	@Autowired
	AdminRepo ar;
	@Autowired
	private Environment env;
	
	public Admin connexion(String username, String password) {
		
		Optional<Admin> admin = ar.findById(username);
		if(admin.isPresent()) {
			StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
	        decryptor.setPassword(env.getProperty("password"));
	        
	        return password.equals(decryptor.decrypt(admin.get().getMdp())) ? admin.get() : null;
		}
		else {
			return null;
		}
	}
}
