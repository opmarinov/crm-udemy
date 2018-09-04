package com.udemy.securityconfig;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource);
  }

/*
  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    auth
        .inMemoryAuthentication()
        .withUser("pacho")
        .password("123")
        .roles("USER")
        .and()
        .withUser("admin")
        .password("123")
        .roles("USER", "ADMIN");
  }
*/

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/api/*").hasRole("ADMIN")
        .antMatchers("/api/*").hasRole("USER")
        .and()
        .formLogin()
        .loginPage("/login").loginProcessingUrl("/authenticate").defaultSuccessUrl("/api/customers", true)
        .permitAll()
        .and().logout().permitAll()
        .and().exceptionHandling().accessDeniedPage("/access-denied");
  }
}
