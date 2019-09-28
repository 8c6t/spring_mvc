package com.hachicore.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EventController {

    @GetMapping("/events")
    public String events() {
        return "events";
    }

    @GetMapping("/events/{id}")
    // @PathVariable("id") int idValue
    public String eventsWithId(@PathVariable int id) {
        return "events";
    }

    @DeleteMapping("/events/{id}")
    public String deleteEvent(@PathVariable int id) {
        return "events";
    }
}
