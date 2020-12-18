package store.idragon.product.usermanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xiaoshimei0305
 * date  2020/11/1 12:52 下午
 * description
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 创建swagger 初始化类
     * @return Docket 对象
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    /**
     * 定义api基本信息
     * @return 返回ApiInfo对象
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Interface manager API Doc")
                .description("This is a restful api document of interface manager")
                .version("1.0")
                .build();
    }

}
