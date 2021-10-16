package com.demo.survey.service;

import com.demo.survey.dto.SurveyDto;

import java.util.List;

public interface SurveyService {

    SurveyDto createNewSurvey(SurveyDto newSurvey);

    void sendAnswer(String surveyId, String answerId);

    List<SurveyDto> getAllSurveys();

    List<SurveyDto> getAllSurveysByUser(String userName);

    SurveyDto getSurveyById(String surveyId);

    List<SurveyDto> getSurveysByLabel(String label);

    SurveyDto getRandomSurvey();
}
