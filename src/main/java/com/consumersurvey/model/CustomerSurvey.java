package com.consumersurvey.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CustomerSurvey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "date_survey", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateSurvey;
    @JoinColumn(name = "customer", referencedColumnName = "id", unique = true)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;
    @JoinColumn(name = "survey", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Survey survey;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerSurvey", fetch = FetchType.LAZY)
    private List<CustomerResponse> customerResponseList;

    public CustomerSurvey() {
    }

    public CustomerSurvey(Integer id) {
        this.id = id;
    }

    public CustomerSurvey(Integer id, Date dateSurvey) {
        this.id = id;
        this.dateSurvey = dateSurvey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateSurvey() {
        return dateSurvey;
    }

    public void setDateSurvey(Date dateSurvey) {
        this.dateSurvey = dateSurvey;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CustomerSurvey)) {
            return false;
        }
        CustomerSurvey other = (CustomerSurvey) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.consumersurvey.model.CustomerSurvey[ id=" + id + " ]";
    }
    
}
