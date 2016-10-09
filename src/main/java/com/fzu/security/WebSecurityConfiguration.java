package com.fzu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();
    }

    /*
     * 认证是由AuthenticationManager来管理的，但是真正进行认证的是AuthenticationManager中定义的
     * AuthenticationProvider。AuthenticationManager中可以定义有多个AuthenticationProvider。
     * 当我们使用authentication-provider元素来定义一个AuthenticationProvider时，
     * 如果没有指定对应关联的AuthenticationProvider对象，
     * Spring Security默认会使用DaoAuthenticationProvider。
     * DaoAuthenticationProvider在进行认证的时候需要一个UserDetailsService
     * 来获取用户的信息UserDetails，其中包括用户名、密码和所拥有的权限等。
     * 所以如果我们需要改变认证的方式，我们可以实现自己的AuthenticationProvider；
     * 如果需要改变认证的用户信息来源，我们可以实现UserDetailsService。
     */

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Configuration
    @Order(3)
    public static class UserWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        public UserDetailsService userDetailsService;

        @Bean
        public RememberMeServices rememberMeServices() throws Exception {
            TokenBasedRememberMeServices result = new TokenBasedRememberMeServices("hell0w0r1d", userDetailsService);
            result.setTokenValiditySeconds(2419200);
            return result;
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers(
                    "/i18n/**",
                    "/webjars/**",
                    "/public/**",
                    "/css/**",
                    "/js/**",
                    "/fonts/**",
                    "/img/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/", "/signin", "/explore", "/lastest", "/search", "/error").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/signin")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/")
                    .usernameParameter("email")
                    .passwordParameter("password").permitAll()
                .and()
                    .rememberMe()
                    .rememberMeServices(rememberMeServices())
                    .tokenValiditySeconds(2419200).key("hell0w0r1d")
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true);
        }

    }

}
