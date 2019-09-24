package kz.webdogovor.config;

import kz.webdogovor.config.web.AuthSuccessHandler;
import kz.webdogovor.config.web.LoggingAccessDeniedHandler;
import kz.webdogovor.config.web.SelfUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@ComponentScan("kz.webdogovor")
public class SecureConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SelfUserDetailsService selfUserDetailsService;

    @Autowired
    private LoggingAccessDeniedHandler loggingAccessDeniedHandler;

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    /**
     * Конфигурация ролей пользователей
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(selfUserDetailsService)
            .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    /**
     * Конфигурация http и доступ к страницам
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(
                            "/api/**"
                            ).permitAll()
                    .antMatchers(
                            "/superuser/**"
                    ).hasAnyAuthority("SUPERUSER")
                    .antMatchers(
                            "/operator/**"
                    ).hasAnyAuthority("OPERATOR")
                    .antMatchers(
                            "/user/**"
                    ).hasAnyAuthority("USER")
                    .antMatchers(
                            "/"
                    ).anonymous()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/")
                    .usernameParameter("login")
                    .passwordParameter("password")
                    .successHandler(authSuccessHandler)
                    .failureUrl("/?error")
                .and()
                    .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/?logout")
                .and()
                    .exceptionHandling()
                        .accessDeniedHandler(loggingAccessDeniedHandler);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/libs/**", "/css/**", "/js/**", "/images/**", "/webjars/**");
    }
}
