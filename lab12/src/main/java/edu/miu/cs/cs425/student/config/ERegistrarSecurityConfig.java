package edu.miu.cs.cs425.student.config;

import edu.miu.cs.cs425.student.service.serviceimpl.ERegistrarUserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ERegistrarSecurityConfig {
    @Autowired
    private ERegistrarUserDetailService eregistrarUserDetailService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        var authenticationProvider= new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(eregistrarUserDetailService);

        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/resources/static/**").permitAll()
                .requestMatchers("/images/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/").permitAll()
                .requestMatchers("/secured/student").permitAll()
                .requestMatchers("/index").permitAll()
                .requestMatchers("/list/**").hasAnyRole("ADMIN","REGISTRAR","STUDENT")
                .requestMatchers("/new/**").hasAnyRole("REGISTRAR")
                .requestMatchers("/update/**").hasAnyRole("REGISTRAR")
                .requestMatchers("/searchview").hasAnyRole("ADMIN","REGISTRAR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/eregistrar/public/login")
                .defaultSuccessUrl("/secured/student/home")
                .failureUrl("/eregistrar/public/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/eregistrar/public/logout"))
                .logoutSuccessUrl("/eregistrar/public/login?logout")
                .permitAll()
                .and()
                .exceptionHandling();



        return httpSecurity.build();

    }

}
