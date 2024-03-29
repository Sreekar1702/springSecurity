package com.example.demoSecirity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
   /* @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder().username("john").password("{noop}test123")
                .roles("EMPLOYEE").build();
        UserDetails mary = User.builder().username("mary").password("{noop}test123")
                .roles("EMPLOYEE","MANAGER").build();
        return new InMemoryUserDetailsManager(john,mary);

    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                configurer->configurer.requestMatchers("/buyer-home/*").hasRole("BUYER")
                        .requestMatchers("/seller-home/**").hasRole("SELLER")
                        .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser").permitAll())
                .logout(logout -> logout.permitAll())
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));
        return http.build();
    }
}
