package com.consumersurvey.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OptionsDTO {

    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String optionMultipleSelection;
    @ApiModelProperty(position = 2)
    private Integer questionId;
}
