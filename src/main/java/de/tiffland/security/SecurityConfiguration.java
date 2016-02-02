package de.tiffland.security;

import de.tiffland.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Thomas on 01.02.16.
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {




    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().
                antMatchers("/").permitAll().
                antMatchers("/register").permitAll().
                antMatchers("/login").permitAll().
                antMatchers("/index").permitAll().
                and().formLogin().loginPage("/login").defaultSuccessUrl("/index")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index");;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, CustomUserDetailsService customUserDetailsService) throws Exception {
        auth
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

}
