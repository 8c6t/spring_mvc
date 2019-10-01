package com.hachicore.demowebmvc;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @PostMapping
    public Event createEvent(
            // HttpEntity<Event> request,
            @RequestBody @Valid Event event,
            BindingResult bindingResult
    ) {
        // save event
        // MediaType contetntType = request.getHeaders().getContentType();
        // System.out.println(contetntType);
        // return request.getBody();

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error);
            });
        }

        return event;

    }
}
