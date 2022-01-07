package com.consumersurvey.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(min = 4, max = 100)
    @Column(name = "survey_name", nullable = false)
    private String surveyName;
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "survey", fetch = FetchType.LAZY)
    private List<CustomerSurvey> customerSurveyList;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "survey", fetch = FetchType.LAZY)
    private List<Question> questionList;

    public Survey() {
    }

    public Survey(Integer id) {
        this.id = id;
    }

    public Survey(Integer id, String surveyName) {
        this.id = id;
        this.surveyName = surveyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public List<CustomerSurvey> getCustomerSurveyList() {
        return customerSurveyList;
    }

    public void setCustomerSurveyList(List<CustomerSurvey> customerSurveyList) {
        this.customerSurveyList = customerSurveyList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Survey)) {
            return false;
        }
        Survey other = (Survey) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.consumersurvey.model.Survey[ id=" + id + " ]";
    }
    
}
