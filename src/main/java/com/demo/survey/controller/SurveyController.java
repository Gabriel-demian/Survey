package com.demo.survey.controller;

import com.demo.survey.dto.SurveyDto;
import com.demo.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

        List<SurveyDto> list = surveyService.getAllSurveys();

        return list;
    }

    @GetMapping("/survey/user/{userName}")
    public List<SurveyDto> getSurveyByUser(@PathVariable String userName){

        List<SurveyDto> list = surveyService.getAllSurveysByUser(userName);

        return list;
    }

    @GetMapping("/survey/{surveyId}")
    public SurveyDto getSurveyById(@PathVariable String surveyId){

        SurveyDto survey = surveyService.getSurveyById(surveyId);

        if(survey == null){

        }

        return survey;
    }

    @GetMapping("/surveyList/label/{label}")
    public List<SurveyDto> getSurveysByLabel(@PathVariable("label") String label){

        List<SurveyDto> list = surveyService.getSurveysByLabel(label);

        return list;
    }

    /**
     * Se puede tomar la lista de encuestas, llevarlas a una lista,
     * ver el tamaño de la lista y elegir un número random entre 0 y el máximo de la lista para retornar.
     * Random r = new Random();
     * int low = 10;
     * int high = lista.maxLength;
     * int result = r.nextInt(high-low) + low;
     * @return String
     */
    @GetMapping("/randomSurvey")
    public SurveyDto getRandomSurvey(){

        SurveyDto survey = surveyService.getRandomSurvey();

        return survey;
    }




}
