package com.consumersurvey.service;

import com.consumersurvey.model.CustomerSurvey;
import com.consumersurvey.model.Survey;

public interface SurveyService {

    String register(CustomerSurvey customerSurvey);
    Survey getDefaultSurvey();
    Survey saveSurvey(Survey survey);
}
