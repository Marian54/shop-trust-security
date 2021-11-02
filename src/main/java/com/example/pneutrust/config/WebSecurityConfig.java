package com.example.pneutrust.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/tiresPage").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/tirePage").hasAuthority("ADMIN")
                .antMatchers("/registerPage").permitAll()
                .antMatchers("/shoppingCartPage").hasAuthority("ADMIN")
                .antMatchers("/h2-console/**").hasAnyAuthority("ADMIN","USER")
                .and().formLogin()
                .loginPage("/loginPage")
                .defaultSuccessUrl("/tiresPage", true)
                .and().exceptionHandling().accessDeniedPage("/accessDenied");
        http.headers().frameOptions().disable();
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}