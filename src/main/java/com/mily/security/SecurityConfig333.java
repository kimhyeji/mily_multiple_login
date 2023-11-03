//package com.mily.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Configuration
//    @Order(2)
//    public static class App2ConfigurationAdapter {
//        @Bean
//        SecurityFilterChain lawyerFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeHttpRequests(authorizeHttpRequests ->
//                            authorizeHttpRequests
//                                    .requestMatchers("/lawyer/login").permitAll()
//                                    .requestMatchers("/lawyer/**").hasRole("LAWYER")
//                                    .requestMatchers("/**").permitAll())
//                    .csrf((csrf) -> csrf.disable())
//                    .headers((headers) -> headers
//                            .addHeaderWriter(new XFrameOptionsHeaderWriter(
//                                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
//                    .formLogin((formLogin) -> formLogin
//                            .loginPage("/lawyer/login")
//                            .loginProcessingUrl("/lawyer/login")
//                            .usernameParameter("lawyerLoginId")
//                            .passwordParameter("lawyerPassword")
//                            .successHandler(new CustomSimpleUrlAuthenticationSuccessHandler())
//                            .failureHandler(new CustomSimpleUrlAuthenticationFailureHandler()))
//                    .logout((logout) -> logout
//                            .logoutRequestMatcher(new AntPathRequestMatcher("/lawyer/logout"))
//                            .logoutSuccessUrl("/")
//                            .invalidateHttpSession(true))
//            ;
//            return http.build();
//        }
//    }
//    @Configuration
//    @Order(1)
//    public static class App1ConfigurationAdapter {
//        @Bean
//        SecurityFilterChain userFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeHttpRequests(authorizeHttpRequests ->
//                            authorizeHttpRequests
//                                    .requestMatchers("/user/login").permitAll()
//                                    .requestMatchers("/user/**").hasRole("USER")
//                                    .requestMatchers("/**").permitAll())
//                    .csrf((csrf) -> csrf.disable())
//                    .headers((headers) -> headers
//                            .addHeaderWriter(new XFrameOptionsHeaderWriter(
//                                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
//                    .formLogin((formLogin) -> formLogin
//                            .loginPage("/user/login")
//                            .loginProcessingUrl("/user/login")
//                            .usernameParameter("userLoginId")
//                            .passwordParameter("userPassword")
//                            .successHandler(new CustomSimpleUrlAuthenticationSuccessHandler())
//                            .failureHandler(new CustomSimpleUrlAuthenticationFailureHandler()))
//                    .logout((logout) -> logout
//                            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//                            .logoutSuccessUrl("/")
//                            .invalidateHttpSession(true))
//            ;
//            return http.build();
//        }
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User
//                .withUsername("user")
//                .password(encoder().encode("userPassword"))
//                .roles("USER")
//                .build());
//
//        manager.createUser(User
//                .withUsername("lawyer")
//                .password(encoder().encode("lawyerPassword"))
//                .roles("LAWYER")
//                .build());
//
//        return manager;
//    }
//
//    @Bean
//    public static PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//}