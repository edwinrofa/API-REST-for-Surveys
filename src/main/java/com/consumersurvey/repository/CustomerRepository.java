package com.consumersurvey.repository;

import com.consumersurvey.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByIdentification(String identification);
}
