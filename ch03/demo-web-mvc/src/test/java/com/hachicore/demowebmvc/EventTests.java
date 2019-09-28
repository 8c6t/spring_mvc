package com.hachicore.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EventTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getEvents() throws Exception {
        mockMvc.perform(get("/events"))
                .andExpect(status().isOk());
    }

    @Test
    public void getEventsWithId() throws Exception {
        mockMvc.perform(get("/events/1"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/events/2"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/events/3"))
                .andExpect(status().isOk());
    }

    @Test
    public void createEvent() throws Exception {
        mockMvc.perform(post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteEvents() throws Exception {
        mockMvc.perform(delete("/events/1"))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/events/2"))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/events/3"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateEvent() throws Exception {
        mockMvc.perform(put("/events/1")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(put("/events/2")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(put("/events/3")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
