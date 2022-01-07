package com.consumersurvey.controller;

import com.consumersurvey.dto.CustomerSurveyDTO;
import com.consumersurvey.dto.SurveyDTO;
import com.consumersurvey.dto.SurveyResponsesDTO;
import com.consumersurvey.model.CustomerSurvey;
import com.consumersurvey.service.SurveyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survey")
@Api(tags = "survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/survey-register", 
    		consumes = "application/json;charset=UTF-8",
    		produces = "text/plain")
    @ApiOperation(value = "${SurveyController.surveyRegister}")
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Something went wrong"),
        @ApiResponse(code = 403, message = "Access denied")})
    public String surveyRegister(@ApiParam("Register Survey for Customers") @RequestBody CustomerSurveyDTO customerSurvey) {       
       return surveyService.register(modelMapper.map(customerSurvey, CustomerSurvey.class));
    }

    @GetMapping(value = "/show-survey", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "${SurveyController.showSurvey}", response = SurveyDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Something went wrong"),
        @ApiResponse(code = 403, message = "Access denied")})
    public SurveyDTO showSurvey(HttpServletRequest req) {
        return modelMapper.map(surveyService.getDefaultSurvey(), SurveyDTO.class);
    }

    @GetMapping(value = "/view-all-survey-responses", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "${SurveyController.viewAllSurveyResponses}", response = SurveyResponsesDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Something went wrong"),
        @ApiResponse(code = 403, message = "Access denied")})
    public SurveyResponsesDTO viewAllSurveyResponses(HttpServletRequest req) {
        return modelMapper.map(surveyService.getDefaultSurvey(), SurveyResponsesDTO.class);
    }

}
