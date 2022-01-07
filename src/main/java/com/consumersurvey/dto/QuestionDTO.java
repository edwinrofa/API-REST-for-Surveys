package com.consumersurvey.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
public class QuestionDTO {

    public static final String MULTIPLE_CHOICE = "multiple_choice";
    public static final String OPEN = "open";

    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String questionType;
    @ApiModelProperty(position = 2)
    private String questionDescription;
    @ApiModelProperty(position = 3)
    private Integer surveyId;
    @ApiModelProperty(position = 4)
    private List<OptionsDTO> optionList;
}
