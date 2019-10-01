package com.hachicore.demowebmvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/events")
public class EventApi {

    @PostMapping
    public ResponseEntity<Event> createEvent(
            // HttpEntity<Event> request,
            @RequestBody @Valid Event event,
            BindingResult bindingResult
    ) {
        // save event

        // MediaType contetntType = request.getHeaders().getContentType();
        // System.out.println(contetntType);
        // return request.getBody();

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        // return ResponseEntity.ok(event);
        return new ResponseEntity<Event>(event, HttpStatus.CREATED); // 상태 코드 변경도 가능
    }
}
