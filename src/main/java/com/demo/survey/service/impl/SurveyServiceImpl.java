package com.demo.survey.service.impl;

import com.demo.survey.dto.SurveyDto;
import com.demo.survey.repository.AnswerRepository;
import com.demo.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl {

    private AnswerRepository answerRepo;
    private SurveyRepository surveyRepo;

    @Autowired
    public void setSurveyRepository(AnswerRepository answerRepo) {
        this.answerRepo = answerRepo;
    }

    @Autowired
    public void setSurveyRepository(SurveyRepository surveyRepo) {
        this.surveyRepo = surveyRepo;
    }


    public void createNewSurvey(SurveyDto newSurvey) {

    }
}
