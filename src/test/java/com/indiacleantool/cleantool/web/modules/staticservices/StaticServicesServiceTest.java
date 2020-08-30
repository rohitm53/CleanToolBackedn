package com.indiacleantool.cleantool.web.modules.staticservices;

import com.indiacleantool.cleantool.web.domain.staticservice.Services;
import com.indiacleantool.cleantool.web.exceptions.servicecode.ServiceCodeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

@ContextConfiguration
public class StaticServicesServiceTest {

    @Mock
    private StaticServiceRepository staticServiceRepository;

    @InjectMocks
    private StaticServicesService staticServicesService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Services services1;

    public void services1(){
        services1 = new Services();
        services1.setId((long)1);
        services1.setServiceCode("OC");
        services1.setServiceName("Office Cleaning");
        services1.setNoOfEmpReq(10);
        services1.setCreate_at(new Date());
        services1.setUpdated_at(new Date());
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        services1();
    }

    @Test
    public void testSaveOrUpdateServicePositive(){

        Mockito.when(staticServiceRepository.findById(services1.getId()).get()).thenReturn(null);
        Mockito.when(staticServiceRepository.save(services1)).thenReturn(services1);

        try{
            staticServicesService.saveOrUpdateService(services1);
        }catch (Exception e){
            Assert.fail("Exception : "+e);
        }
    }

    @Test
    public void testSaveOrUpdateServiceNegative() throws ServiceCodeException{
        expectedException.expect(ServiceCodeException.class);
        expectedException.expectMessage("Service code already existed");
        Mockito.when(staticServiceRepository.existsById(Mockito.anyLong())).thenReturn(true);
        staticServicesService.saveOrUpdateService(services1);

    }

}
