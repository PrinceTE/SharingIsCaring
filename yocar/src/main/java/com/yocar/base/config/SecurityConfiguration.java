package com.yocar.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.yocar.base.filter.JwtRequestFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService detailsService;
	@Autowired
	private JwtRequestFilter jwtReq;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().cors().disable().authorizeHttpRequests().antMatchers("/addCar").hasRole("ADMIN")
//				.antMatchers("/getAllCars").hasAnyRole("ADMIN", "SUPER").antMatchers("/deleteCars")
//				.hasAnyRole("ADMIN", "SUPER").antMatchers("/updateCar").hasAnyRole("ADMIN", "SUPER").and().formLogin();

		// http.csrf().disable().cors().disable().authorizeHttpRequests().antMatchers("/getAllCar").permitAll();

		http.csrf().disable().cors().disable().authorizeRequests().antMatchers("/getAllCar").permitAll()
		.antMatchers("/authenticate").permitAll().anyRequest()
				.authenticated()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtReq, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
