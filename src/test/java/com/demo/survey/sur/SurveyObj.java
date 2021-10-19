package com.demo.survey.sur;

import com.demo.survey.dto.AnswerDto;
import com.demo.survey.dto.SurveyDto;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SurveyObj {



    public List<SurveyDto> surveyDtoList(){
        List<SurveyDto> list = new ArrayList<>();
        list.add(surveyTest());
        list.add(surveyTest2());

        return list;
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

    public SurveyDto surveyTest2(){
        SurveyDto test = new SurveyDto();

        List<AnswerDto> list = new ArrayList<>();

        AnswerDto answer1 = new AnswerDto();
        answer1.setAnswerId("5");
        answer1.setAnswer("I love it");
        answer1.setCounter(0);
        answer1.setPercentage(0.0);

        AnswerDto answer2 = new AnswerDto();
        answer2.setAnswerId("6");
        answer2.setAnswer("It is ok..");
        answer2.setCounter(0);
        answer2.setPercentage(0.0);

        AnswerDto answer3 = new AnswerDto();
        answer3.setAnswerId("7");
        answer3.setAnswer("Meee");
        answer3.setCounter(0);
        answer3.setPercentage(0.0);

        AnswerDto answer4 = new AnswerDto();
        answer4.setAnswerId("8");
        answer4.setAnswer("I hate it");
        answer4.setCounter(0);
        answer4.setPercentage(0.0);


        list.add(answer1);
        list.add(answer2);
        list.add(answer3);
        list.add(answer4);

        test.setSurveyId("test2");
        test.setSurvey("Do you like the color blue?");
        test.setAnswers(list);
        test.setLabel("colors");
        test.setCreatedBy("Gabi");
        test.setExpirationDate(Timestamp.from(Instant.now()));

        return test;
    }

}
