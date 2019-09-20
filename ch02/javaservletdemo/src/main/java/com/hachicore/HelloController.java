package com.hachicore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello/{id}")
    @ResponseBody
    public String hello(@RequestBody String body) {
        return "Hello, " + helloService.getName();
    }

    @GetMapping("/sample")
    public void smaple() {

    }

}
