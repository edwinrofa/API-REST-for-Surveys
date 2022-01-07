package com.consumersurvey.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
public class SurveyDTO {

    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String surveyName;
    @ApiModelProperty(position = 2)
    private List<QuestionDTO> questionList;
}
