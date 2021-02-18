package app.lottery.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    
    /**
    * Habilita o "Cross-Origin Resourse Sharing (CORS)".
    * Mais informações em: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/cors.html
    */
    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http:localhost:3000");
    }
    
}
