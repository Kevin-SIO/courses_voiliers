package com.simplon.course_voilier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/js/**","/css/**").permitAll()
		.antMatchers("/admin/**").authenticated()
		.and()
		.formLogin().loginPage("/admin").defaultSuccessUrl("/admin/index").permitAll()
		.and()
		.logout().permitAll();
		
		return http.build();
	}
}
