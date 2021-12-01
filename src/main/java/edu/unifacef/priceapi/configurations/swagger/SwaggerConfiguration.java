package edu.unifacef.priceapi.configurations.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  private static final String BASE_PACKAGE = "edu.unifacef.priceapi.gateways.inputs.http";

  @Bean
  public Docket apis() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
        .paths(PathSelectors.any())
        .build()
        .pathMapping("/")
        .groupName("price-api")
        .useDefaultResponseMessages(false)
        .apiInfo(getApiInfo());
  }

  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
        .title("Unifacef - Price Api")
        .description("APIs para cadastro de preços")
        .version("1")
        .build();
  }
}
