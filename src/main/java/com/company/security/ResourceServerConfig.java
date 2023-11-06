package com.company.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .resourceId("elibrary")
                .tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .and()
                .authorizeRequests().antMatchers("/student/subscription").hasAnyAuthority("Student")
                .and()
                .authorizeRequests().antMatchers("/book/reading-history").hasAnyAuthority("Student", "Author")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,"/book").permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/book").hasAnyAuthority("Author")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.DELETE, "/book").hasAnyAuthority("Author")
                .and()
                .authorizeRequests().antMatchers("/books").permitAll()
                .and()
                .authorizeRequests().antMatchers("/student/books").hasAnyAuthority( "Student")
                .and()
                .authorizeRequests().antMatchers("/login").permitAll()
                .and()
                .authorizeRequests().antMatchers("/registration/author").hasAnyAuthority("Author")
                .and()
                .authorizeRequests().antMatchers("/registration/student").hasAnyAuthority("Student")
                .antMatchers("/actuator/**", "/api-docs/**").permitAll()
                .antMatchers("/**" ).authenticated();
    }
}
