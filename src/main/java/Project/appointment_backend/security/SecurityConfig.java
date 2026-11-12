package Project.appointment_backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(s->s.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS)).authorizeHttpRequests(auth->auth
                        .requestMatchers ("/api/v1/signup/**",
                                "/api/v1/login/**",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html").permitAll()
                        .requestMatchers("/api/v1/doctors/**".hasAnyRole("DOCTOR", "ADMIN")
                        .anyRequest().authenticated());
                return httpSecurity.build();
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
