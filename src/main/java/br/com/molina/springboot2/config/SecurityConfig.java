package br.com.molina.springboot2.config;

import br.com.molina.springboot2.service.MolinaUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Log4j2
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final MolinaUserDetailsService molinaUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * BasicAuthenticationFilter
         * UsernamePasswordAuthenticationFilter
         * DefaultLoginPageGeneratingFilter
         * DefaultLogoutPageGeneratingFilter
         * FilterSecurityInterceptor
         * Authentication -> Authorization
         * @param http
         * @throws Exception
         */
        http.csrf().disable().authorizeRequests()
//                csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                .antMatchers("/animes/admin/**").hasRole("ADMIN")
                .antMatchers("/animes/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded {}",passwordEncoder.encode("testando"));
        auth.inMemoryAuthentication()
                .withUser("elaine2")
                .password(passwordEncoder.encode("test"))
                .roles("USER","ADMIN")
                .and()
                .withUser("molina2")
                .password(passwordEncoder.encode("test"))
                .roles("USER");

        auth.userDetailsService(molinaUserDetailsService)
                .passwordEncoder((passwordEncoder));
    }
}
