package com.consumersurvey.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import com.consumersurvey.model.Customer;
import com.consumersurvey.model.CustomerResponse;
import com.consumersurvey.model.CustomerSurvey;
import com.consumersurvey.model.Options;
import com.consumersurvey.model.Survey;
import com.consumersurvey.repository.CustomerRepository;
import com.consumersurvey.repository.CustomerSurveyRepository;
import com.consumersurvey.repository.SurveyRepository;
import java.util.Optional;

import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
public class SurveyServiceImplTest {

    @Mock
    private CustomerSurveyRepository customerSurveyRepository;

    @Mock
    private SurveyRepository surveyRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private SurveyServiceImpl surveyService;

    @BeforeEach
    public void initService() {
        customerSurveyRepository = mock(CustomerSurveyRepository.class);
        surveyRepository = mock(SurveyRepository.class);
        customerRepository = mock(CustomerRepository.class);
    }
    
    @Test
    public void registerCustomerSurveyWithNewCustomerTest() {
    	CustomerResponse cr = new CustomerResponse();
    	cr.setId(2);
    	cr.setOption(new Options());
    	List<CustomerResponse> lcr = new ArrayList<>();
    	lcr.add(cr);
    	Customer customer = new Customer();
    	customer.setIdentification("1234567");
    	CustomerSurvey customerSurvey = new CustomerSurvey();
    	customerSurvey.setCustomer(customer);
    	customerSurvey.setCustomerResponseList(lcr);
    	when(customerRepository.findByIdentification(any(String.class))).thenReturn(null);
    	when(customerRepository.saveAndFlush(any(Customer.class))).thenReturn(customer);
    	when(customerSurveyRepository.saveAndFlush(any(CustomerSurvey.class))).thenReturn(customerSurvey);
    	assertEquals("Survey registered", surveyService.register(customerSurvey));
    }

    @Test
    public void registerCustomerSurveyWithExistingCustomerTest() {
    	Customer customer = new Customer();
    	customer.setIdentification("1234567");
    	CustomerSurvey customerSurvey = new CustomerSurvey();
    	customerSurvey.setCustomer(customer);
    	when(customerRepository.findByIdentification(any(String.class))).thenReturn(customer);
    	assertEquals("Existing user", surveyService.register(customerSurvey));
    }
    
    @Test
    public void registerCustomerDataErrorTest() {    	
    	CustomerSurvey customerSurvey = new CustomerSurvey();
    	assertEquals("Data error", surveyService.register(customerSurvey));
    }   

    @Test
    public void defaultSurveyTest() {
        when(surveyRepository.findById(anyInt())).thenReturn(Optional.of(new Survey()));
        assertNotNull(surveyService.getDefaultSurvey());
    }
    
    @Test
    public void saveSurveyTest() {
    	when(surveyRepository.saveAndFlush(any(Survey.class))).thenReturn(new Survey());
    	assertNotNull(surveyService.saveSurvey(new Survey()));
    }

}
