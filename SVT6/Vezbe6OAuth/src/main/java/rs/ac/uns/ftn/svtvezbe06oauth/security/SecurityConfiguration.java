package rs.ac.uns.ftn.svtvezbe06oauth.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.oauth2Login();
        httpSecurity.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        httpSecurity
                .authorizeRequests()
                .antMatchers("/h2-console/*").permitAll()
                .antMatchers("/", "/webjars/**").permitAll()
                .anyRequest().authenticated();
        httpSecurity.logout()
                .logoutSuccessUrl("/").permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

    }
}
