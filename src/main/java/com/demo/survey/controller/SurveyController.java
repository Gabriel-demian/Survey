package com.demo.survey.controller;

import com.demo.survey.dto.SurveyDto;
import com.demo.survey.service.SurveyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @PostMapping("/newSurvey")
    @ResponseStatus(HttpStatus.CREATED)
    public SurveyDto newSurvey(@RequestBody SurveyDto newSurvey){
        return surveyService.createNewSurvey(newSurvey);
    }

    @PostMapping ("/survey/{surveyId}/{answerId}")
    public String sendAnswer(@PathVariable("surveyId") String surveyId, @PathVariable("answerId") String answerId){
        surveyService.sendAnswer(surveyId, answerId);
        return "You sent the answer "+surveyId+" for the survey " + answerId;
    }

    @GetMapping("/surveyList")
    public List<SurveyDto> getAllSurveys(){
        return surveyService.getAllSurveys();
    }

    @GetMapping("/surveyList/user/{userName}")
    public List<SurveyDto> getSurveyByUser(@PathVariable String userName){
        return surveyService.getAllSurveysByUser(userName);
    }

    @GetMapping("/survey/{surveyId}")
    public SurveyDto getSurveyById(@PathVariable String surveyId){
        return surveyService.getSurveyById(surveyId);
    }

    @GetMapping("/surveyList/label/{label}")
    public List<SurveyDto> getSurveysByLabel(@PathVariable("label") String label){
        return surveyService.getSurveysByLabel(label);
    }

    @GetMapping("/randomSurvey")
    public SurveyDto getRandomSurvey(){
        return surveyService.getRandomSurvey();
    }

}
