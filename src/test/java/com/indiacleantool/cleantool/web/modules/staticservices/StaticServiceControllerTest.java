package com.indiacleantool.cleantool.web.modules.staticservices;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class StaticServiceControllerTest {

    @Mock
    private StaticServiceRepository staticServiceRepository;

    @Mock
    private StaticServicesService staticServicesService;

    @InjectMocks
    private StaticServiceController staticServiceController;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(staticServiceController)
                 .build();
    }

    @Test
    public void testHelloWorld() throws Exception {

        mockMvc.perform(
                get("/api/services/hello")
        ).andExpect(status().isOk())
         .andExpect(content().string("Hello World"));
    }

    @Test
    public void testGetAllService() throws Exception {
        mockMvc.perform(
                get("/api/services/all")
        ).andExpect(status().isOk());
    }

}
