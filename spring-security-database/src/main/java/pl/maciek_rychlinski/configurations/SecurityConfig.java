package pl.maciek_rychlinski.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .withUser("admin").password("{noop}admin98").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
       httpSecurity
               .authorizeRequests()
               .antMatchers("/").permitAll()
               .anyRequest().authenticated()
               .and()
               .formLogin();
    }
}
