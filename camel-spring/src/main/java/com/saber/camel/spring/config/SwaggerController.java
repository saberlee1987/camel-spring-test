package com.saber.camel.spring.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping(value = "/swagger")
    public String swagger(){

        return "redirect:/swagger-ui.html";
    }
}
