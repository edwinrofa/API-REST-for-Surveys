package com.consumersurvey.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@Data
public class CustomerDTO {    

    @ApiModelProperty(position = 0)
    private String name;
    @ApiModelProperty(position = 1)
    private String lastname;
    @ApiModelProperty(position = 2)
    private String identification;
    @ApiModelProperty(position = 3)
    private Date registrationDate;
}
