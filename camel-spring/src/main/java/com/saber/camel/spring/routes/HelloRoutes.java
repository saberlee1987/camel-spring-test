package com.saber.camel.spring.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;

@Component
public class HelloRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {


        rest("")
                .get("/hello")
                .id("hello-route")
                .description("Hello Service")
                .produces(MediaType.APPLICATION_JSON)
                .enableCORS(true)
                .bindingMode(RestBindingMode.off)
                .route()
                .routeId("hello-route")
                .setBody().simple("Hello Word")
                .setHeader(Exchange.HTTP_RESPONSE_CODE,constant(200));




    }
}
