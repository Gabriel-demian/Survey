package com.demo.survey.service.impl;

import com.demo.survey.dto.SurveyDto;
import com.demo.survey.repository.AnswerRepository;
import com.demo.survey.repository.SurveyRepository;
import com.demo.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {

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


    @Override
    public SurveyDto createNewSurvey(SurveyDto newSurvey) {
        return null;
    }

    @Override
    public void sendAnswer(String surveyId, String answerId) {

    }

    @Override
    public List<SurveyDto> getAllSurveys() {
        return null;
    }

    @Override
    public List<SurveyDto> getAllSurveysByUser(String userName) {
        return null;
    }

    @Override
    public SurveyDto getSurveyById(String surveyId) {
        return null;
    }

    @Override
    public List<SurveyDto> getSurveysByLabel(String label) {
        return null;
    }

    @Override
    public SurveyDto getRandomSurvey() {
        return null;
    }
}
