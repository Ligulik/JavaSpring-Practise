package pl.maciek_rychlinski.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()

                // Każde odwołanie do strony głównej jest dozwolone
                .antMatchers("/").permitAll()

                // Odwołanie do każdej innej strony poza loginfrom, processlogin i logmeout jest
                // zabezpieczone (ponieważ te strony mają "permit all"
                .anyRequest().authenticated()

                .and()
                .formLogin().
                    loginPage("/loginform").
                    permitAll().
                    loginProcessingUrl("/processlogin").
                    permitAll().

                //zmiana nazwy parametrow w formularzu
                        usernameParameter("user").
                        passwordParameter("pass").
                            and().
                            logout().
                            logoutUrl("/logmeout").
                            logoutSuccessUrl("/").
                            permitAll();
    }
}
