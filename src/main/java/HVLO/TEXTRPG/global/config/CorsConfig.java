package HVLO.TEXTRPG.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {


    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true); // 인증 정보를 포함 허용
        config.addAllowedOrigin("http://localhost:3000"); // 허용할 출처
        config.addAllowedHeader("*"); // 허용할 헤더
        config.addAllowedMethod("*"); // 허용할 메서드 (GET, POST, PUT, DELETE, OPTIONS 등)

        source.registerCorsConfiguration("/**", config); // 모든 경로에 CORS 설정 적용
        return new CorsFilter(source);
    }
}
