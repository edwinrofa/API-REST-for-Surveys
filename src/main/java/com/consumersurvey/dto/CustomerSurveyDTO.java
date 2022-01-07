package com.consumersurvey.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class CustomerSurveyDTO {
    
    @ApiModelProperty(position = 0)
    private Date dateSurvey;
    @ApiModelProperty(position = 1)
    private CustomerDTO customer;
    @ApiModelProperty(position = 2)
    private Integer surveyId;
    @ApiModelProperty(position = 3)
    private List<CustomerResponseDTO> customerResponseList;
}
