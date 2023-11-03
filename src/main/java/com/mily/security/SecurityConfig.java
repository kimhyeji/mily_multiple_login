package com.mily.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class App2ConfigurationAdapter {
        @Bean
        SecurityFilterChain lawyerFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                            .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
                    .csrf((csrf) -> csrf.disable())
                    .headers((headers) -> headers
                            .addHeaderWriter(new XFrameOptionsHeaderWriter(
                                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
                    .formLogin((formLogin) -> formLogin
                            .loginPage("/lawyer/login")
                            .loginProcessingUrl("/lawyer/login")
                            .usernameParameter("lawyerLoginId")
                            .passwordParameter("lawyerPassword")
                            .successHandler(new CustomSimpleUrlAuthenticationSuccessHandler())
                            .failureHandler(new CustomSimpleUrlAuthenticationFailureHandler()))
                    .logout((logout) -> logout
                            .logoutRequestMatcher(new AntPathRequestMatcher("/lawyer/logout"))
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true))
            ;
            return http.build();
        }
    }
    @Configuration
    @Order(2)
    public static class App1ConfigurationAdapter {
        @Bean
        SecurityFilterChain userFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                            .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
                    .csrf((csrf) -> csrf.disable())
                    .headers((headers) -> headers
                            .addHeaderWriter(new XFrameOptionsHeaderWriter(
                                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
                    .formLogin((formLogin) -> formLogin
                            .loginPage("/user/login")
                            .loginProcessingUrl("/user/login")
                            .usernameParameter("userLoginId")
                            .passwordParameter("userPassword")
                            .successHandler(new CustomSimpleUrlAuthenticationSuccessHandler())
                            .failureHandler(new CustomSimpleUrlAuthenticationFailureHandler()))
                    .logout((logout) -> logout
                            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true))
            ;
            return http.build();
        }
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        var userDetailsService = new InMemoryUserDetailsManager();
        userDetailsService.createUser(User.builder()
                .username("user")
                .password(passwordEncoder.encode("userPassword"))
                .roles("USER")
                .build());
        userDetailsService.createUser(User.builder()
                .username("lawyer")
                .password(passwordEncoder.encode("lawyerPassword"))
                .roles("LAWYER")
                .build());
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}