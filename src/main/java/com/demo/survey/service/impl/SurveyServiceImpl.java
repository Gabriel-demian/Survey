package com.demo.survey.service.impl;

import com.demo.survey.dto.SurveyDto;
import com.demo.survey.dto.mapper.AnswerMapper;
import com.demo.survey.dto.mapper.SurveyMapper;
import com.demo.survey.entity.AnswerEntity;
import com.demo.survey.entity.SurveyEntity;
import com.demo.survey.repository.SurveyRepository;
import com.demo.survey.service.SurveyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Log4j2
public class SurveyServiceImpl implements SurveyService {

    Random r = new Random();
    private SurveyRepository surveyRepo;

    @Autowired
    public void setSurveyRepository(SurveyRepository surveyRepo) {
        this.surveyRepo = surveyRepo;
    }


    /**
     * Una encuesta dura 7 días.
     */
    @Override
    public SurveyDto createNewSurvey(SurveyDto newSurvey) {

        SurveyMapper surveyMapper = new SurveyMapper();
        AnswerMapper answerMapper = new AnswerMapper();
        List<AnswerEntity> answerList = new ArrayList<>();

        SurveyEntity survey = new SurveyEntity();

        newSurvey.setExpirationDate(Timestamp.valueOf(LocalDateTime.now().plusDays(7)));

        survey = surveyMapper.fillEntity(survey, newSurvey);

        newSurvey.getAnswers().forEach( answerDto -> {
                    AnswerEntity answer = new AnswerEntity();
                    answerDto.setAnswerId(newSurvey.getSurveyId());
                    answerDto.setCounter(0);
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

        SurveyEntity sur = surveyRepo.findById(surveyId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        List<AnswerEntity> list = sur.getAnswers();

        list.forEach(answer -> {
            if (answer.getAnswerId().equals(answerId)){
                answer.setCounter(answer.getCounter()+1);
            }
        });

        surveyRepo.save(sur);
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
        SurveyMapper surveyMapper = new SurveyMapper();

        List<SurveyEntity> surveyList = surveyRepo.findSurveysByCreatedBy(userName);

        if(surveyList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return surveyMapper.getDto(surveyList);
    }

    @Override
    public SurveyDto getSurveyById(String surveyId) {

        SurveyMapper surveyMapper = new SurveyMapper();

        SurveyEntity sur = surveyRepo.findById(surveyId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        return surveyMapper.getDto(sur);
    }

    @Override
    public List<SurveyDto> getSurveysByLabel(String label) {

        SurveyMapper surveyMapper = new SurveyMapper();

        List<SurveyEntity> surveyList = surveyRepo.findSurveysByLabel(label);

        if(surveyList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return surveyMapper.getDto(surveyList);
    }


    @Override
    public SurveyDto getRandomSurvey() {
        SurveyMapper surveyMapper = new SurveyMapper();

        List<SurveyDto> randomList = surveyMapper.getDto(surveyRepo.findAll());

        if(randomList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return randomList.get(r.nextInt(randomList.size()));
    }

}
