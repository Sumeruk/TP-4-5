package ru.vsu.cs.springboot.security.config;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.vsu.cs.springboot.security.filter.JwtTokenFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class URLConfig {

    private final JwtTokenFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;


    private static final String[] AUTH_WHITELIST = {
            //"/**",
            "/",
            "/login",
            "/api/v1/auth/**",
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/swagger-ui/**",
            "/swagger-ui.html"
    };




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.headers().frameOptions().disable();

        httpSecurity.cors().and().csrf().disable();
        //@formatter:off
        httpSecurity
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers(AUTH_WHITELIST).permitAll()

                .requestMatchers("/api/products/adm/**")
                .hasAuthority("ROLE_Администратор")
                .requestMatchers("/api/employee/adm/**")
                .hasAuthority("ROLE_Администратор")

                .requestMatchers("/api/products/boss/**")
                .hasAuthority("ROLE_Начальник склада")
                .requestMatchers("/api/employee/boss/**")
                .hasAuthority("ROLE_Начальник склада")

                .requestMatchers("/api/products/allProducts")
                .hasAnyAuthority("ROLE_Администратор", "Администратор", "ROLE_Начальник склада")
                .requestMatchers("/api/products/allProducts/search**")
                .hasAnyAuthority("ROLE_Магазин", "ROLE_Начальник склада", "ROLE_Администратор")
                .requestMatchers("/api/products/allProducts/searchAllProducts")
                .hasAnyAuthority("ROLE_Магазин", "ROLE_Начальник склада")

                .requestMatchers("/api/order/boss/**")
                .hasAuthority("ROLE_Начальник склада")
                .requestMatchers("/api/order/shop/**")
                .hasAuthority("ROLE_Магазин")

                .requestMatchers("/api/order/getOrders/**")
                .hasAnyAuthority("ROLE_Магазин", "ROLE_Начальник склада", "ROLE_Кладовщик")

                .requestMatchers("/api/order/empl/**")
                .hasAuthority("ROLE_Кладовщик")



                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, authException)
                                -> response.sendError(
                                HttpServletResponse.SC_UNAUTHORIZED,
                                authException.getLocalizedMessage()
                        )
                )
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        //@formatter:on
        return httpSecurity.build();
    }
}
