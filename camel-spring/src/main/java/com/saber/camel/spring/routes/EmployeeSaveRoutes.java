package com.saber.camel.spring.routes;

import com.saber.camel.spring.dto.Employee;
import com.saber.camel.spring.dto.EmployeeDto;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;

@Component
public class EmployeeSaveRoutes extends RouteBuilder {

    @Value(value = "${service.employee.url}")
    private String employeeUrl;
    @Value(value = "${service.employee.port}")
    private String employeePort;
    @Value(value = "${service.employee.endpoint}")
    private String employeeEndpoint;


    @Override
    public void configure() throws Exception {

        rest("/employee")
                .post("/save")
                .id(Routes.EMPLOYEE_SAVE)
                .description("employee persist Service")
                .consumes(MediaType.APPLICATION_JSON)
                .produces(MediaType.APPLICATION_JSON)
                .responseMessage().code(200).responseModel(Employee.class).example("example1","").endResponseMessage()
                .bindingMode(RestBindingMode.json)
                .enableCORS(true)
                .type(EmployeeDto.class)
                .route()
                .routeId(Routes.EMPLOYEE_SAVE)
                .to("direct:employee-save-gateway");

        from("direct:employee-save-gateway")
                .id("employee-save-gateway")
                .log("Request for EMPLOYEE_SAVE with body ===> ${in.body}")
                .marshal().json(JsonLibrary.Jackson,EmployeeDto.class)
                .log("Request for EMPLOYEE_SAVE with body ===> ${in.body}")
                .to(employeeUrl+":"+employeePort+employeeEndpoint+"?bridgeEndpoint=true")
                .convertBodyTo(String.class)
                .unmarshal().json(JsonLibrary.Jackson,Employee.class)
                .setHeader(Exchange.HTTP_RESPONSE_CODE,constant(200));
    }
}
