package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.security;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services.AuthService;
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

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthService authService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //Configuration for authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //For h2 database tests only
        http.authorizeHttpRequests().antMatchers("/h2-console/**").permitAll();
        http.headers().frameOptions().disable();
        //////////////////

        http.authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/api/*/auth").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/api/*/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/api/*/person").permitAll()
                .antMatchers( "/api/*/constraints/**").permitAll()
                .antMatchers("/api/**").authenticated()
                .and().csrf().disable()
                .sessionManagement().
                sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilterBefore(new TokenAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);

    }

    //Configuration for static resources
    @Override
    public void configure(WebSecurity web) throws Exception {

        //swagger public configuration
        web.ignoring().antMatchers(
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                // -- Swagger UI v3 (OpenAPI)
                "/v3/api-docs/**",
                "/swagger-ui/**");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
