package com.hachicore.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class EventUpdateController {

    @PutMapping("/events/{id}")
    @ResponseBody
    public String updateEvent(@PathVariable int id) {
        return "events";
    }

    @PostMapping("/events")
    @ResponseBody
    public String createEvent() {
        return "events";
    }

}
