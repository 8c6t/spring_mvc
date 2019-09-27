package com.hachicore.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

}