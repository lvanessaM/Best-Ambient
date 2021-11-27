	package co.edu.poli.bestambientv1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/* Providers */ 
		//first case memory users only without encryption
	
		auth.inMemoryAuthentication() 
			.withUser("bestambient") 
			.password("{noop}123456")//{noop} plain text comment methods noPasswordEncoder/passwordEncoder
			.roles("ADMIN");
		/*	
		
		//second case database users and memory without encryption
		
 		auth.userDetailsService(userDetailsService); 
 		
		auth.inMemoryAuthentication()
			.withUser("wilson") 
			.password("123456") //using method noPasswordEncoder
			.roles("ADMIN");
  		

		//third case database users and memory with encryption
  		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); 
		

		
		auth.inMemoryAuthentication() 
			.withUser("wilson")
			.password("$2a$10$l.Rxc0VECmpHjinzxMG/wunvebywkRtSwIkSk./Th0ip2k6quv92i") //using method passwordEncoder 
			.roles("ADMIN");
		*/
  
  }
	
	@Override protected void configure(HttpSecurity http) throws Exception {
		
		 http.cors()
		 	.and()
			.csrf().disable() //Cross-Site Request Forgery (falsificación de petición en sitios cruzados) 
			.authorizeRequests()
			.antMatchers("/publicacioness/**").hasAnyRole("ADMIN", "USER")
			.antMatchers("/api/v1/usuario/**").hasAnyRole("ADMIN", "USER")
			.antMatchers("/api/v1/msg").hasRole("ADMIN")
			.anyRequest().authenticated() //For any other request, you do not need specific role but still need to be authenticated. 
			.and() 
			.httpBasic(); //authentication method (allow test postman POST,DELETE,PUT) 
	}

/*
	@Bean
	public PasswordEncoder noPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
*/
/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
*/
}
