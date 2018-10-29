package krk.smog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Enabling WEB MVC.
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
}
