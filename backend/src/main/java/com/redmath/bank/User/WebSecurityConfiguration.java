package com.redmath.bank.User;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Value("${spring.web.security.ignored:/error,/ui/**,/favicon.ico,/api/v1/account,/api/bank/login}")
    private String[] ignored = { "/error", "/ui/**", "/favicon.ico", "/api/v1/account", "/api/bank/login" };
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> {
            for(String ignore:ignored )
                web.ignoring().requestMatchers(AntPathRequestMatcher.antMatcher(ignore));
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(config -> config.successHandler((request, response, auth) -> {
        }));

                   // http.csrf().disable();
                http.formLogin().permitAll().defaultSuccessUrl("http://localhost:8080/Welcome");
//         http.formLogin().loginPage("/login")
//               .permitAll();
               http.authorizeHttpRequests(config -> config.anyRequest().authenticated());
               CookieCsrfTokenRepository csrfRepository = CookieCsrfTokenRepository.withHttpOnlyFalse();
               csrfRepository.setCookiePath("/");
               http.csrf().disable();
//                 .authorizeRequests()
//                 .anyRequest().permitAll();

//         http.csrf(config -> config.csrfTokenRepository(csrfRepository)
//                 .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler()));

//         http
//                 .authorizeRequests()
//                 .requestMatchers(new AntPathRequestMatcher("/login")).permitAll();
        return http.build();
    }
    // CORS Configuration
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8080"); // Allow requests from your frontend
        configuration.addAllowedMethod("*"); // Allow all HTTP methods
        configuration.addAllowedHeader("*"); // Allow all headers

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
