package com.jc.paqrue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jc.paqrue.services.SwaggerConfiguration;



@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class ServerPaqrueApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(ServerPaqrueApplication.class, args);
	}

	/**
	 * Inicialice the path of Swagger
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	}
}
