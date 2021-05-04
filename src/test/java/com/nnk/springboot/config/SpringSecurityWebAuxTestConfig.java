package com.nnk.springboot.config;

import com.nnk.springboot.domain.User;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collections;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {
    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        User basicUser = new User("Basic User", "user@company.com", "password", "");

        return new InMemoryUserDetailsManager(Collections.singletonList(
                basicUser
        ));
    }
}
