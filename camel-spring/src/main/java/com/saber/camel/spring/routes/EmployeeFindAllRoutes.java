package com.saber.camel.spring.routes;

import com.saber.camel.spring.dto.EmployeeResponse;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;

@Component
public class EmployeeFindAllRoutes extends RouteBuilder {

    @Value(value = "${service.employee.url}")
    private String employeeUrl;
    @Value(value = "${service.employee.port}")
    private String employeePort;
    @Value(value = "${service.employee.endpoint}")
    private String employeeEndpoint;


    @Override
    public void configure() throws Exception {

        rest("/employee")
                .get("/findAll")
                .id(Routes.EMPLOYEE_FIND_ALL)
                .description("employee find all Service")
                .consumes(MediaType.APPLICATION_JSON)
                .produces(MediaType.APPLICATION_JSON)
                .responseMessage().code(200).responseModel(EmployeeResponse.class).example("example1","").endResponseMessage()
                .bindingMode(RestBindingMode.json)
                .enableCORS(true)
                .route()
                .routeId(Routes.EMPLOYEE_FIND_ALL)
                .to("direct:employee-find-all-gateway");

        from("direct:employee-find-all-gateway")
                .id("employee-find-all-gateway")
                .to(employeeUrl+":"+employeePort+employeeEndpoint+"?bridgeEndpoint=true")
                .convertBodyTo(String.class)
                .unmarshal().json(JsonLibrary.Jackson,EmployeeResponse.class)
                .setHeader(Exchange.HTTP_RESPONSE_CODE,constant(200));
    }
}
