package com.shablobank.app.security;

/**import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Melissa").password("helloworld").roles("GERANT")
                .and().withUser("Meldev").password("12345678").roles("ADMIN");
        //super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        super.configure(http);
    }
}**/
