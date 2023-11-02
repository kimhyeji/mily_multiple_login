//package com.mily.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig333 {
//
//    @Configuration
//    @Order(1)
//    public static class App1ConfigurationAdapter {
//        @Bean
//        public SecurityFilterChain filterChainApp1(HttpSecurity http) throws Exception {
//            http.authorizeHttpRequests(authorizeRequests ->
//                            authorizeRequests
//                                    .requestMatchers("/lawyer/**").hasRole("LAWYER")
//                                    .requestMatchers("/**").permitAll())
//                    .formLogin((formLogin) -> formLogin
//                            .loginPage("/lawyer/login")
//                            .loginProcessingUrl("/lawyer/login")
//                            .usernameParameter("lawyerLoginId")
//                            .passwordParameter("lawyerPassword")
//                            .successHandler(new CustomSimpleUrlAuthenticationSuccessHandler())
//                            .failureHandler(new CustomSimpleUrlAuthenticationFailureHandler()))
//
//                    .logout((logout) -> logout
//                            .logoutRequestMatcher(new AntPathRequestMatcher("/lawyer/logout"))
//                            .logoutSuccessUrl("/")
//                            .invalidateHttpSession(true))
//                    .csrf((csrf) -> csrf.disable());
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
//            http.authorizeHttpRequests(authorizeRequests ->
//                            authorizeRequests
//                                    .requestMatchers("/user/**").hasRole("USER")
//                                    .requestMatchers("/**").permitAll())
//
//                    .formLogin((formLogin) -> formLogin
//                            .loginPage("/user/login")
//                            .loginProcessingUrl("/user/login")
//                            .usernameParameter("userLoginId")
//                            .passwordParameter("userPassword")
//                            .successHandler(new CustomSimpleUrlAuthenticationSuccessHandler())
//                            .failureHandler(new CustomSimpleUrlAuthenticationFailureHandler()))
//
//                    .logout((logout) -> logout
//                            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//                            .logoutSuccessUrl("/")
//                            .invalidateHttpSession(true))
//                    .csrf((csrf) -> csrf.disable());
//            return http.build();
//        }
//    }
//
//    @Bean
//    public static PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//}