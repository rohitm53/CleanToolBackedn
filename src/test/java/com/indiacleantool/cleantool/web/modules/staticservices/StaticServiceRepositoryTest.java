package com.indiacleantool.cleantool.web.modules.staticservices;

import com.indiacleantool.cleantool.web.domain.staticservice.Services;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StaticServiceRepositoryTest {


    @Mock
    private StaticServiceRepository staticServiceRepository;

    private Services services1,services2;

    private String serviceCode = "serviceCode";

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
        services2.setId((long)2);
        services2.setServiceCode("HC");
        services2.setServiceName("House Cleaning");
        services2.setNoOfEmpReq(10);
        services2.setCreate_at(new Date());
        services2.setUpdated_at(new Date());
    }

    @Before
    public void setUp(){
        services1();
        services2();
    }

    @Test
    public void testSave(){

        Mockito.when(staticServiceRepository.save(services1)).thenReturn(services1);
        Services dbService = staticServiceRepository.save(services1);
        assertThat(dbService).hasFieldOrPropertyWithValue(serviceCode,"OC");

        Mockito.when(staticServiceRepository.save(services2)).thenReturn(new Services());
        dbService = staticServiceRepository.save(services2);
        assertThat(dbService).hasFieldOrPropertyWithValue(serviceCode,null);

    }

    @Test
    public void testFindById(){
        Mockito.when(staticServiceRepository.findById(services2.getId()).get()).thenReturn(services2);
        Services dbService = staticServiceRepository.findById(services2.getId()).get();
        assertThat(dbService).hasFieldOrPropertyWithValue(serviceCode,"HC");

    }

}
