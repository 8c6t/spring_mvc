package com.hachicore.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController {

    @PostMapping("/events")
    public String postEvent(@Validated @ModelAttribute Event event,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/events/form";
        }

        // save
        return "redirect:/events/list";
    }

    @GetMapping("/events/form")
    public String eventsForm(Model model) {
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "/events/form";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model) {
        Event event = new Event();
        event.setName("maitetsu");
        event.setLimit(8620);

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);

        model.addAttribute(eventList);

        return "/events/list";
    }

}
