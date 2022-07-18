package com.rp;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/**/**");
        web.ignoring().antMatchers("/images/**");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/users");
        web.ignoring().antMatchers(HttpMethod.GET, "/doc/**");
        web.ignoring().antMatchers(HttpMethod.GET, "/v2/api-docs");
        web.ignoring().antMatchers(HttpMethod.GET, "/swagger-resources/**");
    }

}
