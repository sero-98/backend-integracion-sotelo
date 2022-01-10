package com.dorian.PortalWebBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PortalWebBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalWebBackApplication.class, args);
	}

	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET","POST", "PUT", "DELETE", "PATCH")
						.allowedHeaders("*")
						.allowedOrigins(
								"http://localhost:4200/",
								"http://localhost:4200/estadisticas",
								"https://webportaljob.herokuapp.com/"
						);
			}
		};
	}*/

}
