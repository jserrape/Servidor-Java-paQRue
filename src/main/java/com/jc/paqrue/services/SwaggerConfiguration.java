package com.jc.paqrue.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration of swagger
 * 
 * @author jserrape
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(usersApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.jc.paqrue.controller")).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo usersApiInfo() {
		return new ApiInfoBuilder().title("Soy el titulo").description("Soy la descripcion")
				.version("Soy la version").license("Soy la licencia").build();
	}

	@Bean
	UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder().operationsSorter(OperationsSorter.METHOD).build();
	}

}
