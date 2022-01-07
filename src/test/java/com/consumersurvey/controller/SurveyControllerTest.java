package com.consumersurvey.controller;

import com.consumersurvey.ConsumerSurveyApplication;
import com.consumersurvey.dto.CustomerSurveyDTO;
import com.consumersurvey.dto.SurveyDTO;
import com.consumersurvey.dto.SurveyResponsesDTO;
import com.consumersurvey.model.CustomerSurvey;
import com.consumersurvey.model.Survey;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.consumersurvey.service.SurveyService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConsumerSurveyApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SurveyControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    SurveyController controller;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Mock
    private SurveyService surveyService;

    @Mock
    private ModelMapper modelMapper;
    
    @Test
    public void testSurveyRegister() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        reset(modelMapper, surveyService);
        when(modelMapper.map(new CustomerSurveyDTO(), CustomerSurvey.class)).thenReturn(new CustomerSurvey());
        when(surveyService.register(new CustomerSurvey())).thenReturn("value");       
        assertNotNull(controller.surveyRegister(new CustomerSurveyDTO()));
    }
    
    @Test
    public void testShowSurvey() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        reset(modelMapper, surveyService);
        when(surveyService.getDefaultSurvey()).thenReturn(new Survey());
        when(modelMapper.map(new Survey(), SurveyDTO.class)).thenReturn(new SurveyDTO());
        assertNotNull(controller.showSurvey(request));
    }

    @Test
    public void testSurveyResponses() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        reset(modelMapper, surveyService);
        when(surveyService.getDefaultSurvey()).thenReturn(new Survey());
        when(modelMapper.map(new Survey(), SurveyResponsesDTO.class)).thenReturn(new SurveyResponsesDTO());
        assertNotNull(controller.viewAllSurveyResponses(request));
    }

    @Test
    public void test404BadRequest() throws Exception {
        when(surveyService.getDefaultSurvey()).thenReturn(new Survey());
        when(modelMapper.map(new Survey(), SurveyDTO.class)).thenReturn(new SurveyDTO());
        this.mockMvc.perform(get("/bad-request").accept(MediaType.APPLICATION_JSON)).andExpect(status().is(404));
    }

}
