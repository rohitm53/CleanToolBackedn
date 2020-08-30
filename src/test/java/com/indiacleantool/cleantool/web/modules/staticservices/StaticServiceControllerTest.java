package com.indiacleantool.cleantool.web.modules.staticservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.indiacleantool.cleantool.web.domain.staticservice.Services;
import com.indiacleantool.cleantool.web.exceptions.MapValidationExceptionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class StaticServiceControllerTest {

    @Mock
    private MapValidationExceptionService mapValidationExceptionService;  // required to be injected to StaticServiceController in StaticServiceControllerTest

    @Mock
    private StaticServiceRepository staticServiceRepository;

    @Mock
    private StaticServicesService staticServicesService;

    @InjectMocks
    private StaticServiceController staticServiceController;

    private MockMvc mockMvc;

    private Services services1,services2;

    public void services1(){
        services1 = new Services();
        services1.setId((long)1);
        services1.setServiceCode("OC");
        services1.setServiceName("Office Cleaning");
        services1.setNoOfEmpReq(10);
        services1.setCreate_at(new Date());
        services1.setUpdated_at(new Date());
    }

    public void services2(){
        services2 = new Services();
        services2.setId((long)1);
        services2.setServiceCode("OC");
        services2.setServiceName("Office Cleaning");
        services2.setNoOfEmpReq(10);
        services2.setCreate_at(new Date());
        services2.setUpdated_at(new Date());
    }

    @Before
    public void setUp(){
        services1();
        services2();
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

    @Test
    public void testCreateNewService() throws Exception{

        mockMvc.perform(
                post("/api/services")
                .content(toJson(services1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andDo(print());

    }

    public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
