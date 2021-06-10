package com.saber.camel.spring.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RouteDefinition extends RouteBuilder {

    @Value(value = "${service.api.base-path}")
    private String apiBasePath;
    @Value(value = "${service.log.is-pretty-print-enabled}")
    private String isPrettyPrint;

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .contextPath(apiBasePath)
                .enableCORS(true)
                .bindingMode(RestBindingMode.json)
                .apiContextPath("/v2/api-docs")
                .apiProperty("api.title","camel  Spring Service")
                .apiProperty("api.version","1.0")
                .apiContextRouteId("doc-api")
                .apiProperty("cors","true")
                .component("servlet")
                .dataFormatProperty("prettyPrint",isPrettyPrint);

    }
}
