package com.consumersurvey.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerResponseDTO {    

    @ApiModelProperty(position = 0)
    private String openResponse;
    @ApiModelProperty(position = 1)
    private Integer customerSurveyId;
    @ApiModelProperty(position = 2)
    private OptionsDTO option;
    @ApiModelProperty(position = 3)
    private Integer questionId;
}
