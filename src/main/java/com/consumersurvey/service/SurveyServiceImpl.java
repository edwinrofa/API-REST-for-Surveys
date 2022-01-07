package com.consumersurvey.service;

import com.consumersurvey.model.Customer;
import com.consumersurvey.model.CustomerSurvey;
import com.consumersurvey.model.Survey;
import com.consumersurvey.repository.CustomerRepository;
import com.consumersurvey.repository.CustomerSurveyRepository;
import com.consumersurvey.repository.SurveyRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private CustomerSurveyRepository customerSurveyRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public String register(CustomerSurvey customerSurvey) {
        Customer customer = customerSurvey.getCustomer();
        if (customer != null) {
            if (customerRepository.findByIdentification(customer.getIdentification()) != null) {
                return "Existing user";
            }
            customer.setId(null);
            customer.setCustomerSurveyList(null);
            customer = customerRepository.saveAndFlush(customer);
            customerSurvey.setCustomer(customer);
            customerSurvey.setId(null);
            customerSurvey.getCustomerResponseList().forEach(cr -> {
                cr.setCustomerSurvey(customerSurvey);
                cr.setId(null);
            });
            customerSurveyRepository.saveAndFlush(customerSurvey);
            return "Survey registered";
        }
        return "Data error";

    }

    @Override
    public Survey getDefaultSurvey() {
        return surveyRepository.findById(1).orElse(new Survey());
    }

    @Override
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.saveAndFlush(survey);
    }

}
