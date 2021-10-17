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
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
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
        return null;
    }

    @Override
    public List<SurveyDto> getAllSurveysByUser(String userName) {
        return null;
    }

    @Override
    public SurveyDto getSurveyById(String surveyId) {

        SurveyDto survey =  surveyTest();

        return survey;
    }

    @Override
    public List<SurveyDto> getSurveysByLabel(String label) {
        return null;
    }

    @Override
    public SurveyDto getRandomSurvey() {
        return null;
    }


    public SurveyDto surveyTest(){
        SurveyDto test = new SurveyDto();

        List<AnswerDto> list = new ArrayList<>();

        AnswerDto answer1 = new AnswerDto();
        answer1.setAnswerId("1");
        answer1.setAnswer("I love it");
        answer1.setCounter(0);
        answer1.setPercentage(0.0);

        AnswerDto answer2 = new AnswerDto();
        answer2.setAnswerId("2");
        answer2.setAnswer("It is ok..");
        answer2.setCounter(0);
        answer2.setPercentage(0.0);

        AnswerDto answer3 = new AnswerDto();
        answer3.setAnswerId("3");
        answer3.setAnswer("Meee");
        answer3.setCounter(0);
        answer3.setPercentage(0.0);

        AnswerDto answer4 = new AnswerDto();
        answer4.setAnswerId("4");
        answer4.setAnswer("I hate it");
        answer4.setCounter(0);
        answer4.setPercentage(0.0);


        list.add(answer1);
        list.add(answer2);
        list.add(answer3);
        list.add(answer4);

        test.setSurveyId("test1");
        test.setSurvey("Do you like the color red?");
        test.setAnswers(list);
        test.setLabel("colors");
        test.setCreatedBy("Gabi");
        test.setExpirationDate(Timestamp.from(Instant.now()));

        return test;
    }
}
