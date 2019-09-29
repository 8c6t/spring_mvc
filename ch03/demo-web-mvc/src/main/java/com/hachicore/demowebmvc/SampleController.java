package com.hachicore.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class SampleController {

    @PostMapping("/events/name/{name}")
    @ResponseBody
    public Event postEvent(@Valid @ModelAttribute Event event, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("==================");
            bindingResult.getAllErrors().forEach(e -> {
                System.out.println(e);
            });
        }
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
