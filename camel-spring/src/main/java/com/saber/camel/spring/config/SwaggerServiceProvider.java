package com.saber.camel.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@Primary
public class SwaggerServiceProvider implements SwaggerResourcesProvider {

    @Autowired
    private SwaggerConfig swaggerConfig;
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> swaggerResourceList = new ArrayList<>();

        for (SwaggerConfig.SwaggerService swaggerService : swaggerConfig.getServices()) {
            swaggerResourceList.add(swaggerResource(swaggerService.getName(),swaggerService.getUrl(),swaggerService.getVersion()));
        }
        return swaggerResourceList;
    }

    private SwaggerResource swaggerResource(String name, String url, String version){
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setUrl(url);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
