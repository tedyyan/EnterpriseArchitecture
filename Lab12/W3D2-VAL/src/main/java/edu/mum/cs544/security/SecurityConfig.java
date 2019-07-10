package edu.mum.cs544.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN").and().withUser("user")
				.password("{noop}bla").roles("USER");
		*/
		auth.jdbcAuthentication()
        .usersByUsernameQuery("select username, password, 1 from user where username=?")
        .authoritiesByUsernameQuery("select u.username, r.name from user u inner join user_authority ur on(u.id=ur.user_id) inner join authority r on(ur.authority_id=r.id) where u.username=?")
        .dataSource(dataSource)
        .passwordEncoder(passwordEncoder());
	}

	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login", "/logout").permitAll()
        .antMatchers("/").hasAnyRole("USER", "ADMIN")
        .antMatchers("/addCar").hasAnyRole("ADMIN")
        .antMatchers("/cars/add").hasAnyRole("ADMIN")
//        .anyRequest().authenticated() //all other urls can be access by any authenticated role
        .and()
        .formLogin() //enable form login instead of basic login
        .loginPage("/login")
        .failureUrl("/login?error=true")
        .usernameParameter("username")
        .passwordParameter("password")
        .defaultSuccessUrl("/")
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login");
	}
	
}
