package com.hachicore.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @PostMapping("/events")
    @ResponseBody
    public Event postEvent(
            @RequestParam String name,
            @RequestParam Integer limit
            // @RequestParam Map<String, String> params
    ) {
        Event event = new Event();
        event.setName(name);
        event.setLimit(limit);
        //event.setName(params.get("name"));
        return event;
    }

    @GetMapping("/events/form")
    public String eventsForm(Model model) {
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "/events/form";
    }

}
