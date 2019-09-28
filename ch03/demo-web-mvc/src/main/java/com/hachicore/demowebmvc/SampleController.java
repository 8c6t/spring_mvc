package com.hachicore.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    // @GetMapping({ "/hello", "/hi" })
    // @GetMapping("/**")
    // @RequestMapping("/{name:[a-z]+}")
    @RequestMapping("/hachicore")
    @ResponseBody
    public String helloHachicore() {
        return "hello hachicore";
    }

    @RequestMapping(
            value = "/hello",
            // consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            // produces = MediaType.TEXT_PLAIN_VALUE
            // headers = HttpHeaders.AUTHORIZATION + "=" + "111"
            params = "name=hachicore"
    )
    @ResponseBody
    public String hello() {
        return "hello";
    }

}
