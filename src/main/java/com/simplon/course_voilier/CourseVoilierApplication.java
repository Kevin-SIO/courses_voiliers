package com.simplon.course_voilier;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class CourseVoilierApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseVoilierApplication.class, args);
	}
	
	@Bean(name="encryptorBean")
	public StringEncryptor stringEncryptor() {
	    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
	    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
	    config.setPassword("Overwatch");
	    config.setAlgorithm("PBEWithMD5AndDES");
	    config.setKeyObtentionIterations("1000");
	    config.setPoolSize("1");
	    config.setProviderName("SunJCE");
	    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
	    config.setStringOutputType("base64");
	    encryptor.setConfig(config);
	    return encryptor;
	}
}
