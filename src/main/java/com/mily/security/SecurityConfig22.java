package com.mily.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
public class SecurityConfig22 {
//    @Configuration
//    @Order(1)
//    public static class App1ConfigurationAdapter {
//
//        @Bean
//        public SecurityFilterChain filterChainApp1(HttpSecurity http) throws Exception {
//            http.antMatcher("/admin*")
//                    .authorizeRequests()
//                    .anyRequest()
//                    .hasRole("ADMIN")
//
//                    .and()
//                    .formLogin()
//                    .loginPage("/loginAdmin")
//                    .loginProcessingUrl("/admin_login")
//                    .failureUrl("/loginAdmin?error=loginError")
//                    .defaultSuccessUrl("/adminPage")
//
//                    .and()
//                    .logout()
//                    .logoutUrl("/admin_logout")
//                    .logoutSuccessUrl("/protectedLinks")
//                    .deleteCookies("JSESSIONID")
//
//                    .and()
//                    .exceptionHandling()
//                    .accessDeniedPage("/403")
//
//                    .and()
//                    .csrf().disable();
//            return http.build();
//        }
//    }
//
//    @Configuration
//    @Order(2)
//    public static class App2ConfigurationAdapter {
//
//        @Bean
//        public SecurityFilterChain filterChainApp2(HttpSecurity http) throws Exception {
//            http.antMatcher("/user*")
//                    .authorizeRequests()
//                    .anyRequest()
//                    .hasRole("USER")
//
//                    .and()
//                    .formLogin()
//                    .loginPage("/loginUser")
//                    .loginProcessingUrl("/user_login")
//                    .failureUrl("/loginUser?error=loginError")
//                    .defaultSuccessUrl("/userPage")
//
//                    .and()
//                    .logout()
//                    .logoutUrl("/user_logout")
//                    .logoutSuccessUrl("/protectedLinks")
//                    .deleteCookies("JSESSIONID")
//
//                    .and()
//                    .exceptionHandling()
//                    .accessDeniedPage("/403")
//
//                    .and()
//                    .csrf().disable();
//            return http.build();
//        }
//    }
}