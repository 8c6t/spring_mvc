package com.hachicore.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(get("/hello/hachicore"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello hachicore"))
                .andExpect(handler().handlerType(SampleController.class))
                .andExpect(handler().methodName("helloHachicore"))
        ;

        /*
        mockMvc.perform(get("/hi"))
                .andDo(print())
                .andExpect(status().isOk())
        ;*/

        mockMvc.perform(get("/hello/hachicore.xml"))
                .andDo(print())
                .andExpect(status().isNotFound())
        ;
    }

    @Test
    public void consumeTest() throws Exception {
        mockMvc.perform(get("/hello")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void producesTest() throws Exception {
        mockMvc.perform(get("/hello")
                .contentType(MediaType.APPLICATION_JSON))
                // .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void headerTest() throws Exception {
        mockMvc.perform(get("/hello")
                .header(HttpHeaders.AUTHORIZATION, "111"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void paramsTest() throws Exception {
        mockMvc.perform(get("/hello")
                    .param("name", "hachicore"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void headTest() throws Exception {
        mockMvc.perform(head("/hello")
                .param("name", "hachicore"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void optionsTest() throws Exception {
        mockMvc.perform(options("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().stringValues(HttpHeaders.ALLOW,
                        hasItems(
                                containsString("GET"),
                                containsString("POST"),
                                containsString("HEAD"),
                                containsString("OPTIONS")
                                )))
        ;
    }
}
