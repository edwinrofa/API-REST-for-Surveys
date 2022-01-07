package com.consumersurvey.model;

import java.io.Serializable;
import java.util.List;
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
public class Options implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(min = 4, max = 150)
    @Column(name = "option_multiple_selection", nullable = false)
    private String optionMultipleSelection;
    @OneToMany(mappedBy = "option", fetch = FetchType.LAZY)
    private List<CustomerResponse> customerResponseList;
    @JoinColumn(name = "question", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Question question;

    public Options() {
    }

    public Options(Integer id) {
        this.id = id;
    }

    public Options(String optionMultipleSelection, Question question) {
        this.optionMultipleSelection = optionMultipleSelection;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptionMultipleSelection() {
        return optionMultipleSelection;
    }

    public void setOptionMultipleSelection(String optionMultipleSelection) {
        this.optionMultipleSelection = optionMultipleSelection;
    }

    public List<CustomerResponse> getCustomerResponseList() {
        return customerResponseList;
    }

    public void setCustomerResponseList(List<CustomerResponse> customerResponseList) {
        this.customerResponseList = customerResponseList;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Options)) {
            return false;
        }
        Options other = (Options) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.consumersurvey.model.Option[ id=" + id + " ]";
    }
    
}
