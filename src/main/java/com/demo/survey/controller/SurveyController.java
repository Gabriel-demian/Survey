package com.demo.survey.controller;

import com.demo.survey.dto.SurveyDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyController {

    @GetMapping("/surveyList")
    public String getAllSurveys(){

        return "All the surveys";
    }

    @GetMapping("/survey/{surveyId}")
    public String getSurvey(@PathVariable String surveyId){

        return "One survey id " + surveyId;
    }

    @PostMapping ("/survey/{surveyId}/{answerId}")
    public String sendAnswer(@PathVariable("surveyId") String surveyId, @PathVariable("answerId") String answerId){

        return "You sent the answer "+surveyId+" for the survey " + answerId;
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

    @PostMapping("/newSurvey")
    public String getAllSurveys(SurveyDto newSurvey){

        return "The survey was created";
    }


}
