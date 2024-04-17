package com.icev.pjesimulator.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.icev.pjesimulator.repositories.ProfileRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final AuthenticationService authenticationService;
	private final TokenService tokenService;
	private final ProfileRepository profileRepository;

	public SecurityConfig(AuthenticationService authenticationService, TokenService tokenService, ProfileRepository profileRepository) {
		this.authenticationService = authenticationService;
		this.tokenService = tokenService;
		this.profileRepository = profileRepository;
	}

	private static final String[] PUBLIC_MATCHERS = {
			"/h2-console/**"
	};

	private static final String[] PUBLIC_MATCHERS_GET = {
			"/materias/**",
			"/jurisdicao/**",
			"/classe_judicial/**",
			"/competence/**",
			"/judicial/**",
			"/help/**",
			"/process/**",
			"/subject/**"

	};

	private static final String[] PUBLIC_MATCHERS_POST = {
			"/profile/**",
			"/auth/**"
	};

	private static final String[] PRIVATE_MATCHERS_POST = {
			"/materias/**",
			"/jurisdicao/**",
			"/classe_judicial/**",
			"/competence/**",
			"/judicial/**",
			"/help/**",
			"/process/**",
			"/subject/**"
	};

	private static final String[] PRIVATE_MATCHERS_PUT = {
			"/materias/**",
			"/jurisdicao/**",
			"/classe_judicial/**",
			"/competence/**",
			"/judicial/**",
			"/help/**",
			"/process/**",
			"/subject/**"
	};
	private static final String[] PRIVATE_MATCHERS_DELETE = {
			"/materias/**",
			"/jurisdicao/**",
			"/classe_judicial/**",
			"/competence/**",
			"/judicial/**",
			"/help/**",
			"/process/**",
			"/subject/**"
	};

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
				.antMatchers(HttpMethod.POST, PRIVATE_MATCHERS_POST).permitAll()
				.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
				.antMatchers(HttpMethod.PUT, PRIVATE_MATCHERS_PUT).permitAll()
				.antMatchers(HttpMethod.DELETE, PRIVATE_MATCHERS_DELETE).permitAll()
				.antMatchers(PUBLIC_MATCHERS).permitAll()
				.anyRequest().authenticated()

				.and().cors().and().csrf().disable()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().addFilterBefore(new AuthenticationViaTokenFilter(tokenService, profileRepository), UsernamePasswordAuthenticationFilter.class);

	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }
}
