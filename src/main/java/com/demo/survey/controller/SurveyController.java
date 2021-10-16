package com.demo.survey.controller;

import com.demo.survey.dto.SurveyDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurveyController {

    @PostMapping("/newSurvey")
    public String getAllSurveys(SurveyDto newSurvey){

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
    public SurveyDto getSurvey(@PathVariable String surveyId){

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
