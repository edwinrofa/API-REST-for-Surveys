package com.consumersurvey.repository;

import com.consumersurvey.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Integer>{
    
}
