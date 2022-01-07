package com.consumersurvey.repository;

import com.consumersurvey.model.Options;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Options, Integer>{
    
}
