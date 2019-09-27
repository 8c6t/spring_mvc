package com.hachicore.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class SampleController {

    // @GetMapping({ "/hello", "/hi" })
    // @GetMapping("/**")
    // @RequestMapping("/{name:[a-z]+}")
    @RequestMapping("/hachicore")
    @ResponseBody
    public String helloHachicore() {
        return "hello hachicore";
    }

/*
    @RequestMapping("/**")
    @ResponseBody
    public String hello() {
        return "hello";
    }
*/

}
