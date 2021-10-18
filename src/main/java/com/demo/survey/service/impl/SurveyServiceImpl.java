package com.demo.survey.service.impl;

import com.demo.survey.dto.AnswerDto;
import com.demo.survey.dto.SurveyDto;
import com.demo.survey.dto.mapper.AnswerMapper;
import com.demo.survey.dto.mapper.SurveyMapper;
import com.demo.survey.entity.Answer;
import com.demo.survey.entity.Survey;
import com.demo.survey.repository.AnswerRepository;
import com.demo.survey.repository.SurveyRepository;
import com.demo.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        SurveyMapper surveyMapper = new SurveyMapper();
        AnswerMapper answerMapper = new AnswerMapper();
        List<Answer> answerList = new ArrayList<>();

        Survey survey = new Survey();

        survey = surveyMapper.fillEntity(survey, newSurvey);

        newSurvey.getAnswers().forEach( (answerDto) -> {
                    Answer answer = new Answer();
                    answer = answerMapper.fillEntity(answer, answerDto);
                    answerList.add(answer);
                }
        );
        survey.setAnswers(answerList);

        surveyRepo.save(survey);

        return null;
    }

    @Override
    public void sendAnswer(String surveyId, String answerId) {

    }

    @Override
    public List<SurveyDto> getAllSurveys() {

        SurveyMapper surveyMapper = new SurveyMapper();
        List<SurveyDto> randomList = surveyMapper.getDto(surveyRepo.findAll());

        if(randomList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return randomList;
    }

    @Override
    public List<SurveyDto> getAllSurveysByUser(String userName) {
        return null;
    }

    @Override
    public SurveyDto getSurveyById(String surveyId) {

        SurveyMapper surveyMapper = new SurveyMapper();

        Survey sur = surveyRepo.findById(surveyId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        return surveyMapper.getDto(sur);
    }

    @Override
    public List<SurveyDto> getSurveysByLabel(String label) {
        return null;
    }


    @Override
    public SurveyDto getRandomSurvey() {
        SurveyMapper surveyMapper = new SurveyMapper();
        Random r = new Random();

        List<SurveyDto> randomList = surveyMapper.getDto(surveyRepo.findAll());

        if(randomList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        int index = r.nextInt(randomList.size());

        return randomList.get(index);
    }

}
