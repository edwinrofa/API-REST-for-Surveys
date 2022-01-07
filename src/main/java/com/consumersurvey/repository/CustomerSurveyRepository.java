package com.consumersurvey.repository;

import com.consumersurvey.model.CustomerSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSurveyRepository extends JpaRepository<CustomerSurvey, Integer>{
    
}
