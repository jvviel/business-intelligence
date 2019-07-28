package br.edu.fema.bi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket detalheApi() {
 
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
 
		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.edu.fema.bi.controller"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build());
 
		return docket;
	}
 
	private ApiInfoBuilder informacoesApi() {
 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("API - Microsservices BI");
		apiInfoBuilder.description("API of microsservices for implements Business Intelligence");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Project for TCC");
		apiInfoBuilder.license("Open Source");
		apiInfoBuilder.licenseUrl("www.fema.edu.br");
		apiInfoBuilder.contact("João Victor Viel - joaoviel57@gmail.com");
 
		return apiInfoBuilder;
	}
}
