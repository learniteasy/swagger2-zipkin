package com.learniteasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SwaggerDemoApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.learniteasy")).build();
	}

	/*
	 * private SecurityScheme securityScheme() { GrantType grantType = new
	 * AuthorizationCodeGrantBuilder() .tokenEndpoint(new TokenEndpoint(AUTH_SERVER
	 * + "/token", "oauthtoken")) .tokenRequestEndpoint(new
	 * TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_SECRET))
	 * .build();
	 * 
	 * SecurityScheme oauth = new
	 * OAuthBuilder().name("spring_oauth").grantTypes(Arrays.asList(grantType))
	 * .scopes(Arrays.asList(scopes())).build(); return oauth; }
	 * 
	 * @Bean public Docket api() { return new
	 * Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any
	 * ()) .paths(PathSelectors.any()).build().securitySchemes(Arrays.asList(
	 * securityScheme())) .securityContexts(Arrays.asList(securityContext())); }
	 * 
	 * @Bean public SecurityConfiguration security() { return
	 * SecurityConfigurationBuilder.builder().clientId(CLIENT_ID).clientSecret(
	 * CLIENT_SECRET)
	 * .scopeSeparator(" ").useBasicAuthenticationWithAccessCodeGrant(true).build();
	 * }
	 */


}