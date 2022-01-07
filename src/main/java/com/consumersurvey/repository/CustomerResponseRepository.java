package com.consumersurvey.repository;

import com.consumersurvey.model.CustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerResponseRepository extends JpaRepository<CustomerResponse, Integer>{
    
}
