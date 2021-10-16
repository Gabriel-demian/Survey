package com.demo.survey.controller;

import com.demo.survey.dto.SurveyDto;
import com.demo.survey.service.impl.SurveyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurveyController {

    @Autowired
    private SurveyServiceImpl surveyServiceImpl;

    @PostMapping("/newSurvey")
    @ResponseStatus(HttpStatus.CREATED)
    public String newSurvey(@RequestBody SurveyDto newSurvey){

        surveyServiceImpl.createNewSurvey(newSurvey);
        return "The survey was created";
    }

    @PostMapping ("/survey/{surveyId}/{answerId}")
    public String sendAnswer(@PathVariable("surveyId") String surveyId, @PathVariable("answerId") String answerId){

        return "You sent the answer "+surveyId+" for the survey " + answerId;
    }

    @GetMapping("/surveyList")
    public List<SurveyDto> getAllSurveys(){

        return null;
    }

    @GetMapping("/survey/user/{userName}")
    public String getSurveyByUser(@PathVariable String userName){

        return "One survey by " + userName;
    }

    @GetMapping("/survey/{surveyId}")
    public SurveyDto getSurveyById(@PathVariable String surveyId){

        return null;
    }

    @GetMapping("/surveyList/label/{label}")
    public SurveyDto getSurveyByLabel(@PathVariable String surveyId){

        return null;
    }

    /**
     * Se puede tomar la lista de encuestas, llevarlas a una lista,
     * ver el tamaño de la lista y elegir un número random entre 0 y el máximo de la lista para retornar.
     * Random r = new Random();
     * int low = 10;
     * int high = lista.maxLength;
     * int result = r.nextInt(high-low) + low;
     * @return
     */
    @GetMapping("/randomSurvey")
    public String getRandomSurvey(){

        return "One random survey";
    }




}
