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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(min = 4, max = 16)
    @Column(name = "question_type", nullable = false)
    private String questionType;
    @Size(min = 4, max = 200)
    @Column(name = "question_description", nullable = false)
    private String questionDescription;
    @JoinColumn(name = "survey", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Survey survey;
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "question", fetch = FetchType.LAZY)
    private List<CustomerResponse> customerResponseList;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "question", fetch = FetchType.LAZY)
    private List<Options> optionList;

    public Question() {
    }

    public Question(Integer id) {
        this.id = id;
    }

    public Question(String questionType, String questionDescription, Survey survey) {
        this.questionType = questionType;
        this.questionDescription = questionDescription;
        this.survey = survey;
    }
    
    public Question(String questionType, String questionDescription, List<Options> optionList, Survey survey) {
        this.questionType = questionType;
        this.questionDescription = questionDescription;
        this.optionList = optionList;
        this.survey = survey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<CustomerResponse> getCustomerResponseList() {
        return customerResponseList;
    }

    public void setCustomerResponseList(List<CustomerResponse> customerResponseList) {
        this.customerResponseList = customerResponseList;
    }

    public List<Options> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Options> optionList) {
        this.optionList = optionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.consumersurvey.model.Question[ id=" + id + " ]";
    }
    
}
